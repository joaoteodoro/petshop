package br.com.petshop.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshop.dao.UsuarioDAO;
import br.com.petshop.modelo.Usuario;

//@Service
//@Component
@ManagedBean(name="usuarioController")
@RequestScoped
@Transactional
@Controller
public class UsuarioControllerImpl implements UsuarioController{

	@Autowired
	UsuarioDAO usuarioDao;
	
	public void setUsuarioDao(UsuarioDAO usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
 
   
    public void addPerson(Usuario p) {
        this.usuarioDao.addPerson(p);
    }
 
    public List<Usuario> listPersons() {
        return this.usuarioDao.listPersons();
    }


	@Override
	public void teste() {
		System.out.println("teste");
		
	}
}
