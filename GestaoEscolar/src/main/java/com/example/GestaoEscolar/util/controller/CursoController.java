package com.example.GestaoEscolar.util.controller;

import com.example.GestaoEscolar.util.application.service.CursoService;
import com.example.GestaoEscolar.util.domain.dto.cursodto.CursoRequisicaoDto;
import com.example.GestaoEscolar.util.domain.dto.cursodto.CursoRespostaDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {
    private final CursoService service;


    public CursoController(CursoService service) {
        this.service = service;
    }

    @PostMapping
    public CursoRespostaDto create(@Valid  @RequestBody CursoRequisicaoDto requisicao){
        try {
           return service.create(requisicao);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @GetMapping
    public List<CursoRespostaDto> ListOff(){
        try{
            return service.ListOff();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public CursoRespostaDto ListById(@PathVariable int id){
        try{
            return service.ListById(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public CursoRespostaDto Update(@PathVariable int id, @Valid @RequestBody CursoRequisicaoDto requisicao){
        try{
            return service.Update(requisicao,id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public void Delete(@PathVariable int id){
        try{
            service.delete(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
