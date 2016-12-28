package br.com.petshop.modelo;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@PrimaryKeyJoinColumn(name = "id")
@ManagedBean(name = "usuario")
public class Usuario extends Pessoa {

	@Id
	@Column(name = "idUsuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;

	private Date dtCadastro;
	private String login;
	private String senha;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String usuario) {
		this.login = usuario;
	}

}