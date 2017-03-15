package br.com.petshop.controle;

import java.util.List;

import org.primefaces.event.SelectEvent;

import br.com.petshop.modelo.Produto;
 
public interface ProdutoController {
    public List<Produto> listaProdutos();
    public String editaProduto(Produto p);
    public String grava();
    public String novo();
    public String removeProduto(Produto p);
    public void escolheProdutoCompra();
    public void aoSelecionarProdutoCompra();
    public void exibirProdutoCompra();
    public List<Produto> produtosCompras();
    public void selecionarProdutoDialogo(Produto produto);
}