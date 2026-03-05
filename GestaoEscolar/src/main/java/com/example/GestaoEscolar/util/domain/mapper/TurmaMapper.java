package com.example.GestaoEscolar.util.domain.mapper;

import com.example.GestaoEscolar.util.domain.dto.ProfessorDto.ProfessorRespostaDto;
import com.example.GestaoEscolar.util.domain.dto.turmadto.TurmaRequisicao;
import com.example.GestaoEscolar.util.domain.dto.turmadto.TurmaResposta;
import com.example.GestaoEscolar.util.model.Turma;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TurmaMapper {
    public Turma paraRequisicao(TurmaRequisicao turma){
        return new Turma(turma.nome(), turma.curso_id(), turma.professor_id());
    }
    public TurmaResposta paraResposta(Turma turma){
        return new TurmaResposta(turma.getId(), turma.getNome(), turma.getCurso_id(), turma.getProfessor_id());
    }
    public List<TurmaResposta> ParaLista(List<Turma>turmas){
        return turmas.stream().map(this::paraResposta).toList();
    }
}
