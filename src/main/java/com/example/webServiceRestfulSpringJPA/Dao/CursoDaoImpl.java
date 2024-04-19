package com.example.webServiceRestfulSpringJPA.Dao;

import java.util.List;

import com.example.webServiceRestfulSpringJPA.DomainorEntities.Curso;
import com.example.webServiceRestfulSpringJPA.exception.NaoExisteDaoException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;

public class CursoDaoImpl implements CursoDao{

    private EntityManager em;
    
    @Override
    public void salvar(Curso curso) {
        em.persist(curso);
    }

    @Override
    public void deletar(Long id) {
        try{
            em.remove(em.getReference(Curso.class, id));
        }
        catch(EntityNotFoundException e){
            throw new NaoExisteDaoException("Curso não encontrada para o id " + id + ".");
        }
    }

    @Override
    public List<Curso> listAll() {
        return em.createQuery("select c from Curso c", Curso.class).getResultList();
        }

    @Override
    public void update(Curso curso) {
        em.merge(curso);
    }

    @Override
    public Curso encontrarPorId(Long id) {

        Curso curso = em.find(Curso.class, id);       
         if(curso == null){
            throw new NaoExisteDaoException("Curso não encontrada para o id " + id + ".");
         }

         return curso;
    }
    
    

}
