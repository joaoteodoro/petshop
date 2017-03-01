package br.com.petshop.controle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.petshop.dao.AnimalDAO;
import br.com.petshop.dao.ClienteDAO;
import br.com.petshop.dao.EnderecoDAO;
import br.com.petshop.dao.EstadoDAO;
import br.com.petshop.dao.TelefoneDAO;
import br.com.petshop.modelo.Animal;
import br.com.petshop.modelo.Cliente;
import br.com.petshop.modelo.Endereco;
import br.com.petshop.modelo.Estado;
import br.com.petshop.modelo.Telefone;
import br.com.petshop.utils.StringUtils;

@ManagedBean(name = "clienteController")
@ViewScoped
public class ClienteControllerImpl implements ClienteController {

	@Autowired
	ClienteDAO clienteDao;
	
	@Autowired
	EstadoDAO estadoDao;
	
	@Autowired
	EnderecoDAO enderecoDao;
	
	@Autowired
	TelefoneDAO telefoneDao;
	
	@Autowired
	AnimalDAO animalDao;
	
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
		editaTelefones();
		
		return "cliente";
	}
	
	private void editaTelefones(){
		if(cliente.getTelefones() == null || cliente.getTelefones().isEmpty()){
			this.cliente.setTelefones(Arrays.asList(new Telefone(), new Telefone()));
		}else if(cliente.getTelefones() != null && cliente.getTelefones().size() == 1){
			this.cliente.getTelefones().add(new Telefone());
		}
	}
	
	public String removeCliente(Cliente c){
		clienteDao.remove(c);
		removerEndereco(c.getEndereco());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro excluído com sucesso!"));
		return "clientes";
	}
	
	public void removerEndereco(Endereco e){
		enderecoDao.remove(e);
	}

	@Override
	public String grava() {
		boolean ehNovoRegistro = true;
		validaEndereco();
		if(this.cliente.getIdPessoa() != 0){
			ehNovoRegistro = false;
			validaTelefones();
			validaAnimais();
		}
		cliente.setCpf(StringUtils.somenteNumeros(cliente.getCpf()));
		if(this.cliente.getIdPessoa() != 0){
			clienteDao.altera(this.cliente);
		}else{
			clienteDao.inclui(this.cliente);
		}
		if(ehNovoRegistro){
			validaTelefones();
			validaAnimais();
		}
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro gravado com sucesso!"));
		
		this.cliente = clienteDao.buscaPorId(this.cliente.getIdPessoa());
		
		return editaCliente(cliente);
	}
	
	public List<SelectItem> selectItensEstados(){
		List<SelectItem> itens = new ArrayList<>();
		for (Estado estado : estadoDao.listaEstados()) {
			itens.add(new SelectItem(estado.getId(), estado.getNome()));
		} 
		return itens;
	}

	private void validaEndereco(){
		cliente.getEndereco().setCep(StringUtils.somenteNumeros(cliente.getEndereco().getCep()));
		if(this.cliente.getEndereco().getId() != 0){
			enderecoDao.altera(cliente.getEndereco());
		}else{
			enderecoDao.inclui(cliente.getEndereco());
		}
	}
	
	private void validaAnimais(){
		for (Animal animal : cliente.getAnimais()) {
			animal.setDono(cliente);
			if(animal.getIdAnimal() != 0){
				animalDao.altera(animal);
			}else{
				animalDao.inclui(animal);
			}
		}
	}
	
	private void validaTelefones(){
		//excluir registro em branco
		Telefone segundoTelefone = cliente.getTelefones().get(1);
		if(segundoTelefone.getNumero() == null || "".equals(segundoTelefone.getNumero())){
			if(segundoTelefone.getId() != 0){
				segundoTelefone.setPessoa(null);
				telefoneDao.remove(segundoTelefone);
			}
			this.cliente.getTelefones().set(1, null);
		}
		
		//alterar ou incluir registros
		for (Telefone telefone : this.cliente.getTelefones()) {
			if(telefone!= null ){
				telefone.setNumero(StringUtils.somenteNumeros(telefone.getNumero()));
				telefone.setPessoa(cliente);
				if(telefone.getId() != 0){
					telefoneDao.altera(telefone);
				}else{
					telefoneDao.inclui(telefone);
				}
			}
		}
	}
	
	public void removeAnimal(Animal animal){
		cliente.getAnimais().remove(animal);
//		return editaCliente(cliente);
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

	public EstadoDAO getEstadoDao() {
		return estadoDao;
	}

	public void setEstadoDao(EstadoDAO estadoDao) {
		this.estadoDao = estadoDao;
	}

	public EnderecoDAO getEnderecoDao() {
		return enderecoDao;
	}

	public void setEnderecoDao(EnderecoDAO enderecoDao) {
		this.enderecoDao = enderecoDao;
	}

	public TelefoneDAO getTelefoneDao() {
		return telefoneDao;
	}

	public void setTelefoneDao(TelefoneDAO telefoneDao) {
		this.telefoneDao = telefoneDao;
	}

	public AnimalDAO getAnimalDao() {
		return animalDao;
	}

	public void setAnimalDao(AnimalDAO animalDao) {
		this.animalDao = animalDao;
	}
}
