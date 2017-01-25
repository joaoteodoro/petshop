package br.com.petshop.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.petshop.dao.EstadoDAO;
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
	EstadoDAO estadoDao;
	
	private Estado estado;
	
	private List<Estado> estados;
	
	public EstadoControllerImpl(){
		this.estado = new Estado();
	}
	
	public List<Estado> listaEstados() {
		return this.estadoDao.listaEstados();
	}
	
	public String editaEstado(Estado estado){
		this.estado = estado;
		return "estado";
	}

	@Override
	public String grava() {
		if(this.estado.getId() != 0){
			estadoDao.altera(this.estado);
		}else{
			estadoDao.inclui(this.estado);
		}
		return "estados";
	}

	public EstadoDAO getEstadoDao() {
		return estadoDao;
	}

	public void setEstadoDao(EstadoDAO estadoDao) {
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
