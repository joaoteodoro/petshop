package br.com.petshop.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "produto")
@ManagedBean(name = "produto")
public class Produto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name = "idProduto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProduto;

	
	private String nome;
	private String descricao;
	//private Date dtCompra;
	//private TipoUnidade tipoUnidadeCompra; // peca, pacote, quilograma,
	//private TipoUnidade tipoUnidadeVenda;
	//private float quantidadeCompra;
	//private float quantidadeVenda; // 1 pct, 1 peca, 1 kg
	
	//private Fornecedor fornecedor;
	private BigDecimal valor;
	//private boolean servico;
	
	/*@OneToMany(mappedBy = "produto", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private List<ProdutoVenda> produtosVenda;
	
	@OneToMany(mappedBy = "produto", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private List<ProdutoCompra> produtoCompra;*/

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/*public Date getDtCompra() {
		return dtCompra;
	}

	public void setDtCompra(Date dtCompra) {
		this.dtCompra = dtCompra;
	}*/

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	

	/*public float getQuantidadeCompra() {
		return quantidadeCompra;
	}

	public void setQuantidadeCompra(float quantidadeCompra) {
		this.quantidadeCompra = quantidadeCompra;
	}

	public float getQuantidadeVenda() {
		return quantidadeVenda;
	}

	public void setQuantidadeVenda(float quantidadeVenda) {
		this.quantidadeVenda = quantidadeVenda;
	}*/

	/*public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}*/

	/*public TipoUnidade getTipoUnidadeCompra() {
		return tipoUnidadeCompra;
	}

	public void setTipoUnidadeCompra(TipoUnidade tipoUnidadeCompra) {
		this.tipoUnidadeCompra = tipoUnidadeCompra;
	}

	public TipoUnidade getTipoUnidadeVenda() {
		return tipoUnidadeVenda;
	}

	public void setTipoUnidadeVenda(TipoUnidade tipoUnidadeVenda) {
		this.tipoUnidadeVenda = tipoUnidadeVenda;
	}

	public float getValorDeCompra() {
		return valorDeCompra;
	}

	public void setValorDeCompra(float valorDeCompra) {
		this.valorDeCompra = valorDeCompra;
	}

	public float getValoDeVenda() {
		return valoDeVenda;
	}

	public void setValoDeVenda(float valoDeVenda) {
		this.valoDeVenda = valoDeVenda;
	}*/

	/*public boolean isServico() {
		return servico;
	}

	public void setServico(boolean servico) {
		this.servico = servico;
	}

	public List<ProdutoVenda> getProdutosVenda() {
		return produtosVenda;
	}

	public void setProdutosVenda(List<ProdutoVenda> produtosVenda) {
		this.produtosVenda = produtosVenda;
	}

	public List<ProdutoCompra> getProdutoCompra() {
		return produtoCompra;
	}

	public void setProdutoCompra(List<ProdutoCompra> produtoCompra) {
		this.produtoCompra = produtoCompra;
	}*/

}
