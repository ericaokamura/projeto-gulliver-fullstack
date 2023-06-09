package com.gulliver.projeto.usuario.projetogulliverusuario.model;

import javax.persistence.*;

import javax.validation.constraints.Size;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Table(schema="usuario")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String fullName;
    @NotEmpty
    private String login;
    @NotEmpty
    @Size(min = 8, max = 200, message = "Senha deve ter no mínimo 8 caracteres")
    private String password;
    @NotEmpty
    @Email(message = "Email deve ser válido")
    private String email;

}
