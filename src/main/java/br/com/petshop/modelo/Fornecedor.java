package br.com.petshop.modelo;

import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "fornecedor")
@PrimaryKeyJoinColumn(name = "idPessoa")
@ManagedBean(name = "fornecedor")
public class Fornecedor extends Pessoa {

//	@Id
//	@Column(name = "idFornecedor")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int idFornecedor;
	
	public Fornecedor() {
		this.endereco = new Endereco();
		this.setTelefones(Arrays.asList(new Telefone(), new Telefone()));
	}

	@ManyToOne
	private Endereco endereco;
	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/*public int getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}*/

}
