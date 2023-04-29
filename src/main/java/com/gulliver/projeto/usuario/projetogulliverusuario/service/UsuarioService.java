package com.gulliver.projeto.usuario.projetogulliverusuario.service;

import com.gulliver.projeto.usuario.projetogulliverusuario.mapper.UsuarioMapper;
import com.gulliver.projeto.usuario.projetogulliverusuario.model.Usuario;
import com.gulliver.projeto.usuario.projetogulliverusuario.model.dto.UsuarioDTO;
import com.gulliver.projeto.usuario.projetogulliverusuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioDTO retornaUsuario(Long id) throws Exception {
        Optional<Usuario> usuario = repository.findById(id);
        if(usuario.isPresent()) {
            return UsuarioMapper.convertToDTO(usuario.get());
        } return null;
    }

    public List<UsuarioDTO> retornaUsuarios() throws Exception {
        List<Usuario> usuarios = repository.findAll();
        if(!usuarios.isEmpty()) {
            List<UsuarioDTO> dtos = new ArrayList<>();
            usuarios.forEach(u -> {
                dtos.add(UsuarioMapper.convertToDTO(u));
            });
            return dtos;
        } return null;
    }

    public UsuarioDTO cadastraUsuario(UsuarioDTO dto) throws Exception {
        Optional<Usuario> usuario = repository.findByEmail(dto.getEmail());
        if(usuario.isPresent()) {
            throw new Exception("Usuário já cadastrado.");
        } else {
            return UsuarioMapper.convertToDTO(repository.save(UsuarioMapper.convertToModel(dto)));
        }
    }

    public UsuarioDTO editaUsuario(Long id, UsuarioDTO dto) throws Exception {
        Optional<Usuario> usuarioRetorno = repository.findById(id);
        if(usuarioRetorno.isPresent()) {
            Usuario usuario = UsuarioMapper.convertToModel(dto);
            usuario.setId(id);
            repository.save(usuario);
            return UsuarioMapper.convertToDTO(usuario);
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

    public UsuarioDTO retornaUsuarioPorEmail(String email) throws Exception {
        Optional<Usuario> usuario = repository.findByEmail(email);
        if(usuario.isPresent()) {
            return UsuarioMapper.convertToDTO(usuario.get());
        } return null;
    }
}
