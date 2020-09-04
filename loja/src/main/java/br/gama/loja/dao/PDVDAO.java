package br.gama.loja.dao;

import org.springframework.data.repository.CrudRepository;

import br.gama.loja.model.PDV;

public interface PDVDAO extends CrudRepository<PDV, Integer> {
    
}