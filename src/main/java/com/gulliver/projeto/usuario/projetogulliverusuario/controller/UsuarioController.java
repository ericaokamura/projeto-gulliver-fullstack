package com.gulliver.projeto.usuario.projetogulliverusuario.controller;

import com.gulliver.projeto.usuario.projetogulliverusuario.mapper.UsuarioMapper;
import com.gulliver.projeto.usuario.projetogulliverusuario.model.Usuario;
import com.gulliver.projeto.usuario.projetogulliverusuario.model.dto.UsuarioDTO;
import com.gulliver.projeto.usuario.projetogulliverusuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/{id}")
    public UsuarioDTO retornaUsuario(@PathVariable("id") Long id) throws Exception {
        UsuarioDTO dtoUsuario = service.retornaUsuario(id);
        return dtoUsuario;
    }

    @PostMapping("/")
    public void cadastraUsuario(@RequestBody UsuarioDTO dto) {
        service.cadastraUsuario(dto);
    }

    @PutMapping("/{id}")
    public UsuarioDTO editaUsuario(@PathVariable("id") Long id, @RequestBody UsuarioDTO dto) throws Exception {
        return service.editaUsuario(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletaUsuario(@PathVariable("id") Long id) throws Exception {
        service.deletaUsuario(id);
    }
}
