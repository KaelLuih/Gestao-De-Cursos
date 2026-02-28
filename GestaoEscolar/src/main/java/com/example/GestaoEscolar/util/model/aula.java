package com.example.GestaoEscolar.util.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class aula {

    private int id;
    private int turma_id;
    private LocalDateTime data_hora;
    private String assunto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTurma_id() {
        return turma_id;
    }

    public void setTurma_id(int turma_id) {
        this.turma_id = turma_id;
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public void setData_hora(LocalDateTime data_hora) {
        this.data_hora = data_hora;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public aula() {
    }

    public aula(int turma_id, LocalDateTime data_hora, String assunto) {
        this.turma_id = turma_id;
        this.data_hora = data_hora;
        this.assunto = assunto;
    }

    public aula(int id, int turma_id, LocalDateTime data_hora, String assunto) {
        this.id = id;
        this.turma_id = turma_id;
        this.data_hora = data_hora;
        this.assunto = assunto;
    }
}
