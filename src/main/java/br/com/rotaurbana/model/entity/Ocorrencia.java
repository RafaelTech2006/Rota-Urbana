package br.com.rotaurbana.model.entity;

import br.com.rotaurbana.model.dto.OcorrenciaDTO;
import jakarta.persistence.*;

@Entity(name = "Ocorrencia")
@Table(name = "ocorrencia_ru")
public class Ocorrencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String titulo;
    @Column(length = 1000)
    private String descricao;
    private String status;

    public Ocorrencia(){
    }

    public Ocorrencia(OcorrenciaDTO ocorrenciaDTO){
        this.titulo = ocorrenciaDTO.titulo();
        this.descricao = ocorrenciaDTO.descricao();
        this.status = ocorrenciaDTO.status();
    }

    public Long getCodigo() {
        return codigo;
    }
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}