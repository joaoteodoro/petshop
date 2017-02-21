package br.com.petshop.dao;

import java.util.List;

import br.com.petshop.modelo.Endereco;
 
public interface EnderecoDAO {
    public List<Endereco> listaEnderecos();
    public void altera(Endereco e);
    public void inclui(Endereco e);
    public void remove(Endereco e);
}