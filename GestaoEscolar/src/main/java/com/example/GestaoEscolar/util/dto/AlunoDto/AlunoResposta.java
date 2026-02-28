package com.example.GestaoEscolar.util.dto.AlunoDto;

import java.time.LocalDate;

public record AlunoResposta(  int id,
                              String nome,
                              String email,
                              String matricula,
                              LocalDate Data_aniversario) {

}
