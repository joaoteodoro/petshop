package br.com.petshop.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshop.modelo.Cliente;

@Repository
@Service
@Transactional
public class ClienteDAOImpl extends GenericDAO<Cliente, Long>{
	
	public ClienteDAOImpl(){
		super(Cliente.class);
	}
	
	/*@PersistenceContext
	EntityManager entityManagerFactory;
	
	//private static final Logger logger = LoggerFactory.getLogger(FornecedorDAOImpl.class);
	 
	public void setEntityManagerFactory(EntityManager entityManagerFactory){
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public List<Cliente> listaClientes() {
		@SuppressWarnings("unchecked")
		List<Cliente> clientes =  entityManagerFactory.createQuery("from Cliente").getResultList();
        return clientes;
	}
	
	public void altera(Cliente c){
		entityManagerFactory.merge(c);
	}
	
	public void inclui(Cliente c) {
		entityManagerFactory.persist(c);
	}
	
	public Cliente buscaPorId(int idPessoa){
		return entityManagerFactory.find(Cliente.class, idPessoa);
	}
 
	public void remove(Cliente c){
		entityManagerFactory.remove(entityManagerFactory.getReference(Cliente.class, c.getIdPessoa()));
	}*/
}
