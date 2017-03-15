package br.com.petshop.dao;

import java.util.List;

import br.com.petshop.modelo.ProdutoCompra;
 
public interface ProdutoCompraDAO {
    public List<ProdutoCompra> listaProdutosCompra();
    public void altera(ProdutoCompra pc);
    public void inclui(ProdutoCompra pc);
    public ProdutoCompra buscaPorId(Long idProduto);
    public void remove(ProdutoCompra pc);
}