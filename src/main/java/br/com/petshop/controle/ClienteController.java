package br.com.petshop.controle;

import java.util.List;

import br.com.petshop.modelo.Cliente;
 
public interface ClienteController {
    public List<Cliente> listaClientes();
    public String editaCliente(Cliente fornecedor);
    public String grava();
    public String novo();
     
}