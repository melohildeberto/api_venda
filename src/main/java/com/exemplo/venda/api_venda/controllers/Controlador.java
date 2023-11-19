package com.exemplo.venda.api_venda.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.venda.api_venda.dtos.ResponsePadraoDTO;
import com.exemplo.venda.api_venda.models.Carro;
import com.exemplo.venda.api_venda.models.Cliente;
import com.exemplo.venda.api_venda.models.Venda;
import com.exemplo.venda.api_venda.models.Vendedor;
import com.exemplo.venda.api_venda.repositories.RepositorioCarro;
import com.exemplo.venda.api_venda.repositories.RepositorioCliente;
import com.exemplo.venda.api_venda.repositories.RepositorioVenda;
import com.exemplo.venda.api_venda.repositories.RepositorioVendedor;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/")
public class Controlador {
    @Autowired
    RepositorioCarro repositorioCarro;
    @Autowired
    RepositorioVendedor repositorioVendedor;
    @Autowired
    RepositorioCliente repositorioCliente;
    @Autowired
    RepositorioVenda repositorioVenda;

    @PostMapping("/cadastrarcarro")
    public ResponseEntity<Carro> cadastrar(@RequestBody Carro carro) {
        Carro resposta = new Carro();
        resposta = (repositorioCarro.save(carro));
        return new ResponseEntity<>(resposta, HttpStatus.CREATED);
    }

    @PostMapping("/cadastrarvendedor")
    public ResponseEntity<Vendedor> cadastrarVendedor(@RequestBody Vendedor vendedor) {
        Vendedor resposta = new Vendedor();
        resposta = (repositorioVendedor.save(vendedor));
        return new ResponseEntity<>(resposta, HttpStatus.CREATED);
    }

    @PostMapping("/cadastrarcliente")
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {
        Cliente resposta = new Cliente();
        resposta = (repositorioCliente.save(cliente));
        return new ResponseEntity<>(resposta, HttpStatus.CREATED);
    }

    @PostMapping("/cadastrarvenda")
    public ResponseEntity<ResponsePadraoDTO> cadastrar(@RequestBody Venda venda) {

        ResponsePadraoDTO resposta = new ResponsePadraoDTO();
        resposta.mensagem = "Venda cadastrada com sucesso";
        Optional<Cliente> clienteBusca = repositorioCliente.findById(venda.cliente.clienteId);
        if (clienteBusca.isPresent() == false) {
            resposta.erros.add("O cliente não existe");
        }
        Optional<Carro> carroBusca = repositorioCarro.findById(venda.carro.carroId);
        if (carroBusca.isPresent() == false) {
            resposta.erros.add("O carro não existe");
        }
        Optional<Vendedor> vendedorBusca = repositorioVendedor.findById(venda.vendedor.vendedorId);
        if (vendedorBusca.isPresent() == false) {
            resposta.erros.add("O vendedor não existe");
        }
        if (resposta.erros.size() > 0) {
            return new ResponseEntity<>(resposta, HttpStatus.BAD_REQUEST);
        }

        repositorioVenda.save(venda);
        return new ResponseEntity<>(resposta, HttpStatus.CREATED);
    }

    @GetMapping(value = "vendas")
    public List<Venda> listarVendas() {
        return repositorioVenda.findAll();
    }

    @GetMapping(value = "carros")
    public List<Carro> listarCarros() {
        return repositorioCarro.findAll();
    }

}