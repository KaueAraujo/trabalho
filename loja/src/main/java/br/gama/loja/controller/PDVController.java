package br.gama.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gama.loja.dao.PDVDAO;
import br.gama.loja.model.PDV;

@RestController
@CrossOrigin("*")
public class PDVController {
    
    @Autowired
    private PDVDAO dao;

    //listar todos os pedidos
    @GetMapping("/pdv")
    public List<PDV> listarTodos(){
        List<PDV> lista = (List<PDV>) dao.findAll();
        return lista;
    }

}
