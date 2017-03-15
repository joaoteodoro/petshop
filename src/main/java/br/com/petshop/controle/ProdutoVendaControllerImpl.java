package br.com.petshop.controle;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.petshop.dao.ProdutoVendaDAO;
import br.com.petshop.modelo.ProdutoVenda;

@ManagedBean(name = "produtoVendaController")
@ViewScoped
public class ProdutoVendaControllerImpl implements ProdutoVendaController {

	@Autowired
	ProdutoVendaDAO produtoVendaDao;
	
	private ProdutoVenda produtoVenda;
	
	private List<ProdutoVenda> ProdutoVendaFiltrados;
	
	public ProdutoVendaControllerImpl(){
		this.produtoVenda = new ProdutoVenda();
	}

	public List<ProdutoVenda> listaProdutosVenda() {
		return this.produtoVendaDao.listaProdutosVenda();
	}
	
	
	public String novo() {
		this.produtoVenda = new ProdutoVenda();
		return "produtoVenda";
	}
	
	public String editaProdutoVenda(ProdutoVenda produtoVenda){
		this.produtoVenda = produtoVenda;
		
		return "produtoVenda";
	}
	
	public String removeProdutoVenda(ProdutoVenda c){
		produtoVendaDao.remove(c);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro excluído com sucesso!"));
		return "produtosVenda";
	}
	

	@Override
	public String grava() {
		if(this.produtoVenda.getIdProdutoVenda() != 0){
			produtoVendaDao.altera(this.produtoVenda);
		}else{
			produtoVendaDao.inclui(this.produtoVenda);
		}
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro gravado com sucesso!"));
		
		this.produtoVenda = produtoVendaDao.buscaPorId(this.produtoVenda.getIdProdutoVenda());
		
		return editaProdutoVenda(produtoVenda);
	}

	public ProdutoVendaDAO getProdutoVendaDao() {
		return produtoVendaDao;
	}

	public void setProdutoVendaDao(ProdutoVendaDAO produtoVendaDao) {
		this.produtoVendaDao = produtoVendaDao;
	}

	public ProdutoVenda getProdutoVenda() {
		return produtoVenda;
	}

	public void setProdutoVenda(ProdutoVenda produtoVenda) {
		this.produtoVenda = produtoVenda;
	}

	public List<ProdutoVenda> getProdutoVendaFiltrados() {
		return ProdutoVendaFiltrados;
	}

	public void setProdutoVendaFiltrados(List<ProdutoVenda> produtoVendaFiltrados) {
		ProdutoVendaFiltrados = produtoVendaFiltrados;
	}
}
