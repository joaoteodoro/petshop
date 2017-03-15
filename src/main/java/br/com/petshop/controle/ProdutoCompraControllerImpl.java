package br.com.petshop.controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.petshop.dao.ProdutoCompraDAO;
import br.com.petshop.modelo.ProdutoCompra;
import br.com.petshop.modelo.TipoUnidade;

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
	
	public void escolheProdutoCompra() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        options.put("draggable", false);
        options.put("modal", true);
        RequestContext.getCurrentInstance().openDialog("selecionarProdutoCompra", options, null);
    }
	

	@Override
	public String grava() {
		if(this.produtoCompra.getIdProdutoCompra() != 0){
			produtoCompraDao.altera(this.produtoCompra);
		}else{
			produtoCompraDao.inclui(this.produtoCompra);
		}
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro gravado com sucesso!"));
		
		this.produtoCompra = produtoCompraDao.buscaPorId(this.produtoCompra.getIdProdutoCompra());
		
		return editaProdutoCompra(produtoCompra);
	}
	
	public List<SelectItem> selectItensTipoUnidade(){
		List<SelectItem> itens = new ArrayList<>();
		for (TipoUnidade tipoUnidade : TipoUnidade.values()) {
			itens.add(new SelectItem(tipoUnidade, tipoUnidade.getDescricao()));
		} 
		return itens;
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
