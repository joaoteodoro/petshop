package br.com.petshop.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.petshop.dao.CompraDAO;
import br.com.petshop.dao.FornecedorDAOImpl;
import br.com.petshop.dao.ProdutoDAOImpl;
import br.com.petshop.modelo.Compra;
import br.com.petshop.modelo.FormaPagamento;
import br.com.petshop.modelo.Fornecedor;
import br.com.petshop.modelo.Produto;
import br.com.petshop.modelo.ProdutoCompra;

@ManagedBean(name = "compraController")
@ViewScoped
public class CompraController{

	@Autowired
	CompraDAO compraDao;
	
	@Autowired
	ProdutoDAOImpl produtoDao;
	
	@Autowired
	FornecedorDAOImpl fornecedorDao;
	
	private Compra compra;
	
	private List<Compra> compraFiltrados;
	
	private Long idprodutoAdicionar;
	
	public CompraController(){
		this.compra = new Compra();
	}

	public List<Compra> listaCompras() {
		return this.compraDao.getList();
	}
	
	public String novo() {
		this.compra = new Compra();
		compra.setFornecedor(new Fornecedor());
		return "compra";
	}
	
	public String editaCompra(Compra compra){
		this.compra = compra;
		
		return "compra";
	}
	
	public String removeCompra(Compra c){
		compraDao.remover(c.getIdCompra());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro excluído com sucesso!"));
		return "compras";
	}
	
	public String grava() {
		if(this.compra.getIdCompra() != null){
			compraDao.atualizar(this.compra);
		}else{
			compraDao.salvar(this.compra);
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro gravado com sucesso!"));
		
		this.compra = compraDao.encontrar(this.compra.getIdCompra());
		return editaCompra(this.compra);
	}
	
	public List<SelectItem> selectItensFornecedores(){
		List<SelectItem> itens = new ArrayList<>();
		for (Fornecedor fornecedor : fornecedorDao.getList()) {
			itens.add(new SelectItem(fornecedor.getIdPessoa(), fornecedor.getNome()));
		} 
		return itens;
	}
	
	public List<SelectItem> selectItensFormaPagamento(){
		List<SelectItem> itens = new ArrayList<>();
		for (FormaPagamento formaPagamento : FormaPagamento.values()) {
			itens.add(new SelectItem(formaPagamento, formaPagamento.getDescricao()));
		}
		return itens;
	}
	
	public void adicionarNovoProduto(){
		Produto produto = produtoDao.encontrar(idprodutoAdicionar);
		ProdutoCompra produtoCompra = new ProdutoCompra();
		produtoCompra.setProduto(produto);
		if(this.compra.getProdutosCompra() == null){
			this.compra.setProdutosCompra(new ArrayList<ProdutoCompra>());
		}
		this.compra.getProdutosCompra().add(produtoCompra);
	}

	public CompraDAO getCompraDao() {
		return compraDao;
	}

	public void setCompraDao(CompraDAO compraDao) {
		this.compraDao = compraDao;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public List<Compra> getCompraFiltrados() {
		return compraFiltrados;
	}

	public void setCompraFiltrados(List<Compra> compraFiltrados) {
		this.compraFiltrados = compraFiltrados;
	}

	public ProdutoDAOImpl getProdutoDao() {
		return produtoDao;
	}

	public void setProdutoDao(ProdutoDAOImpl produtoDao) {
		this.produtoDao = produtoDao;
	}

	public FornecedorDAOImpl getFornecedorDao() {
		return fornecedorDao;
	}

	public void setFornecedorDao(FornecedorDAOImpl fornecedorDao) {
		this.fornecedorDao = fornecedorDao;
	}

	public Long getIdprodutoAdicionar() {
		return idprodutoAdicionar;
	}

	public void setIdprodutoAdicionar(Long idprodutoAdicionar) {
		this.idprodutoAdicionar = idprodutoAdicionar;
	}

	
}
