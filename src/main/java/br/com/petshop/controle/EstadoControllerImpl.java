package br.com.petshop.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.petshop.dao.EstadoDAO;
import br.com.petshop.dao.EstadoDAOImpl;
import br.com.petshop.modelo.Estado;

//@Service
//@Component
@ManagedBean(name = "estadoController")
//@RequestScoped
//@Transactional
//@Controller
//@SessionScoped
public class EstadoControllerImpl implements EstadoController {

	@Autowired
	EstadoDAOImpl estadoDao;
	
	private Estado estado;
	
	private List<Estado> estados;
	
	public EstadoControllerImpl(){
		this.estado = new Estado();
	}
	
	public List<Estado> listaEstados() {
		return this.estadoDao.getList();
	}
	
	public String editaEstado(Estado estado){
		this.estado = estado;
		return "estado";
	}

	@Override
	public String grava() {
		if(this.estado.getId() != 0){
			estadoDao.atualizar(this.estado);
		}else{
			estadoDao.salvar(this.estado);
		}
		return "estados";
	}

	public EstadoDAOImpl getEstadoDao() {
		return estadoDao;
	}

	public void setEstadoDao(EstadoDAOImpl estadoDao) {
		this.estadoDao = estadoDao;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	
}
