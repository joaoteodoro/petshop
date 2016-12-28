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
@Table(name = "produtoVenda")
@ManagedBean(name = "produtoVenda")
public class ProdutoVenda {

	@Id
	@Column(name = "idProdutoVenda")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProdutoVenda;

	private int quantidade;

	@ManyToOne
	private Produto produto;

	@ManyToOne
	private Venda venda;

	private Date dtExecucaoServico;

	private boolean servicoExecutado;

	public boolean isServicoExecutado() {
		return servicoExecutado;
	}

	public void setServicoExecutado(boolean servicoExecutado) {
		this.servicoExecutado = servicoExecutado;
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
}
