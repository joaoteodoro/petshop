package br.com.petshop.dao;

import java.util.List;

import br.com.petshop.modelo.ProdutoVenda;
 
public interface ProdutoVendaDAO {
    public List<ProdutoVenda> listaProdutosVenda();
    public void altera(ProdutoVenda pv);
    public void inclui(ProdutoVenda pv);
    public ProdutoVenda buscaPorId(int idProduto);
    public void remove(ProdutoVenda pv);
}