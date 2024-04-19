package com.example.webServiceRestfulSpringJPA.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.webServiceRestfulSpringJPA.DomainorEntities.Curso;
import com.example.webServiceRestfulSpringJPA.Services.CursoService;

@Controller
@RequestMapping(value = "/cursos")
public class CursoController {
    
    @Autowired
    private CursoService cs;

    

@PostMapping
public void adicionarCurso(Curso curso){
    cs.salvar(curso);
}

@DeleteMapping("/{id}")
public void deletarCurso(@PathVariable Long id){
    cs.deletar(id);
}

@PutMapping
public void updateCurso(Curso curso){
    cs.update(curso);
}

@GetMapping
public void retornarTodos(){
    cs.retornarTodos();
}

@GetMapping("/{id}")
public void retornarPorId(@PathVariable Long id){
    cs.retornarPorId(id);
}
    
}
