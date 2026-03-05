package com.example.GestaoEscolar.util.controller;

import com.example.GestaoEscolar.util.application.service.AulaService;
import com.example.GestaoEscolar.util.domain.dto.auladto.AulaRequisicaoDto;
import com.example.GestaoEscolar.util.domain.dto.auladto.AulaRespostaDto;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/aula")
public class AulaController {


private final AulaService service;


    public AulaController(AulaService service) {
        this.service = service;
    }

    @PostMapping
    public AulaRespostaDto Create(@RequestBody AulaRequisicaoDto requisicao){
        try{
            return service.Create(requisicao);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @GetMapping
    public List<AulaRespostaDto>ListOff()throws SQLException{
        try {
            return service.ListOff();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public AulaRespostaDto ListById(@PathVariable  int id)throws SQLException{
        try{
            return service.ListById(id);
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public AulaRespostaDto Update(@RequestBody AulaRequisicaoDto requisicao ,@PathVariable  int id){
        try{
            return service.Update(requisicao,id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public void Delete(@PathVariable int id){
        try{
            service.Delete(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
