package com.c2c.c2c_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.c2c.c2c_api.model.Product;
import com.c2c.c2c_api.model.Usuario;
import com.c2c.c2c_api.model.security.Auth;
import com.c2c.c2c_api.model.security.Token;
import com.c2c.c2c_api.model.service.ProductService;
import com.c2c.c2c_api.model.service.UsuarioService;
import com.c2c.c2c_api.model.sevice.impl.ProductServiceImpl;
import com.c2c.c2c_api.model.sevice.impl.UsuarioServiceImpl;



@CrossOrigin("*")
@RestController
public class UsuarioController {
	
	UsuarioService usuarioService = new UsuarioServiceImpl();
	
	
	@GetMapping("/usuario/all")
	public List<Usuario> getAll() {
		return usuarioService.getAll();
	}

	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable int id) {

		Usuario usuario = usuarioService.getById(id);
		
		if (usuario == null)
			ResponseEntity.notFound();

		return ResponseEntity.ok(usuario);
	}

	@PostMapping("/usuario/new")
	public ResponseEntity<Usuario> insert(@RequestBody Usuario usuario) {
		if (usuario.getIdUsuario() != 0)
			return ResponseEntity.badRequest().body(usuario);

		usuarioService.insert(usuario);
		return ResponseEntity.ok(usuario);
	}

	@PutMapping("/usuario")
	public Usuario alterar(@RequestBody Usuario usuario) {
		usuarioService.update(usuario);
		return usuario;
	}
	
	@DeleteMapping("/usuario/{id}")
	public void delete(@PathVariable int id) {
		usuarioService.delete(id);
	}
	
	
	@PostMapping("/usuario/login")
	public ResponseEntity<Token> autenticar(@RequestBody Usuario usuario) {
		
		for (int i = 0; i < usuarioService.getAll().size(); i++) {
			if (usuario.getEmail().equals(usuarioService.getAll().get(i).getEmail())
					&& usuario.getSenha().equals(usuarioService.getAll().get(i).getSenha())) {
				usuario = usuarioService.getAll().get(i);
				String tk = Auth.generateToken(usuario);
				Token token = new Token();
				token.setToken(tk);
				token.setNome(usuarioService.getAll().get(i).getNome());
				token.setEmail(usuarioService.getAll().get(i).getEmail());

				return ResponseEntity.ok(token);
			}
		}
		return ResponseEntity.status(403).build();
	}
}
