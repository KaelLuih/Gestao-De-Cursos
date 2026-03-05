package com.example.GestaoEscolar.util.repository;

import com.example.GestaoEscolar.util.conexao.Conexao;
import com.example.GestaoEscolar.util.model.Curso;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CursoDao {
    public Curso create(Curso curso) throws SQLException {
        String query = """
                INSERT INTO curso (nome, codigo)
                VALUES
                (?,?)
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getCodigo());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                curso.setId(rs.getInt(1));
            }
            return curso;
        }

    }

    public List<Curso> ListOff() throws SQLException {
        List<Curso> cursos = new ArrayList<>();
        String query = """
                SELECT 
                id,nome, codigo
                FROM curso
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cursos.add(new Curso(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("codigo")));
            }
            return cursos;
        }
    }

    public Curso LIstByID(int id) throws SQLException {
        String query = """
                 SELECT 
                id,nome, codigo
                FROM curso
                WHERE id = ?
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Curso(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("codigo"));
            }
        }
        return null;
    }
    public void   Update(Curso curso,int id)throws SQLException{
        String query = """
                UPDATE curso 
                SET nome = ?,
                codigo = ?
                WHERE id = ?
                """;
        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1,curso.getNome());
            stmt.setString(2,curso.getCodigo());
            stmt.setInt(3,id);
            stmt.executeUpdate();
        }
    }
    public void Delete(int id)throws SQLException{
        String query = """
                DELETE FROM curso 
                WHERE id = ?
                """;
        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1,id);
            stmt.executeUpdate();
        }
    }
}




