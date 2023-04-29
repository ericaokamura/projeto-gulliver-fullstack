package com.gulliver.projeto.usuario.projetogulliverusuario.controller;

import com.gulliver.projeto.usuario.projetogulliverusuario.mapper.UsuarioMapper;
import com.gulliver.projeto.usuario.projetogulliverusuario.model.Usuario;
import com.gulliver.projeto.usuario.projetogulliverusuario.model.dto.UsuarioDTO;
import com.gulliver.projeto.usuario.projetogulliverusuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> retornaUsuario(@PathVariable("id") Long id) throws Exception {
        try {
            UsuarioDTO dtoUsuario = service.retornaUsuario(id);
            return ResponseEntity.ok().body(dtoUsuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioDTO> retornaUsuarioPorEmail(@PathVariable("email") String email) throws Exception {
        try {
            UsuarioDTO dtoUsuario = service.retornaUsuarioPorEmail(email);
            return ResponseEntity.ok().body(dtoUsuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<UsuarioDTO>> retornaUsuarios() throws Exception {
        try {
            List<UsuarioDTO> dtosUsuario = service.retornaUsuarios();
            return ResponseEntity.ok().body(dtosUsuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<UsuarioDTO> cadastraUsuario(@RequestBody UsuarioDTO dto) throws Exception {
        try {
            UsuarioDTO dtoRetorno = service.cadastraUsuario(dto);
            System.out.println(dtoRetorno);
            return ResponseEntity.ok().body(dtoRetorno);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> editaUsuario(@PathVariable("id") Long id, @RequestBody UsuarioDTO dto) throws Exception {
        try {
            return ResponseEntity.ok().body(service.editaUsuario(id, dto));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletaUsuario(@PathVariable("id") Long id) throws Exception {
        try {
            service.deletaUsuario(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
