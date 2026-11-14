package br.com.rotaurbana.model.repository;

import br.com.rotaurbana.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCodigo(Long codigo);
}
