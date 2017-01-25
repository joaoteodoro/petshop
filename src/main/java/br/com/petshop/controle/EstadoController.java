package br.com.petshop.controle;

import java.util.List;

import br.com.petshop.modelo.Estado;
 
public interface EstadoController {
    public List<Estado> listaEstados();
    public String editaEstado(Estado estado);
    public String grava();
     
}