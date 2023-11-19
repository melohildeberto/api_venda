package com.exemplo.venda.api_venda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.venda.api_venda.models.Venda;

public interface RepositorioVenda extends JpaRepository<Venda,Long>{
    
}
