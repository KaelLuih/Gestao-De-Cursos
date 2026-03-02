package com.example.GestaoEscolar.util.mapper;

import com.example.GestaoEscolar.util.dto.cursodto.CursoRequisicaoDto;
import com.example.GestaoEscolar.util.dto.cursodto.CursoRespostaDto;
import com.example.GestaoEscolar.util.model.Curso;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CursoMapper {
    public Curso ParaEntidade(CursoRequisicaoDto requisicao){
        return new Curso(requisicao.nome(), requisicao.codigo());
    }
    public CursoRespostaDto paraResposta(Curso curso) {
        return new CursoRespostaDto(
                curso.getId(),
                curso.getNome(),
                curso.getCodigo()

        );
    }
    public List ToList(List<Curso>cursos){
        return cursos.stream().map(this::paraResposta).toList();
    }
}
