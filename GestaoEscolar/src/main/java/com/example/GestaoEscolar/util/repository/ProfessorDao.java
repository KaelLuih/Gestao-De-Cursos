package com.example.GestaoEscolar.util.repository;

import com.example.GestaoEscolar.util.conexao.Conexao;
import com.example.GestaoEscolar.util.model.Professor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ProfessorDao {

    public Professor create(Professor professor)throws SQLException{
        String query = """
                INSERT INTO professor (nome, email, disciplina) 
                VALUES
                (?,?,?)
                """;
        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getDisciplina());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                professor.setId(rs.getInt(1 ));
            }
            return professor;
        }
    }

public List<Professor>ListOff()throws SQLException{
        List<Professor>professores = new ArrayList<>();
        String query = """
                SELECT  
                id, nome, email, disciplina 
                FROM professor              
                """;
        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                professores.add(new Professor(rs.getInt("id"),rs.getString("nome"),rs.getString("email"),rs.getString("disciplina")));
            }
            return professores;
        }
}

public Professor ListById(int id)throws SQLException{
        String query = """
                SELECT  
                id, nome, email, disciplina 
                FROM professor
                WHERE id = ?
                """;
        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)) {
                 stmt.setInt(1,id);
                 ResultSet rs = stmt.executeQuery();
                 if(rs.next()){
                    return new Professor
                             (rs.getInt("id"),
                                     rs.getString("nome"),
                                     rs.getString("email"),
                                     rs.getString("disciplina"));
                 }
                 return null;


        }

    }
    public void Update(Professor professor,int id)throws SQLException{
        String query = """
                UPDATE professor
                SET nome = ?,
                email = ?,
                disciplina = ?
                WHERE id =?
                
                """;
        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1,professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getDisciplina());
            stmt.setInt(4,id);
            stmt.executeUpdate();

        }
    }

    public void Delete(int id)throws SQLException{
        String query = """
                DELETE FROM professor 
                WHERE id = ?
                """;
        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
        }
    }
}



