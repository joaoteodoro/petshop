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
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.petshop.dao.ProdutoDAO;
import br.com.petshop.modelo.Produto;
import br.com.petshop.modelo.TipoProduto;
import br.com.petshop.modelo.TipoUnidade;

@ManagedBean(name = "produtoController")
@ViewScoped
public class ProdutoControllerImpl implements ProdutoController {

	@Autowired
	ProdutoDAO produtoDao;
	
	private Produto produto;
	
	private boolean exibeProduto;
	
	private List<Produto> produtosFiltrados;
	
	public ProdutoControllerImpl(){
		this.produto = new Produto();
	}

	public List<Produto> listaProdutos() {
		return this.produtoDao.listaProdutos();
	}
	
	
	public String novo() {
		this.produto = new Produto();
		return "produto";
	}
	
	public String editaProduto(Produto produto){
		this.produto = produto;
		
		return "produto";
	}
	
	public String removeProduto(Produto p){
		produtoDao.remove(p);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro excluído com sucesso!"));
		return "produtos";
	}
	

	public String grava() {
		if(this.produto.getIdProduto() != 0){
			produtoDao.altera(this.produto);
		}else{
			produtoDao.inclui(this.produto);
		}
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro gravado com sucesso!"));
		
		this.produto = produtoDao.buscaPorId(this.produto.getIdProduto());
		
		return editaProduto(produto);
	}
	
	public List<SelectItem> selectItensTipoUnidade(){
		List<SelectItem> itens = new ArrayList<>();
		for (TipoUnidade tipoUnidade : TipoUnidade.values()) {
			itens.add(new SelectItem(tipoUnidade, tipoUnidade.getDescricao()));
		} 
		return itens;
	}
	
	public List<SelectItem> selectItensTipoProduto(){
		List<SelectItem> itens = new ArrayList<>();
		for (TipoProduto tipoProduto : TipoProduto.values()) {
			itens.add(new SelectItem(tipoProduto, tipoProduto.getDescricao()));
		} 
		return itens;
	}
	
	public void escolheProdutoCompra() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        options.put("draggable", false);
        options.put("modal", true);
        RequestContext.getCurrentInstance().openDialog("selecionarProdutoCompra", options, null);
    }
	
	public void aoSelecionarProdutoCompra() {
        Produto produto = this.produto.getProdutoMatriz();
        //FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto Selecionado", "Id:" + produto.getIdProduto());
         
        //FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	public void exibirProdutoCompra(){
		if(produto.getTipoProduto().equals(TipoProduto.venda)){
			exibeProduto = true;
		}else{
			exibeProduto = false;
		}
	}
	
	public List<Produto> produtosCompras(){
		return produtoDao.produtosCompra();
	}
	
	public void selecionarProdutoDialogo(Produto produto) {
		this.produto.setProdutoMatriz(produto);
        RequestContext.getCurrentInstance().closeDialog(produto);
        //this.aoSelecionarProdutoCompra();
    }	
	

	public ProdutoDAO getProdutoDao() {
		return produtoDao;
	}

	public void setProdutoDao(ProdutoDAO produtoDao) {
		this.produtoDao = produtoDao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public void setProdutosFiltrados(List<Produto> produtosFiltrados) {
		this.produtosFiltrados = produtosFiltrados;
	}

	public boolean isExibeProduto() {
		return exibeProduto;
	}

	public void setExibeProduto(boolean exibeProduto) {
		this.exibeProduto = exibeProduto;
	}

}
