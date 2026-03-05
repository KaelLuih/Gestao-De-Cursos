package com.example.GestaoEscolar.util.domain.dto.cursodto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CursoRequisicaoDto(
        @NotEmpty(message = "Esse Campo é obrigatorio")
        String nome,
        @Size(min=3, message = "O codigo deve ser maior de 3 digitos")
        String codigo
) {
}
