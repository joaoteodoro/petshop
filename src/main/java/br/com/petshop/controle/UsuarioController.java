package br.com.petshop.controle;

import java.util.List;

import br.com.petshop.modelo.Usuario;
 
public interface UsuarioController {
 
    public void addPerson(Usuario u);
    public List<Usuario> listPersons();
    public void teste();
     
}