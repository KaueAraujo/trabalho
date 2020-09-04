package br.gama.loja.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name ="pdv")
public class PDV {

    @Id
    @Column(name = "id_pdv",nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPdv;

    @Column(name = "num_ponto",nullable = false)
    private int numPonto;

    @Column(name = "nomePdv", length = 100,nullable = false)
    private String nomePdv;

    @Column(name = "enderecoPdv", length = 100,nullable = false)
    private String enderecoPdv;

    @Column(name = "telPdv", length = 20,nullable = false)
    private String telPdv;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pdv")
    @JsonIgnoreProperties("pdv")
    private List<Solicitante> solicitante;
    

    public int getIdPdv() {
        return idPdv;
    }

    public void setIdPdv(int idPdv) {
        this.idPdv = idPdv;
    }

    public int getNumPonto() {
        return numPonto;
    }

    public void setNumPonto(int numPonto) {
        this.numPonto = numPonto;
    }

    public String getNomePdv() {
        return nomePdv;
    }

    public void setNomePdv(String nomePdv) {
        this.nomePdv = nomePdv;
    }

    public String getEnderecoPdv() {
        return enderecoPdv;
    }

    public void setEnderecoPdv(String enderecoPdv) {
        this.enderecoPdv = enderecoPdv;
    }

    public String getTelPdv() {
        return telPdv;
    }

    public void setTelPdv(String telPdv) {
        this.telPdv = telPdv;
    }

    
    
}