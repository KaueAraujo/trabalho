package br.gama.loja.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.gama.loja.model.Solicitante;

public interface SolicitanteDAO extends CrudRepository<Solicitante, Integer>{
    public List<Solicitante> findByStatus(String status);
    public List<Solicitante> findAllByOrderByData();
}