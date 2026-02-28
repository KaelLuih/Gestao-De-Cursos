package com.example.GestaoEscolar.util.mapper;

import com.example.GestaoEscolar.util.dto.AlunoDto.AlunoRequisicao;
import com.example.GestaoEscolar.util.dto.AlunoDto.AlunoResposta;
import com.example.GestaoEscolar.util.model.Aluno;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AlunoMapper {
    public Aluno paraEntidade(AlunoRequisicao requisicao){
        return new Aluno(
                requisicao.nome(),
                requisicao.email(),
                requisicao.matricula(),
                requisicao.Data_aniversario()
        );
    }
    public AlunoResposta paraResposta(Aluno aluno){
        return new AlunoResposta(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getMatricula(), aluno.getData_aniversario());
    }
    public List<AlunoResposta>paraLista(List<Aluno> alunos){
        return alunos.stream().map(this::paraResposta).toList();
    }
}
