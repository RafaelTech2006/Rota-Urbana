package br.com.rotaurbana.model.repository;

import br.com.rotaurbana.model.entity.Rota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RotaRepository extends JpaRepository<Rota, Long> {
    Rota findByCodigo(Long codigo);
}
