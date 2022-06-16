package br.com.alura.mvc.mudi.repository;

import br.com.alura.mvc.mudi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Usuario findByUsername(String username);
}
