package br.gama.loja.dao;

import org.springframework.data.repository.CrudRepository;

import br.gama.loja.model.Gestor;

public interface GestorDAO extends CrudRepository<Gestor, Integer>{
    public Gestor findByFuncionalGestorOrRacfGestor(String funcionalGestor, String racfGestor);
}