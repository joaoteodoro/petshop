package br.com.petshop.dao;

import java.util.List;

import br.com.petshop.modelo.Produto;
 
public interface ProdutoDAO {
    public List<Produto> listaProdutos();
    public void altera(Produto p);
    public void inclui(Produto p);
    public Produto buscaPorId(int idProduto);
    public void remove(Produto pc);
    public List<Produto> produtosCompra();
}