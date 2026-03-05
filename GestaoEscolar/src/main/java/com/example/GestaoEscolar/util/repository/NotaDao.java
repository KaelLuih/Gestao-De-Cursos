package com.example.GestaoEscolar.util.repository;

import com.example.GestaoEscolar.util.conexao.Conexao;
import com.example.GestaoEscolar.util.model.Nota;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class NotaDao {

    public Nota Create(Nota nota) throws SQLException {
        String query = """
                INSERT INTO nota (aluno_id, aula_id, valor) VALUES
                (?,?,?)
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, nota.getAluno_id());
            stmt.setInt(2, nota.getAula_id());
            stmt.setDouble(3, nota.getValor());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                nota.setId(rs.getInt(1));
            }
        }
        return nota;
    }

    public List<Nota> ListOff() throws SQLException {
        List<Nota> notas = new ArrayList<>();
        String query = "SELECT id, aluno_id, aula_id, valor FROM nota";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                notas.add(new Nota(
                        rs.getInt("id"),
                        rs.getInt("aluno_id"),
                        rs.getInt("aula_id"),
                        rs.getDouble("valor")
                ));
            }
        }
        return notas;
    }

    public Nota ListById(int id) throws SQLException {
        String query = "SELECT id, aluno_id, aula_id, valor FROM nota WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Nota(
                        rs.getInt("id"),
                        rs.getInt("aluno_id"),
                        rs.getInt("aula_id"),
                        rs.getDouble("valor")
                );
            }
        }
        return null;
    }

    public void Update(Nota nota, int id) throws SQLException {
        String query = """
                UPDATE nota 
                SET aluno_id = ?,
                    aula_id = ?,
                    valor = ?
                WHERE id = ?    
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, nota.getAluno_id());
            stmt.setInt(2, nota.getAula_id());
            stmt.setDouble(3, nota.getValor());
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }

    public void Delete(int id) throws SQLException {
        String query = "DELETE FROM nota WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Nota> ListByAlunoId(int alunoId) throws SQLException {
        List<Nota> notas = new ArrayList<>();
        String query = "SELECT id, aluno_id, aula_id, valor FROM nota WHERE aluno_id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, alunoId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                notas.add(new Nota(
                        rs.getInt("id"),
                        rs.getInt("aluno_id"),
                        rs.getInt("aula_id"),
                        rs.getDouble("valor")
                ));
            }
        }
        return notas;
    }

}
