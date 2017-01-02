package br.com.petshop.dao;

import java.util.List;

import br.com.petshop.modelo.Fornecedor;
 
public interface FornecedorDAO {
 
	public void adicionarFornecedor(Fornecedor f);
    public List<Fornecedor> listarFornecedores();
}