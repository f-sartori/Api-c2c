package com.c2c.c2c_api.model.sevice.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.c2c.c2c_api.model.Product;
import com.c2c.c2c_api.model.Usuario;
import com.c2c.c2c_api.model.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {
	
	static List<Usuario> usuarios = new ArrayList<Usuario>();
	private static int inc = 0;

	@Override
	public Usuario insert(Usuario usuario) {
		inc++;
		usuario.setIdUsuario(inc);

		this.usuarios.add(usuario);

		return usuario;
	}

	@Override
	public Usuario update(Usuario usuario) {
		
		Usuario aux = getById(usuario.getIdUsuario());
		
		if(aux != null) {
			
			aux.setEmail(usuario.getEmail());
			aux.setNome(usuario.getNome());
			aux.setSenha(usuario.getSenha());
			aux.setTelefone(usuario.getTelefone());
			
		}
		return null;
	}

	@Override
	public void delete(Usuario usuario) {
		delete(usuario.getIdUsuario());
		
	}

	@Override
	public void delete(int id) {
		for (Iterator<Usuario> i = usuarios.iterator(); i.hasNext();) {
			Usuario usuarioDelete = i.next();

			if (usuarioDelete.getIdUsuario() == id) {
				i.remove();

			}

		}
		
	}

	@Override
	public Usuario getById(int id) {
		
		for (Usuario usuario : usuarios) {
			if(usuario.getIdUsuario() == id) {
				return usuario;
			}
		}
		return null;
	}

	@Override
	public List<Usuario> getAll() {
		
		return usuarios;
	}
}
