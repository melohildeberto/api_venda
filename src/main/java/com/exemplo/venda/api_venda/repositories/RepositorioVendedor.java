package com.exemplo.venda.api_venda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.venda.api_venda.models.Vendedor;

public interface RepositorioVendedor extends JpaRepository<Vendedor,Long>{
    
}
