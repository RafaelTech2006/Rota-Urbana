package br.com.rotaurbana.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ChamadoDTO(
        @NotBlank(message = "Este campo deve ser preenchido.")
        String titulo,
        @NotBlank(message = "Este campo deve ser preenchido.")
        String descricao,
        @NotBlank(message = "Este campo deve ser preenchido.")
        String prioridade
){
}

