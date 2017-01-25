package br.com.petshop.dao;

import java.util.List;

import br.com.petshop.modelo.Fornecedor;
import br.com.petshop.modelo.Telefone;
 
public interface TelefoneDAO {
    public List<Telefone> listaTelefones();
    public Telefone altera(Telefone t);
    public Telefone inclui(Telefone t);
    public void remove(Telefone t);
}