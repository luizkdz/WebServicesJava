package com.example.webServiceRestfulSpringJPA.DomainorEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "curso")
public class Curso {
    
    @Id
    @Column
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private CargaHoraria cargaHoraria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CargaHoraria getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(CargaHoraria cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

 public Curso(){

 }

public Curso(Long id, String nome, CargaHoraria cargaHoraria) {
    this.id = id;
    this.nome = nome;
    this.cargaHoraria = cargaHoraria;
}


    

}
