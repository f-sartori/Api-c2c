package com.c2c.c2c_api.model.service;

import java.util.List;

import com.c2c.c2c_api.model.Usuario;

public interface UsuarioService {

	Usuario insert(Usuario usuario);

	Usuario update(Usuario usuario);

	void delete(Usuario usuario);

	void delete(int id);

	Usuario getById(int id);

	List<Usuario> getAll();
}
