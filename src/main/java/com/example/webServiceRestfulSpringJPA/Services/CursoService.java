package com.example.webServiceRestfulSpringJPA.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webServiceRestfulSpringJPA.Dao.CursoDao;
import com.example.webServiceRestfulSpringJPA.DomainorEntities.Curso;

@Service
public class CursoService {
    
    @Autowired
    private CursoDao dao;

    public void salvar(Curso curso){
        dao.salvar(curso);
    }
    public void deletar(Long id){
        dao.deletar(id);
    } 
    public void update(Curso curso){
        dao.update(curso);
    } 
    public List<Curso> retornarTodos(){
        return dao.listAll();
    } 
    public Curso retornarPorId(Long id){
        return dao.encontrarPorId(id);
    } 
}
