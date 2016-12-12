package br.com.petshop.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import br.com.petshop.dao.UsuarioDAO;
import br.com.petshop.modelo.Usuario;

@Service
@ManagedBean(name="usuarioController")
@SessionScoped
@Transactional
@Controller
public class UsuarioControllerImpl implements UsuarioController{

	@Autowired
	private UsuarioDAO usuarioDao;
	
	public void setUsuarioDao(UsuarioDAO usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
 
   
	@Transactional
    public void addPerson(Usuario p) {
        this.usuarioDao.addPerson(p);
    }
 
	@Transactional
    public List<Usuario> listPersons() {
        return this.usuarioDao.listPersons();
    }


	@Override
	public void teste() {
		System.out.println("teste");
		
	}
}
