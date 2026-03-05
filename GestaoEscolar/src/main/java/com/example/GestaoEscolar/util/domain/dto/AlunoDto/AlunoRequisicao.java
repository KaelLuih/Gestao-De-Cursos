package com.example.GestaoEscolar.util.domain.dto.AlunoDto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record AlunoRequisicao(
        @NotBlank
        String nome,
        @Email
        String email,
        @NotNull
        String matricula,
        @Future(message = "A data de nascimento" +
                " nao pode ser no futuro")
        LocalDate Data_aniversario
) {
}
