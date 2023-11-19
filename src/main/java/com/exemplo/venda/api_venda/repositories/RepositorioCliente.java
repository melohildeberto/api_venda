package com.exemplo.venda.api_venda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.venda.api_venda.models.Cliente;

public interface RepositorioCliente extends JpaRepository<Cliente,Long>{
    
}
