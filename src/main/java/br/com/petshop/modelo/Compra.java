package br.com.petshop.modelo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "compra")
@ManagedBean(name = "compra")
public class Compra {

	@Id
	@Column(name = "idCompra")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCompra;
	
	@OneToMany(mappedBy = "compra", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private List<ProdutoCompra> produtosCompra;

	@ManyToOne
	private Fornecedor fornecedor;

	private BigDecimal valorFinal;

	private Date dtCompra;
	
	private boolean compraParcelada;
	
	private Long nrParcelas;
	
	@OneToMany(mappedBy = "compra", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private List<Parcela> parcelas;
	
	private Date dtVencimento;
	
	@Enumerated(EnumType.STRING)
	private FormaPagamento formaPagamento;

	public Long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public BigDecimal getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}

	public Date getDtCompra() {
		return dtCompra;
	}

	public void setDtCompra(Date dtCompra) {
		this.dtCompra = dtCompra;
	}

	public List<Parcela> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}

	public List<ProdutoCompra> getProdutosCompra() {
		return produtosCompra;
	}

	public void setProdutosCompra(List<ProdutoCompra> produtosCompra) {
		this.produtosCompra = produtosCompra;
	}

	public Date getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public boolean isCompraParcelada() {
		return compraParcelada;
	}

	public void setCompraParcelada(boolean compraParcelada) {
		this.compraParcelada = compraParcelada;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Long getNrParcelas() {
		return nrParcelas;
	}

	public void setNrParcelas(Long nrParcelas) {
		this.nrParcelas = nrParcelas;
	}

}
