package com.example.GestaoEscolar.util.controller;

import com.example.GestaoEscolar.util.application.service.TurmaService;
import com.example.GestaoEscolar.util.domain.dto.turmadto.TurmaRequisicao;
import com.example.GestaoEscolar.util.domain.dto.turmadto.TurmaResposta;
import com.example.GestaoEscolar.util.model.Turma;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/turma")
public class  TurmaController {

    private final TurmaService service;
    private RuntimeException runtimeException;


    public TurmaController(TurmaService service) {
        this.service = service;
    }

    @PostMapping
    public TurmaResposta create(@Valid @RequestBody TurmaRequisicao requisicao) {
        try {
            return service.create(requisicao);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<TurmaResposta> ListOff(){
        try {
            return service.ListOff();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }
    @GetMapping("/{id}")
    public TurmaResposta ListById(@PathVariable int id){
        try{
            return service.ListById(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public TurmaResposta Update(@Valid@RequestBody TurmaRequisicao requisicao, @PathVariable int id){
        try {
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
