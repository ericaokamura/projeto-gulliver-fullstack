package com.gulliver.projeto.usuario.projetogulliverusuario.model;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String nomeCompleto;
    @NotEmpty
    private String login;
    @NotEmpty
    @Size(min = 8, max = 200, message = "Senha deve ter no mínimo 8 caracteres")
    private String senha;
    @NotEmpty
    @Email(message = "Email deve ser válido")
    private String email;

}
