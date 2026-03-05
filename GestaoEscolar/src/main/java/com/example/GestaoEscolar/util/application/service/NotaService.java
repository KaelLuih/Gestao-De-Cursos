package com.example.GestaoEscolar.util.application.service;

import com.example.GestaoEscolar.util.domain.dto.notadto.NotaRequisicaoDto;
import com.example.GestaoEscolar.util.domain.dto.notadto.NotaRespostaDto;
import com.example.GestaoEscolar.util.domain.mapper.NotaMapper;
import com.example.GestaoEscolar.util.model.Nota;
import com.example.GestaoEscolar.util.repository.NotaDao;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class NotaService {

private final NotaDao dao;
private final NotaMapper mapper;

    public NotaService(NotaDao dao, NotaMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }


    public NotaRespostaDto Create(NotaRequisicaoDto requisicaoDto)throws SQLException{
        Nota Nota= mapper.paraEntidade(requisicaoDto);
        return mapper.paraResposta(dao.Create(Nota));
    }
    public List<NotaRespostaDto>ListOff()throws SQLException{
        return mapper.paraLista(dao.ListOff());
    }
    public NotaRespostaDto ListById(int id)throws SQLException{
        Nota nota = dao.ListById(id);
        return mapper.paraResposta(nota);
    }
    public NotaRespostaDto Update(NotaRequisicaoDto requisicaoDto, int id)throws SQLException{
        Nota nota = mapper.paraEntidade(requisicaoDto);
        dao.Update(nota,id);
       return mapper.paraResposta(nota);

    }
    public void Delete(int id)throws SQLException{
        dao.Delete(id);
    }


}
