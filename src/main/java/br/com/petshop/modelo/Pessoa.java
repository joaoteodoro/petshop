package br.com.petshop.modelo;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
@ManagedBean(name = "pessoa")
public class Pessoa {

	@Id
	@Column(name = "idPessoa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPessoa;

	private String nome;
	private Date dtCadastro;

	@OneToMany(mappedBy = "pessoa", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private List<Telefone> telefones;

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

}
