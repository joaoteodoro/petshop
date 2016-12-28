package br.com.petshop.modelo;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produtoCompra")
@ManagedBean(name = "produtoCompra")
public class ProdutoCompra {

	@Id
	@Column(name = "idProdutoCompra")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProdutoCompra;

	private int quantidade;

	@ManyToOne
	private Produto produto;

	@ManyToOne
	private Compra compra;

	public int getIdProdutoCompra() {
		return idProdutoCompra;
	}

	public void setIdProdutoCompra(int idProdutoCompra) {
		this.idProdutoCompra = idProdutoCompra;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

}
