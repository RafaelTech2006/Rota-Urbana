package br.com.rotaurbana.model.entity;

import br.com.rotaurbana.model.dto.UsuarioDTO;
import jakarta.persistence.*;

@Entity(name = "Usuario")
@Table(name = "usuario_ru")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String cargo;

    public Usuario(){
    }

    public Usuario(UsuarioDTO usuarioDTO){
        this.nome = usuarioDTO.nome();
        this.email = usuarioDTO.email();
        this.senha = usuarioDTO.senha();
        this.telefone = usuarioDTO.telefone();
        this.cargo = usuarioDTO.cargo();
    }

    public Long getCodigo() {
        return codigo;
    }
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
