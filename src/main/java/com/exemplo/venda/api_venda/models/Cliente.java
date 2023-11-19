package com.exemplo.venda.api_venda.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clienteId")
	public Long clienteId;
	@Column(name = "nome", columnDefinition="VARCHAR(60)", nullable = false)
	public String nome;
	@Column(name = "cpf", columnDefinition="VARCHAR(11)", unique = true, nullable = false)
	public String cpf;
	@Column(name = "rg", columnDefinition="VARCHAR(10)", nullable = false)
	public String rg;
	@JsonIgnoreProperties(value = {"venda"}, allowSetters=true)
	@OneToMany(mappedBy="cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Venda> vendas;
}
