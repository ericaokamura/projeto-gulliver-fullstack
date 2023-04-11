package com.gulliver.projeto.usuario.projetogulliverusuario.service;

import com.gulliver.projeto.usuario.projetogulliverusuario.mapper.UsuarioMapper;
import com.gulliver.projeto.usuario.projetogulliverusuario.model.Usuario;
import com.gulliver.projeto.usuario.projetogulliverusuario.model.dto.UsuarioDTO;
import com.gulliver.projeto.usuario.projetogulliverusuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioDTO retornaUsuario(Long id) throws Exception {
        Optional<Usuario> usuario = repository.findById(id);
        if(usuario.isPresent()) {
            return UsuarioMapper.convertToDTO(usuario.get());
        } else {
            throw new Exception("Usuário não encontrado.");
        }
    }

    public void cadastraUsuario(UsuarioDTO dto) {
        repository.save(UsuarioMapper.convertToModel(dto));
    }

    public UsuarioDTO editaUsuario(Long id, UsuarioDTO dto) throws Exception {
        Optional<Usuario> usuarioRetorno = repository.findById(id);
        if(usuarioRetorno.isPresent()) {
            return dto;
        } else {
            throw new Exception("Usuário não encontrado.");
        }
    }

    public void deletaUsuario(Long id) throws Exception {
        Optional<Usuario> usuarioRetorno = repository.findById(id);
        if(usuarioRetorno.isPresent()) {
            repository.delete(usuarioRetorno.get());
        } else {
            throw new Exception("Usuário não encontrado.");
        }
    }
}
