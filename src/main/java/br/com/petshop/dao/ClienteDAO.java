package br.com.petshop.dao;

import java.util.List;

import br.com.petshop.modelo.Cliente;
 
public interface ClienteDAO {
    public List<Cliente> listaClientes();
    public void altera(Cliente c);
    public void inclui(Cliente c);
    public Cliente buscaPorId(int idPessoa);
    public void remove(Cliente c);
}