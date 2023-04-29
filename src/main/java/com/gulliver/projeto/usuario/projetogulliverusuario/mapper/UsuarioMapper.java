package com.gulliver.projeto.usuario.projetogulliverusuario.mapper;

import com.gulliver.projeto.usuario.projetogulliverusuario.model.Usuario;
import com.gulliver.projeto.usuario.projetogulliverusuario.model.dto.UsuarioDTO;
import org.springframework.stereotype.Component;

public class UsuarioMapper {

    public static UsuarioDTO convertToDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        if(usuario != null) {
            dto.setId(usuario.getId());
            dto.setEmail(usuario.getEmail());
            dto.setFullName(usuario.getFullName());
            dto.setPassword(usuario.getPassword());
            dto.setLogin(usuario.getLogin());
        }
        return dto;
    }

    public static Usuario convertToModel(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        if(dto != null) {
            usuario.setId(dto.getId());
            usuario.setEmail(dto.getEmail());
            usuario.setFullName(dto.getFullName());
            usuario.setPassword(dto.getPassword());
            usuario.setLogin(dto.getLogin());
        }
        return usuario;
    }
}
