package com.example.GestaoEscolar.util.domain.dto.auladto;

import java.time.LocalDateTime;

public record AulaRequisicaoDto( int turma_id,
         LocalDateTime data_hora,
         String assunto) {
}
