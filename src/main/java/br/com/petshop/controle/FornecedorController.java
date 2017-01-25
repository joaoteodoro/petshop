package br.com.petshop.controle;

import java.util.List;

import javax.faces.model.SelectItem;

import br.com.petshop.modelo.Fornecedor;
 
public interface FornecedorController {
    public List<Fornecedor> listaFornecedores();
    public String editaFornecedor(Fornecedor fornecedor);
    public String grava();
    public List<SelectItem> selectItensEstados();
    public String novo();
     
}