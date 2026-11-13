package br.com.rotaurbana.model.entity;

import br.com.rotaurbana.model.dto.RotaDTO;
import jakarta.persistence.*;

@Entity(name = "Rota")
@Table(name = "rota_ru")
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String origem;
    private String destino;
    @Column(length = 1000)
    private String descricao;

    public Rota(){
    }

    public Rota(RotaDTO rotaDTO){
        this.origem = rotaDTO.origem();
        this.destino = rotaDTO.destino();
        this.descricao = rotaDTO.descricao();
    }

    public Long getCodigo() {
        return codigo;
    }
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    public String getOrigem() {
        return origem;
    }
    public void setOrigem(String origem) {
        this.origem = origem;
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
