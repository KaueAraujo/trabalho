package br.gama.loja.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.gama.loja.dao.GestorDAO;
import br.gama.loja.model.Gestor;

@RestController
@CrossOrigin("*")
public class GestorController {
    
    @Autowired
    private GestorDAO dao;

    @PostMapping("/gestor/login")
    public ResponseEntity<Gestor> fazerLogin(@RequestBody final Gestor gestor) {
        final Gestor userFinded = dao.findByFuncionalGestorOrRacfGestor(gestor.getFuncionalGestor(), gestor.getRacfGestor());

        if (userFinded != null) {
            if (userFinded.getSenhaGestor().equals(gestor.getSenhaGestor())) {
                userFinded.setSenhaGestor("*********");
                //userFinded.setPedidos(null);
                return ResponseEntity.ok(userFinded);
            }else{
                return ResponseEntity.status(403).build();
            }
        } else {
            //return ResponseEntity.status(404).build();
            return ResponseEntity.status(403).build();
        }
    }

}