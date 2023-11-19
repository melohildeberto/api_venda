package com.exemplo.venda.api_venda.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "venda")
public class Venda {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vendaId")
	public Long vendaId;
	@Column(name = "numero", columnDefinition="VARCHAR(60)", nullable = false)
	public String numero;
	
	@ManyToOne
    @JoinColumn(name="cliente_id", nullable=false)
	@JsonIgnoreProperties(value = {"vendas"}, allowSetters = true)
    public Cliente cliente;
	@ManyToOne
    @JoinColumn(name="vendendor_id", nullable=false)
	@JsonIgnoreProperties(value = {"vendas"}, allowSetters = true)
    public Vendedor vendedor;
	@ManyToOne
    @JoinColumn(name="carro_id", nullable=false)
	@JsonIgnoreProperties(value = {"vendas"}, allowSetters = true)
    public Carro carro;
}
