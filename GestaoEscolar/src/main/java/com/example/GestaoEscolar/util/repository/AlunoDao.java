package com.example.GestaoEscolar.util.repository;

import com.example.GestaoEscolar.util.conexao.Conexao;
import com.example.GestaoEscolar.util.model.Aluno;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlunoDao {

    public Aluno create(Aluno aluno) throws SQLException {

        String query = """
        INSERT INTO aluno
        (nome, email, matricula, data_nascimento)
        VALUES (?, ?, ?, ?)
    """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getMatricula());
            stmt.setDate(4, Date.valueOf(aluno.getData_aniversario()));

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                aluno.setId(rs.getInt(1));
            }

            return aluno;
        }
    }
public List<Aluno>ListOf()throws SQLException{
    List<Aluno>alunos = new ArrayList<>();
    String query = """
            SELECT 
            id,nome, email, matricula, data_nascimento
            FROM aluno
            """;
    try(Connection conn = Conexao.conectar();
    PreparedStatement stmt = conn.prepareStatement(query)){
        ResultSet rs =stmt.executeQuery();
        while(rs.next()) {
            alunos.add( new Aluno(rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("matricula"),
                    rs.getDate("data_nascimento").toLocalDate()
                    )

            );
        }

    }
    return alunos;
}
public Aluno ListById(int id)throws SQLException{
    String query = """
                SELECT 
            id,nome, email, matricula, data_nascimento
            FROM aluno
            WHERE id = ?
            """;
    try(Connection conn = Conexao.conectar();
    PreparedStatement stmt = conn.prepareStatement(query)){
        stmt.setInt(1,id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()){
            return  new Aluno(rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("matricula"),
                    rs.getDate("data_nascimento").toLocalDate()
            );
        }
    }
    return null;
}

public void Update(Aluno aluno,int id)throws SQLException{
    String query = """
            UPDATE aluno 
            SET nome = ?,
            email = ?,
            matricula =?,
            data_nascimento = ? 
            WHERE id = ? 
            """;
    try(Connection conn = Conexao.conectar();
    PreparedStatement stmt = conn.prepareStatement(query)){
        stmt.setInt(1,aluno.getId());
        stmt.setString(2, aluno.getEmail());
        stmt.setString(3,aluno.getMatricula());
        stmt.setDate(4, Date.valueOf(aluno.getData_aniversario()));
        stmt.setInt(5, id);

        stmt.executeUpdate();

    }

}
public void Delete(int id)throws SQLException{
    String query = """
            DELETE FROM aluno 
            WHERE id = ?
            """;
    try(Connection conn = Conexao.conectar();
    PreparedStatement stmt = conn.prepareStatement(query)){
        stmt.setInt(1,id);
        stmt.executeUpdate();


    }
}


}
