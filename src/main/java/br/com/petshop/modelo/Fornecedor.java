package br.com.petshop.modelo;

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

	@ManyToOne
	private Endereco endereco;
	private Long cnpj;

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
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
