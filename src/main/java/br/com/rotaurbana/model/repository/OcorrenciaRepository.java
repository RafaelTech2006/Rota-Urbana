package br.com.rotaurbana.model.repository;

import br.com.rotaurbana.model.entity.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
    Ocorrencia findByCodigo(Long codigo);
}
