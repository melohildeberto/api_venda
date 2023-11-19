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
@Table(name = "carro")
public class Carro {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carroId")
	public Long carroId;
	@Column(name = "marca", columnDefinition="VARCHAR(60)", nullable = false)
	public String marca;
	@Column(name = "placa", columnDefinition="VARCHAR(11)", nullable = false)
	public String placa;
	@Column(name = "cor", columnDefinition="VARCHAR(10)", nullable = false)
	public String cor;
	@JsonIgnoreProperties(value = {"venda"}, allowSetters=true)
	@OneToMany(mappedBy="carro", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Venda> vendas;
}
