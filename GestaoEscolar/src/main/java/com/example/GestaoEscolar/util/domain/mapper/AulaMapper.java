package com.example.GestaoEscolar.util.domain.mapper;

import com.example.GestaoEscolar.util.domain.dto.auladto.AulaRequisicaoDto;
import com.example.GestaoEscolar.util.domain.dto.auladto.AulaRespostaDto;
import com.example.GestaoEscolar.util.model.Aula;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AulaMapper {

    public Aula paraRequisicao(AulaRequisicaoDto requisicao){
        return new Aula(requisicao.turma_id(), requisicao.data_hora(),requisicao.assunto());
    }
    public AulaRespostaDto paraResposta(Aula aula){
        return new AulaRespostaDto(aula.getId(),aula.getTurma_id(),aula.getData_hora(),aula.getAssunto());
    }
    public List<AulaRespostaDto> paraLista(List<Aula> aulas){
        return aulas.stream().map(this::paraResposta).toList();
    }
}
