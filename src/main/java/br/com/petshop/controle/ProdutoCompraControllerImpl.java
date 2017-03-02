package br.com.petshop.controle;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.petshop.dao.ProdutoCompraDAO;
import br.com.petshop.modelo.ProdutoCompra;

@ManagedBean(name = "produtoCompraController")
@ViewScoped
public class ProdutoCompraControllerImpl implements ProdutoCompraController {

	@Autowired
	ProdutoCompraDAO produtoCompraDao;
	
	private ProdutoCompra produtoCompra;
	
	private List<ProdutoCompra> produtosCompraFiltrados;
	
	public ProdutoCompraControllerImpl(){
		this.produtoCompra = new ProdutoCompra();
	}

	public List<ProdutoCompra> listaProdutosCompra() {
		return this.produtoCompraDao.listaProdutosCompra();
	}
	
	
	public String novo() {
		this.produtoCompra = new ProdutoCompra();
		return "produtoCompra";
	}
	
	public String editaProdutoCompra(ProdutoCompra produtoCompra){
		this.produtoCompra = produtoCompra;
		
		return "produtoCompra";
	}
	
	public String removeProdutoCompra(ProdutoCompra c){
		produtoCompraDao.remove(c);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro excluído com sucesso!"));
		return "produtosCompra";
	}
	

	@Override
	public String grava() {
		if(this.produtoCompra.getIdProduto() != 0){
			produtoCompraDao.altera(this.produtoCompra);
		}else{
			produtoCompraDao.inclui(this.produtoCompra);
		}
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro gravado com sucesso!"));
		
		this.produtoCompra = produtoCompraDao.buscaPorId(this.produtoCompra.getIdProduto());
		
		return editaProdutoCompra(produtoCompra);
	}

	public ProdutoCompraDAO getProdutoCompraDao() {
		return produtoCompraDao;
	}

	public void setProdutoCompraDao(ProdutoCompraDAO produtoCompraDao) {
		this.produtoCompraDao = produtoCompraDao;
	}

	public ProdutoCompra getProdutoCompra() {
		return produtoCompra;
	}

	public void setProdutoCompra(ProdutoCompra produtoCompra) {
		this.produtoCompra = produtoCompra;
	}

	public List<ProdutoCompra> getProdutosCompraFiltrados() {
		return produtosCompraFiltrados;
	}

	public void setProdutosCompraFiltrados(List<ProdutoCompra> produtosCompraFiltrados) {
		this.produtosCompraFiltrados = produtosCompraFiltrados;
	}
}
