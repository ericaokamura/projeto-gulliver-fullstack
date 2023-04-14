package com.gulliver.projeto.usuario.projetogulliverusuario.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UsuarioDTO {

    private Long id;
    private String nomeCompleto;
    private String login;
    private String senha;
    private String email;
}
