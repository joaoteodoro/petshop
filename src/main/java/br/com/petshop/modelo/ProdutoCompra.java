package br.com.petshop.modelo;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "idProduto")
@Table(name = "produtoCompra")
@ManagedBean(name = "produtoCompra")
public class ProdutoCompra extends Produto{

//	@Id
//	@Column(name = "idProdutoCompra")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int idProdutoCompra;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int quantidade;
	
	private TipoUnidade tipoUnidadeCompra;

//	@ManyToOne
//	private Produto produto;

	@ManyToOne
	private Compra compra;
	
	private Long quantidadeEstoque;

	/*public int getIdProdutoCompra() {
		return idProdutoCompra;
	}

	public void setIdProdutoCompra(int idProdutoCompra) {
		this.idProdutoCompra = idProdutoCompra;
	}*/

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/*public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}*/

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public TipoUnidade getTipoUnidadeCompra() {
		return tipoUnidadeCompra;
	}

	public void setTipoUnidadeCompra(TipoUnidade tipoUnidadeCompra) {
		this.tipoUnidadeCompra = tipoUnidadeCompra;
	}

	public Long getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Long quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

}
