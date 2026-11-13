package br.com.rotaurbana.model.entity;

import br.com.rotaurbana.model.dto.ChamadoDTO;
import jakarta.persistence.*;

@Entity(name = "Chamado")
@Table(name = "chamado_ru")
public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String titulo;
    @Column(length = 1000)
    private String descricao;
    private String prioridade;

    public Chamado(){
    }

    public Chamado(ChamadoDTO chamadoDTO) {
        this.titulo = chamadoDTO.titulo();
        this.descricao = chamadoDTO.descricao();
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
    public String getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }
}
