package br.com.petshop.modelo;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "id")
@ManagedBean(name = "cliente")
public class Cliente extends Pessoa {

	@Id
	@Column(name = "idCliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	
	@OneToMany(mappedBy = "dono", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private List<Animal> animais;

	private Endereco endereco;
	private Long cpf;
	private String dataNascimento;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}

}
