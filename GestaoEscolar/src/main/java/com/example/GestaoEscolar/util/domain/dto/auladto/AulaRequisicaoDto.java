package com.example.GestaoEscolar.util.domain.dto.auladto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record AulaRequisicaoDto(
        @Positive(message = "O ID deve ser possitivo")
        int turma_id,
         @Past(message = "A Aula nao pode ser marcada no passado")
         LocalDateTime data_hora,
        @NotEmpty(message = "O Assunto nao pode ser nulo")
        String assunto) {
}
