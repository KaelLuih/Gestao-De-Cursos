package com.example.GestaoEscolar.util.domain.mapper;

import com.example.GestaoEscolar.util.domain.dto.notadto.NotaRequisicaoDto;
import com.example.GestaoEscolar.util.domain.dto.notadto.NotaRespostaDto;
import com.example.GestaoEscolar.util.model.Nota;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class NotaMapper {

    public Nota paraEntidade(NotaRequisicaoDto requisicaoDto){
        return new Nota(requisicaoDto.aluno_id(), requisicaoDto.aula_id(), requisicaoDto.valor());
    }
    public NotaRespostaDto paraResposta(Nota nota){
        return new NotaRespostaDto(nota.getId(), nota.getAluno_id(), nota.getAula_id(), nota.getValor());
    }
    public List<NotaRespostaDto>paraLista(List<Nota>notas){
        return notas.stream().map(this::paraResposta).toList();
    }

}
