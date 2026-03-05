package com.example.GestaoEscolar.util.repository;

import com.example.GestaoEscolar.util.conexao.Conexao;
import com.example.GestaoEscolar.util.model.Turma;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TurmaDao {

public Turma create(Turma turma)throws SQLException{
    String query = """
            INSERT INTO turma (nome, curso_id, professor_id) VALUES
            (?,?,?)
            
            """;
    try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
        stmt.setString(1, turma.getNome());
        stmt.setInt(2,turma.getCurso_id());
        stmt.setInt(3,turma.getProfessor_id());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if(rs.next()){
        turma.setId(rs.getInt(1));
        }
    }
    return turma;
}
public List<Turma> ListOff()throws SQLException{
    List<Turma>turmas = new ArrayList<>();
    String query = """
            SELECT t.id,
            t.nome,
            c.id as curso_id,
            p.id as professor_id
            FROM turma t
            INNER JOIN curso c ON c.id = t.curso_id
            INNER JOIN professor p ON p.id = t.professor_id;\s
            """;
    try(Connection conn = Conexao.conectar();
    PreparedStatement stmt = conn.prepareStatement(query)){
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            turmas.add(new Turma(rs.getInt("id"),rs.getString("nome"), rs.getInt("curso_id"),rs.getInt("professor_id") ));
        }

    }
    return turmas;
}
public Turma ListByID(int id)throws SQLException{
    String query = """
                 SELECT t.id,
            t.nome,
            c.id as curso_id,
            p.id as professor_id
            FROM turma t
            INNER JOIN curso c ON c.id = t.curso_id
            INNER JOIN professor p ON p.id = t.professor_id
            WHERE t.id = ?
            
            """;
    try(Connection conn = Conexao.conectar();
    PreparedStatement stmt = conn.prepareStatement(query)){
        stmt.setInt(1,id);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
           return new Turma(rs.getInt("id"),rs.getString("nome"), rs.getInt("curso_id"),rs.getInt("professor_id") );
        }
    }
    return null;
}
public void Update(Turma turma, int id)throws SQLException{
    String query = """
            UPDATE turma
            SET nome = ?,
            curso_id = ?,
            professor_id = ?
            WHERE id = ? 
            """;
    try(Connection conn = Conexao.conectar();
    PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1,turma.getNome());
        stmt.setInt(2,turma.getCurso_id());
        stmt.setInt(3,turma.getProfessor_id());
        stmt.setInt(4,id);
        stmt.executeUpdate();

    }

}

public void Delete( int id)throws SQLException{
    String query = """
            DELETE FROM turma
            WHERE id = ?
            
            """;
    try(Connection conn = Conexao.conectar();
    PreparedStatement stmt = conn.prepareStatement(query)){
        stmt.setInt(1,id);
        stmt.executeUpdate();
    }
}


}
