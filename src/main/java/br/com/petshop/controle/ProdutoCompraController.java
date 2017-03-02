package br.com.petshop.controle;

import java.util.List;

import br.com.petshop.modelo.ProdutoCompra;
 
public interface ProdutoCompraController {
    public List<ProdutoCompra> listaProdutosCompra();
    public String editaProdutoCompra(ProdutoCompra pc);
    public String grava();
    public String novo();
    public String removeProdutoCompra(ProdutoCompra pc);
     
}