package com.example.GestaoEscolar.util.domain.dto.turmadto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record TurmaRequisicao(
        @NotBlank(message = "O nome nao pode ser nulo")
        String nome,
        @Positive(message = "O id deve ser positivo")
        int curso_id,
         @Positive(message = "O id deve ser positivo ")
        int professor_id) {
}
