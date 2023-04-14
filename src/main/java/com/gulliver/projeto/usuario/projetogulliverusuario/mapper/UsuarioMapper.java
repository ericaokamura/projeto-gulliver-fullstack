package com.gulliver.projeto.usuario.projetogulliverusuario.mapper;

import com.gulliver.projeto.usuario.projetogulliverusuario.model.Usuario;
import com.gulliver.projeto.usuario.projetogulliverusuario.model.dto.UsuarioDTO;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public static UsuarioDTO convertToDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        if(usuario != null) {
            dto.setId(usuario.getId());
            dto.setEmail(usuario.getEmail());
            dto.setNomeCompleto(usuario.getNomeCompleto());
            dto.setSenha(usuario.getSenha());
            dto.setLogin(usuario.getLogin());
        }
        return dto;
    }

    public static Usuario convertToModel(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        if(dto != null) {
            usuario.setId(dto.getId());
            usuario.setEmail(dto.getEmail());
            usuario.setNomeCompleto(dto.getNomeCompleto());
            usuario.setSenha(dto.getSenha());
            usuario.setLogin(dto.getLogin());
        }
        return usuario;
    }
}
