package br.com.petshop.dao;

import java.util.List;

import br.com.petshop.modelo.Estado;
 
public interface EstadoDAO {
    public List<Estado> listaEstados();
    public void altera(Estado e);
    public void inclui(Estado e);
}