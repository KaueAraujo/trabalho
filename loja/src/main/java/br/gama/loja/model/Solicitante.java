package br.gama.loja.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "solicitante")

public class Solicitante {

    //Atributos
    @Id // É chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-numeração
    @Column(name="idSol",nullable = false, unique = true)
    private int idSol;
    
    @Column(name="nomeSol",length = 100,nullable = false)
    private String nomeSol;
    
    @Column(name="operadoraSol",length = 100,nullable = false)
    private String operadoraSol;
    
    @Column(name="docSol",length = 20, nullable = false)
    private String docSol;
    
    @Column(name="telSol", length = 20, nullable = false)
    private String telSol;

    @Column(name="data",nullable = false)
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate data;

    @Column(name="hora",nullable = false)
    @JsonFormat(pattern ="HH:mm:ss")
    private LocalTime hora;

    @Column(name="status", length = 20 ,nullable = false)
    private String status;

    @ManyToOne
    @JsonIgnoreProperties("solicitante")
    private PDV pdv;

    public int getIdSol() {
        return idSol;
    }

    public void setIdSol(int idSol) {
        this.idSol = idSol;
    }

    public String getNomeSol() {
        return nomeSol;
    }

    public void setNomeSol(String nomeSol) {
        this.nomeSol = nomeSol;
    }

    public String getOperadoraSol() {
        return operadoraSol;
    }

    public void setOperadoraSol(String operadoraSol) {
        this.operadoraSol = operadoraSol;
    }

    public String getDocSol() {
        return docSol;
    }

    public void setDocSol(String docSol) {
        this.docSol = docSol;
    }

    public String getTelSol() {
        return telSol;
    }

    public void setTelSol(String telSol) {
        this.telSol = telSol;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if(status != ""){
            this.status = status;
        }else{
            this.status = "Nova";
        }
    }

    
    
}