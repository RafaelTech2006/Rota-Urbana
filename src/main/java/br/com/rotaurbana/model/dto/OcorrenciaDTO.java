package br.com.rotaurbana.model.dto;

import jakarta.validation.constraints.NotBlank;

public record OcorrenciaDTO(
        @NotBlank(message = "Este campo deve ser preenchido.")
        String titulo,
        @NotBlank(message = "Este campo deve ser preenchido.")
        String descricao,
        String status
){
}
