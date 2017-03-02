package br.com.petshop.controle;

import java.util.List;

import br.com.petshop.modelo.ProdutoVenda;
 
public interface ProdutoVendaController {
    public List<ProdutoVenda> listaProdutosVenda();
    public String editaProdutoVenda(ProdutoVenda pv);
    public String grava();
    public String novo();
    public String removeProdutoVenda(ProdutoVenda pv);
     
}