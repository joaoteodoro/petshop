package br.com.petshop.modelo;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
//@PrimaryKeyJoinColumn(name = "idProduto")
@Table(name = "produtoVenda")
@ManagedBean(name = "produtoVenda")
public class ProdutoVenda /*extends Produto*/{

	@Id
	@Column(name = "idProdutoVenda")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProdutoVenda;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int quantidade;
	
	private TipoUnidade tipoUnidadeVenda;

	@ManyToOne
	private Produto produto;

	@ManyToOne
	private Venda venda;

	private Date dtExecucaoServico;

	private boolean servicoExecutado;
	
	private boolean ehServico;

	public int getIdProdutoVenda() {
		return idProdutoVenda;
	}

	public void setIdProdutoVenda(int idProdutoVenda) {
		this.idProdutoVenda = idProdutoVenda;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public TipoUnidade getTipoUnidadeVenda() {
		return tipoUnidadeVenda;
	}

	public void setTipoUnidadeVenda(TipoUnidade tipoUnidadeVenda) {
		this.tipoUnidadeVenda = tipoUnidadeVenda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Date getDtExecucaoServico() {
		return dtExecucaoServico;
	}

	public void setDtExecucaoServico(Date dtExecucaoServico) {
		this.dtExecucaoServico = dtExecucaoServico;
	}

	public boolean isServicoExecutado() {
		return servicoExecutado;
	}

	public void setServicoExecutado(boolean servicoExecutado) {
		this.servicoExecutado = servicoExecutado;
	}

	public boolean isEhServico() {
		return ehServico;
	}

	public void setEhServico(boolean ehServico) {
		this.ehServico = ehServico;
	}

	
}
