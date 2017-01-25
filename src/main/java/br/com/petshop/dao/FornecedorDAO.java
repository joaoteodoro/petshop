package br.com.petshop.dao;

import java.util.List;

import br.com.petshop.modelo.Fornecedor;
 
public interface FornecedorDAO {
    public List<Fornecedor> listaFornecedores();
    public void altera(Fornecedor f);
    public void inclui(Fornecedor f);
}