package br.com.petshop.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//@Entity
//@PrimaryKeyJoinColumn(name = "idProduto")
//@Table(name = "produtoCompra")
//@ManagedBean(name = "produtoCompra")
public class ProdutoCompra extends Produto{

	@Id
	@Column(name = "idProdutoCompra")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProdutoCompra;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int quantidade;
	
	private BigDecimal valorUnitario;

	@ManyToOne
	private Produto produto;

	@ManyToOne
	private Compra compra;

	public Long getIdProdutoCompra() {
		return idProdutoCompra;
	}

	public void setIdProdutoCompra(Long idProdutoCompra) {
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

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
}
