package com.example.webServiceRestfulSpringJPA.Dao;

import java.util.List;

import com.example.webServiceRestfulSpringJPA.DomainorEntities.Curso;

public interface CursoDao {

    public void salvar(Curso curso);

    public void deletar(Long id);

    public List<Curso> listAll();

    public void update(Curso curso);

    public Curso encontrarPorId(Long id);

    
}
