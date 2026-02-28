package com.example.GestaoEscolar.util.model;

import java.time.LocalDate;

public class Aluno {
private int id;
private String nome;
private String email;
private String matricula;
private LocalDate Data_aniversario;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getData_aniversario() {
        return Data_aniversario;
    }

    public void setData_aniversario(LocalDate data_aniversario) {
        Data_aniversario = data_aniversario;
    }

    public Aluno() {
    }

    public Aluno(String nome, String email, String matricula, LocalDate data_aniversario) {
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        Data_aniversario = data_aniversario;
    }

    public Aluno(int id, String nome, String email, String matricula, LocalDate data_aniversario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        Data_aniversario = data_aniversario;
    }
}
