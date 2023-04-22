package com.gulliver.projeto.usuario.projetogulliverusuario.repository;

import com.gulliver.projeto.usuario.projetogulliverusuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findById(Long id);

    Usuario save(Usuario usuario);

    @Override
    void delete(Usuario usuario);

    Optional<Usuario> findByEmail(String email);
}

