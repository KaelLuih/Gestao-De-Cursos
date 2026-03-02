package com.example.GestaoEscolar.util.domain.mapper;

import com.example.GestaoEscolar.util.domain.dto.ProfessorDto.ProfessorRequisicaoDto;
import com.example.GestaoEscolar.util.domain.dto.ProfessorDto.ProfessorRespostaDto;
import com.example.GestaoEscolar.util.model.Professor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProfessorMapper {
    public Professor paraEntidade(ProfessorRequisicaoDto requisicao){
        return new Professor(
                requisicao.nome(), requisicao.email(), requisicao.disciplina()
        );

    }
    public ProfessorRespostaDto paraResposta(Professor professor){
    return new ProfessorRespostaDto(professor.getId(), professor.getNome(), professor.getEmail(), professor.getDisciplina());
    }
    public List<ProfessorRespostaDto> paraLista(List<Professor> professores){
        return professores.stream().map(this::paraResposta).toList();
    }




}
