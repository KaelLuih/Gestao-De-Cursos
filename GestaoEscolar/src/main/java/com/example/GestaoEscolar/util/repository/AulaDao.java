package com.example.GestaoEscolar.util.repository;

import com.example.GestaoEscolar.util.conexao.Conexao;
import com.example.GestaoEscolar.util.model.Aula;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class AulaDao {


    public Aula Create(Aula aula)throws SQLException{
        String query = """
                INSERT INTO aula (turma_id, data_hora, assunto) VALUES
                (?,?,?)
                """;
        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS)){
            stmt.setInt(1,aula.getTurma_id());
            stmt.setTimestamp(2, Timestamp.valueOf(aula.getData_hora()));
            stmt.setString(3,aula.getAssunto());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                aula.setId(rs.getInt(1));
            }
        }
        return aula;
    }

    public List<Aula>ListOFf()throws SQLException{
        List<Aula>aulas = new ArrayList<>();
        String query = """
                SELECT
                id,turma_id, data_hora, assunto 
                FROM aula
                
                """;
        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                aulas.add(new Aula(rs.getInt("id"),
                        rs.getInt("turma_id"),
                        rs.getTimestamp("data_hora").toLocalDateTime(),
                        rs.getString("assunto")


                        ));
            }
        }
        return aulas;
    }
    public Aula ListById(int id)throws SQLException{
        String query = """
                    SELECT
                id,turma_id, data_hora, assunto 
                FROM aula
                WHERE id = ?
                """;
        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
              return  new Aula(rs.getInt("id"),
                        rs.getInt("turma_id"),
                        rs.getTimestamp("data_hora").toLocalDateTime(),
                        rs.getString("assunto"));
            }
        }
        return null;
    }
    public void Update(Aula aula, int id)throws SQLException{
        String query = """
                UPDATE aula 
                SET turma_id = ?,
                data_hora = ?,
                assunto = ?
                WHERE id = ?    
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){
                stmt.setInt(1,aula.getTurma_id());
                stmt.setTimestamp(2, Timestamp.valueOf(aula.getData_hora()));
                stmt.setString(3,aula.getAssunto());
                stmt.setInt(4,id);
                stmt.executeUpdate();
        }
    }
    public void Delete(int id)throws SQLException{
        String query = """
                DELETE FROM aula 
                WHERE id = ?
                """;
        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
         stmt.setInt(1,id);
         stmt.executeUpdate();
        }
    }
}
