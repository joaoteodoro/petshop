package br.com.petshop.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "idPessoa")
@ManagedBean(name = "cliente")
public class Cliente extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@Id
//	@Column(name = "idCliente")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int idCliente;
	
	@OneToMany(mappedBy = "dono", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private List<Animal> animais = new ArrayList<>();

	@ManyToOne
	private Endereco endereco;
	
	private String cpf;
	private String dataNascimento;
	
	public Cliente(){
		this.endereco = new Endereco();
		this.setTelefones(Arrays.asList(new Telefone(), new Telefone()));
		this.animais.add(new Animal());
		this.animais.add(new Animal());
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/*public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}*/

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
