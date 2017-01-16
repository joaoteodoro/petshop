package br.com.petshop.controle;

import java.util.List;

import br.com.petshop.modelo.Fornecedor;
 
public interface FornecedorController {
 
    public void adicionarFornecedor(Fornecedor f);
    public List<Fornecedor> listarFornecedores();
    public String editaFornecedor(Fornecedor fornecedor);
    public String gravar();
     
}