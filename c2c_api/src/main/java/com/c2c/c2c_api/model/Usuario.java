package com.c2c.c2c_api.model;

public class Usuario {
	
	private int idUsuario;
	private String nome;
	private String telefone;
	private String email;
	private String senha;
	private String senhaConf;
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSenhaConf() {
		return senhaConf;
	}
	public void setSenhaConf(String senhaConf) {
		this.senhaConf = senhaConf;
	}
	
	

}
