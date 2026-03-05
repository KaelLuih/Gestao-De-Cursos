package com.example.GestaoEscolar.util.domain.dto.ProfessorDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ProfessorRequisicaoDto(
        @NotEmpty(message = "Esse campo é obrigatorio")
        String nome,
        @Email(message = "O email deve ser escrito de forma correta")
        String email,
        @NotBlank(message = "Esse campo exige um valor obrigatoriamente")
        String disciplina) {
}
