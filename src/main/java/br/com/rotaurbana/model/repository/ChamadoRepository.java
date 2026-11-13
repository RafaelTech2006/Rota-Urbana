package br.com.rotaurbana.model.repository;

import br.com.rotaurbana.model.entity.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {
    Chamado findByCodigo(Long codigo);
}
