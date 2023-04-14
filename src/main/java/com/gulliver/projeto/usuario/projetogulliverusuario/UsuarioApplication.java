package com.gulliver.projeto.usuario.projetogulliverusuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.gulliver.projeto.usuario.projetogulliverusuario.*")
@ComponentScan(basePackages = { "com.gulliver.projeto.usuario.projetogulliverusuario.*" })
@EntityScan("com.gulliver.projeto.usuario.projetogulliverusuario.*")
public class UsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioApplication.class, args);
	}

}
