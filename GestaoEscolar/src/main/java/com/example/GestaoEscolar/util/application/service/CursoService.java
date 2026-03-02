package com.example.GestaoEscolar.util.application.service;

import com.example.GestaoEscolar.util.domain.dto.cursodto.CursoRequisicaoDto;
import com.example.GestaoEscolar.util.domain.dto.cursodto.CursoRespostaDto;
import com.example.GestaoEscolar.util.domain.mapper.CursoMapper;
import com.example.GestaoEscolar.util.model.Curso;
import com.example.GestaoEscolar.util.repository.CursoDao;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class CursoService {

    private final CursoDao dao;
    private final CursoMapper mapper;


    public CursoService(CursoDao dao, CursoMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;

    }

    public CursoRespostaDto create(CursoRequisicaoDto requisicao)throws SQLException{
        Curso curso = mapper.ParaEntidade(requisicao);
        return mapper.paraResposta(dao.create(curso));
    }
    public List<CursoRespostaDto> ListOff()throws SQLException{
        return mapper.ToList(dao.ListOff());
    }
    public CursoRespostaDto ListById(int id)throws SQLException{
        Curso curso = dao.LIstByID(id);
        if (curso == null){
            throw new RuntimeException("Id nao encontrado");
        }
        return mapper.paraResposta(curso);
    }
    public CursoRespostaDto Update(CursoRequisicaoDto requisicao, int id)throws SQLException{
        Curso curso = mapper.ParaEntidade(requisicao) ;
        dao.Update(curso,id);
        return mapper.paraResposta(curso);
    }
    public void delete(int id)throws SQLException{
        Curso curso = dao.LIstByID(id);
        if(curso == null){
            throw new RuntimeException("Id nãpo encontrado");
        }
        dao.Delete(id);
    }

}
