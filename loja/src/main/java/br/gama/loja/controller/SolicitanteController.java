package br.gama.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.gama.loja.dao.SolicitanteDAO;
import br.gama.loja.model.Solicitante;

@RestController
@CrossOrigin("*")
public class SolicitanteController {
    
    @Autowired
    private SolicitanteDAO dao;

    /*//buscar um pedido por número do pedido
    @GetMapping("/pedido/{id}")
    public ResponseEntity<Pedido> buscaPorId(@PathVariable int id){
        Pedido pedido = dao.findById(id).orElse(null);

        if(pedido != null){
            return ResponseEntity.ok(pedido);
        }else{
            return ResponseEntity.notFound().build();
        }
    }*/

    @PostMapping("/solicita/cadastra")
    public ResponseEntity<Solicitante> novaSolicitante(@RequestBody final Solicitante solicita) {
        try {
            if (solicita.getIdSol() > 0) {
                final Solicitante novo = dao.save(solicita); // Salva o usuario no banco de dados
                return ResponseEntity.ok(novo); // retorna os dados do usuario
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (final Exception ex) {
            return ResponseEntity.status(400).build();
        }
    }

    //listar todos os pedidos
    @GetMapping("/solicita")
    public List<Solicitante> listarTodos(){
        List<Solicitante> lista = (List<Solicitante>) dao.findAllByOrderByData();
        return lista;
    }
    
    //listar todos os pedidos por status
    @GetMapping("/solicita/status/{status}")
    public List<Solicitante> buscaPorStatus(@PathVariable String status){
        List<Solicitante> lista = dao.findByStatus(status);
        return lista;
    }

    //atualizar o status do pedido
    @PutMapping("/solicita/status")
    public ResponseEntity<Boolean> alterarStatus(@RequestBody Solicitante solicitanteUser){
        Solicitante solicitante = dao.findById(solicitanteUser.getIdSol()).orElse(null);

        if(solicitante != null){
            solicitante.setStatus(solicitanteUser.getStatus());
            dao.save(solicitante);
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.ok(false);
        }

    }

}
