package br.com.petshop.controle;

import java.util.List;

import br.com.petshop.modelo.Cliente;
 
public interface ClienteController {
    public List<Cliente> listaClientes();
    public String editaCliente(Cliente c);
    public String grava();
    public String novo();
    public String removeCliente(Cliente c);
     
}