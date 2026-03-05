package com.example.GestaoEscolar.util.application.service;

import com.example.GestaoEscolar.util.domain.dto.turmadto.TurmaRequisicao;
import com.example.GestaoEscolar.util.domain.dto.turmadto.TurmaResposta;
import com.example.GestaoEscolar.util.domain.mapper.TurmaMapper;
import com.example.GestaoEscolar.util.model.Turma;
import com.example.GestaoEscolar.util.repository.TurmaDao;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class TurmaService {
    private final TurmaDao dao;
    private final TurmaMapper mapper;

    public TurmaService(TurmaDao dao, TurmaMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    public TurmaResposta create(TurmaRequisicao turma)throws SQLException {
        Turma turma1 = mapper.paraRequisicao(turma);
        return mapper.paraResposta(dao.create(turma1));
    }
    public List<TurmaResposta> ListOff()throws SQLException{
        return mapper.ParaLista(dao.ListOff());
    }
    public TurmaResposta ListById(int id)throws SQLException{
        Turma turma = dao.ListByID(id);
        if(turma == null){
            throw new RuntimeException("Id nao encontrado");
        }
        return mapper.paraResposta(turma);
    }
    public TurmaResposta Update(TurmaRequisicao requisicao, int id)throws SQLException{
        Turma turma = mapper.paraRequisicao(requisicao);
        dao.Update(turma,id);
        return mapper.paraResposta(turma);
    }
    public void Delete(int id)throws SQLException{
        Turma turma = dao.ListByID(id);
        if(turma == null){
            throw new RuntimeException("Id nao encontrado");
        }
        dao.Delete(id);
    }
}
