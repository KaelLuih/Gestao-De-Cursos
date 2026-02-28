package com.example.GestaoEscolar.util.service;

import com.example.GestaoEscolar.util.dto.ProfessorDto.ProfessorRequisicaoDto;
import com.example.GestaoEscolar.util.dto.ProfessorDto.ProfessorRespostaDto;
import com.example.GestaoEscolar.util.mapper.ProfessorMapper;
import com.example.GestaoEscolar.util.model.Professor;
import com.example.GestaoEscolar.util.repository.ProfessorDao;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class ProfessorService {
    private final ProfessorMapper mapper;
    private final ProfessorDao dao;

    public ProfessorService(ProfessorMapper mapper, ProfessorDao dao) {
        this.mapper = mapper;
        this.dao = dao;
    }

    public ProfessorRespostaDto create(ProfessorRequisicaoDto requisicaoDto)throws SQLException{
        Professor professor = mapper.paraEntidade(requisicaoDto);
        return mapper.paraResposta(dao.create(professor));
    }
    public List<ProfessorRespostaDto>ListOff()throws SQLException{
        return mapper.paraLista(dao.ListOff());
    }
    public ProfessorRespostaDto FindById(int id)throws SQLException{
        Professor professor = dao.ListById(id);
        if(professor == null){
            throw new RuntimeException("ID nao encontrado");
        }
        return  mapper.paraResposta(professor);
    }
    public ProfessorRespostaDto Update(int id , ProfessorRequisicaoDto requisicao)throws SQLException{
        Professor professor = mapper.paraEntidade(requisicao);
        dao.Update(professor,id);
        return mapper.paraResposta(professor);
    }
    public void Delete(int id)throws SQLException{
        Professor professor = dao.ListById(id);
        if (professor == null){
            throw new RuntimeException("Id nao encontrado");
        }
        dao.Delete(id);
    }
}
