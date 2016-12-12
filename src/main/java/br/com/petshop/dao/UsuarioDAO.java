package br.com.petshop.dao;

import java.util.List;

import br.com.petshop.modelo.Usuario;
 
public interface UsuarioDAO {
 
    public void addPerson(Usuario u);
    public List<Usuario> listPersons();
}