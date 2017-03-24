package br.com.petshop.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshop.modelo.Telefone;

@Repository
@Service
@Transactional
public class TelefoneDAOImpl extends GenericDAO<Telefone, Long>{
	
	public TelefoneDAOImpl(){
		super(Telefone.class);
	}
	
	/*@PersistenceContext
	EntityManager entityManagerFactory;
	
	//private static final Logger logger = LoggerFactory.getLogger(FornecedorDAOImpl.class);
	 
	public void setEntityManagerFactory(EntityManager entityManagerFactory){
		this.entityManagerFactory = entityManagerFactory;
	}

	public List<Telefone> listaTelefones() {
		@SuppressWarnings("unchecked")
		List<Telefone> telefones =  entityManagerFactory.createQuery("from Telefone").getResultList();
        return telefones;
	}
	
	public Telefone altera(Telefone t){
		return (Telefone)entityManagerFactory.merge(t);
	}
	
	public void remove(Telefone t){
		entityManagerFactory.remove(entityManagerFactory.getReference(Telefone.class, t.getId()));
	}
	
	public Telefone inclui(Telefone t) {
		entityManagerFactory.persist(t);
		return t;
	}*/
}
