package br.com.petshop.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshop.modelo.Animal;

@Repository
@Service
@Transactional
public class AnimalDAOImpl extends GenericDAO<Animal, Long>{
	
	public AnimalDAOImpl(){
		super(Animal.class);
	}
	
	/*@PersistenceContext
	EntityManager entityManagerFactory;
	
	//private static final Logger logger = LoggerFactory.getLogger(FornecedorDAOImpl.class);
	 
	public void setEntityManagerFactory(EntityManager entityManagerFactory){
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public List<Animal> listaAnimais() {
		@SuppressWarnings("unchecked")
		List<Animal> animais =  entityManagerFactory.createQuery("from Animal").getResultList();
        return animais;
	}
	
	public void altera(Animal a){
		entityManagerFactory.merge(a);
	}
	
	public void inclui(Animal a) {
		entityManagerFactory.persist(a);
	}
	
	public Animal buscaPorId(int idAnimal){
		return entityManagerFactory.find(Animal.class, idAnimal);
	}
 
	public void remove(Animal a){
		entityManagerFactory.remove(entityManagerFactory.getReference(Animal.class, a.getIdAnimal()));
	}*/
}
