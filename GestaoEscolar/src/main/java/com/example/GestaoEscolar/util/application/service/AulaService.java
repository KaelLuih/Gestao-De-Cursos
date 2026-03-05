package com.example.GestaoEscolar.util.application.service;

import com.example.GestaoEscolar.util.domain.dto.auladto.AulaRequisicaoDto;
import com.example.GestaoEscolar.util.domain.dto.auladto.AulaRespostaDto;
import com.example.GestaoEscolar.util.domain.mapper.AulaMapper;
import com.example.GestaoEscolar.util.model.Aula;
import com.example.GestaoEscolar.util.repository.AulaDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class AulaService {
    private final AulaDao dao;
    private final AulaMapper mapper;

    public AulaService(AulaDao dao, AulaMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    public AulaRespostaDto Create(AulaRequisicaoDto requisicaoDto)throws SQLException{
        Aula aula = mapper.paraRequisicao(requisicaoDto);
        return mapper.paraResposta(dao.Create(aula));
    }
    public List<AulaRespostaDto> ListOff()throws SQLException{
        return mapper.paraLista(dao.ListOFf());
    }
    public AulaRespostaDto ListById(int id)throws SQLException{
        Aula aula = dao.ListById(id);
        return mapper.paraResposta(aula);
    }
    public AulaRespostaDto Update(AulaRequisicaoDto dto , int id)throws SQLException{
        Aula aula = mapper.paraRequisicao(dto);
        dao.Update(aula,id);
        return mapper.paraResposta(aula);
    }
    public void Delete(int id)throws SQLException{
        dao.Delete(id);
    }

}
