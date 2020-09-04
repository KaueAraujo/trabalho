package br.gama.loja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gestor")

public class  Gestor{

    //Atributos
    @Id // É chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-numeração
    @Column(name="idGestor",unique = true)
    private int idGestor;
    
    @Column(name="nomeGestor",length = 100,nullable = false)
    private String nomeGestor;
    
    @Column(name="racfGestor",length = 100,nullable = false)
    private String racfGestor;
    
    @Column(name="funcionalGestor",length = 20, nullable = false)
    private String funcionalGestor;
    
    @Column(name="senhaGestor", length = 20, nullable = false)
    private String senhaGestor;

    @Column(name = "linkfoto")
    private String linkFoto;

    public int getIdGestor() {
        return idGestor;
    }

    public void setIdGestor(int idGestor) {
        this.idGestor = idGestor;
    }

    public String getNomeGestor() {
        return nomeGestor;
    }

    public void setNomeGestor(String nomeGestor) {
        this.nomeGestor = nomeGestor;
    }

    public String getRacfGestor() {
        return racfGestor;
    }

    public void setRacfGestor(String racfGestor) {
        this.racfGestor = racfGestor;
    }

    public String getFuncionalGestor() {
        return funcionalGestor;
    }

    public void setFuncionalGestor(String funcionalGestor) {
        this.funcionalGestor = funcionalGestor;
    }

    public String getSenhaGestor() {
        return senhaGestor;
    }

    public void setSenhaGestor(String senhaGestor) {
        this.senhaGestor = senhaGestor;
    }

    public String getLinkFoto() {
        return linkFoto;
    }

    public void setLinkFoto(String linkFoto) {
        this.linkFoto = linkFoto;
    }

    
}