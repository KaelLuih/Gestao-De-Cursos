package com.example.GestaoEscolar.util.domain.dto.notadto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record NotaRequisicaoDto(
        @Positive(message = "O numero deve ser positivo")
        int aluno_id,
        @Positive(message = "O numero deve ser positivo")
        int aula_id,
        @Max(10) @PositiveOrZero(message = "O numero deve ser no minimo maior que 0")
        double valor) {
}
