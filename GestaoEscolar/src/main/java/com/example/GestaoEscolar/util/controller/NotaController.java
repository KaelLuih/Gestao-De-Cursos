package com.example.GestaoEscolar.util.controller;

import com.example.GestaoEscolar.util.application.service.NotaService;
import com.example.GestaoEscolar.util.domain.dto.notadto.NotaRequisicaoDto;
import com.example.GestaoEscolar.util.domain.dto.notadto.NotaRespostaDto;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/nota")
public class NotaController {

private final NotaService service;

    public NotaController(NotaService service) {
        this.service = service;
    }
    @PostMapping
    public NotaRespostaDto Create(@RequestBody NotaRequisicaoDto requisicaoDto){
        try{
            return service.Create(requisicaoDto);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @GetMapping
    public List<NotaRespostaDto>ListOff(){
        try{
            return service.ListOff();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }



    }
    @GetMapping("/{id}")
    public NotaRespostaDto ListById(@PathVariable int id){
        try {
            return service.ListById(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public NotaRespostaDto Update(@RequestBody NotaRequisicaoDto requisicaoDto, @PathVariable int id){
        try{
            return service.Update(requisicaoDto,id);
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
