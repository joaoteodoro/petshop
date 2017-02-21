package br.com.petshop.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.petshop.dao.ClienteDAO;
import br.com.petshop.dao.EstadoDAO;
import br.com.petshop.modelo.Animal;
import br.com.petshop.modelo.Cliente;
import br.com.petshop.modelo.Estado;

@ManagedBean(name = "clienteController")
@ViewScoped
public class ClienteControllerImpl implements ClienteController {

	@Autowired
	ClienteDAO clienteDao;
	
	@Autowired
	EstadoDAO estadoDao;
	
	private Cliente cliente;
	
	private List<Cliente> clientesFiltrados;
	
	public ClienteControllerImpl(){
		this.cliente = new Cliente();
	}

	public List<Cliente> listaClientes() {
		return this.clienteDao.listaClientes();
	}
	
	public void novoAnimal(){
		this.cliente.getAnimais().add(new Animal());
	}
	
	public String novo() {
		this.cliente = new Cliente();
		return "cliente";
	}
	
	public String editaCliente(Cliente cliente){
		this.cliente = cliente;
		
		return "cliente";
	}
	
	public String removeFornecedor(Cliente c){
		clienteDao.remove(c);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro excluído com sucesso!"));
		return "clientes";
	}

	@Override
	public String grava() {
		return editaCliente(cliente);
	}
	
	public List<SelectItem> selectItensEstados(){
		List<SelectItem> itens = new ArrayList<>();
		for (Estado estado : estadoDao.listaEstados()) {
			itens.add(new SelectItem(estado.getId(), estado.getNome()));
		} 
		return itens;
	}

	public ClienteDAO getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDAO clienteDao) {
		this.clienteDao = clienteDao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientesFiltrados() {
		return clientesFiltrados;
	}

	public void setClientesFiltrados(List<Cliente> clientesFiltrados) {
		this.clientesFiltrados = clientesFiltrados;
	}
}
