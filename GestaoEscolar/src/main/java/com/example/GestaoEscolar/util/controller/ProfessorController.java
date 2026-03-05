package com.example.GestaoEscolar.util.controller;

import com.example.GestaoEscolar.util.domain.dto.ProfessorDto.ProfessorRequisicaoDto;
import com.example.GestaoEscolar.util.domain.dto.ProfessorDto.ProfessorRespostaDto;
import com.example.GestaoEscolar.util.application.service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService service;


    public ProfessorController( ProfessorService service) {
        this.service = service;
    }
    @PostMapping
    public ProfessorRespostaDto create(@Valid @RequestBody ProfessorRequisicaoDto professor){
        try {
            return service.create(professor);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @GetMapping
    public List<ProfessorRespostaDto>ListOff(){
        try{
            return service.ListOff();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ProfessorRespostaDto ListById(@PathVariable  int id){
        try {
            return service.FindById(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ProfessorRespostaDto Update(@Valid @RequestBody  ProfessorRequisicaoDto requisicao, @PathVariable  int id){
        try{
            return service.Update(id,requisicao);
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
