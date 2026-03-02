package com.example.GestaoEscolar.util.controller;

import com.example.GestaoEscolar.util.domain.dto.AlunoDto.AlunoRequisicao;
import com.example.GestaoEscolar.util.domain.dto.AlunoDto.AlunoResposta;
import com.example.GestaoEscolar.util.application.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
private final AlunoService service;


    public AlunoController(AlunoService service) {
        this.service = service;
    }
    @PostMapping
    public AlunoResposta create(@RequestBody AlunoRequisicao requisicao){
        try {
            return service.create(requisicao);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @GetMapping
    public List<AlunoResposta>ListOff(){
        try {
            return service.ListOff();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public AlunoResposta ListById(@PathVariable int id){
        try {
            return service.ListById(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

    }
    @PutMapping("/{id}")
    public AlunoResposta update(@RequestBody AlunoRequisicao requisicao, @PathVariable int id){
        try{
            return service.update(requisicao,id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        try {
            service.Delete(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
