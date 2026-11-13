package br.com.rotaurbana.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioDTO(
        @NotBlank(message = "Este campo deve ser preenchido.")
        String nome,
        @Email(message = "Email inválido.")
        String email,
        @NotBlank(message = "Este campo deve ser preenchido.")
        @Size(min = 8, max = 10, message = "A senha deve ter entre 8 e 10 caractéres.")
        String senha,
        @NotBlank(message = "Este campo deve ser preenchido.")
        String telefone,
        @NotBlank(message = "Este campo deve ser preenchido.")
        String cargo
){
}
