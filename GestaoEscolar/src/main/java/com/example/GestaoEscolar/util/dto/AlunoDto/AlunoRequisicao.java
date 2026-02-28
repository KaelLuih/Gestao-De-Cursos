package com.example.GestaoEscolar.util.dto.AlunoDto;

import java.time.LocalDate;

public record AlunoRequisicao(
                              String nome,
        String email,
        String matricula,
        LocalDate Data_aniversario
) {
}
