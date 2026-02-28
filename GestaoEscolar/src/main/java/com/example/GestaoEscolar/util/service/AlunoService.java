package com.example.GestaoEscolar.util.service;

import com.example.GestaoEscolar.util.dto.AlunoDto.AlunoRequisicao;
import com.example.GestaoEscolar.util.dto.AlunoDto.AlunoResposta;
import com.example.GestaoEscolar.util.mapper.AlunoMapper;
import com.example.GestaoEscolar.util.model.Aluno;
import com.example.GestaoEscolar.util.repository.AlunoDao;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AlunoService {
private final AlunoDao alunoDao;
private final AlunoMapper mapper;


    public AlunoService(AlunoDao alunoDao, AlunoMapper mapper) {
        this.alunoDao = alunoDao;
        this.mapper = mapper;
    }

    public AlunoResposta create(AlunoRequisicao requisicao)throws SQLException{
        Aluno aluno = mapper.paraEntidade(requisicao);
        return mapper.paraResposta(alunoDao.create(aluno));
    }
    public List<AlunoResposta>ListOff()throws SQLException{
        return mapper.paraLista(alunoDao.ListOf());
    }
    public AlunoResposta ListById(int id)throws SQLException{
        Aluno aluno = alunoDao.ListById(id);
        if (aluno == null){
            throw new RuntimeException("ID nao existe");
        }
        return mapper.paraResposta(aluno);
    }
    public AlunoResposta update(AlunoRequisicao requisicao,int id)throws SQLException{
        Aluno aluno = mapper.paraEntidade(requisicao);
        alunoDao.Update(aluno,id);
        return mapper.paraResposta(aluno);

    }
    public void Delete(int id)throws SQLException{
    Aluno aluno = alunoDao.ListById(id);
    if (aluno == null){
        throw new RuntimeException("Id não encontrado");
    }
    alunoDao.Delete(id);
    }
}
