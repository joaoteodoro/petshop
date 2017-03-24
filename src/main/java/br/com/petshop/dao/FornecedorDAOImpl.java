package br.com.petshop.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshop.modelo.Fornecedor;

@Repository
@Service
@Transactional
public class FornecedorDAOImpl extends GenericDAO<Fornecedor, Long> implements FornecedorDAO{
	
	//private static final Logger logger = LoggerFactory.getLogger(FornecedorDAOImpl.class);
	 
	public FornecedorDAOImpl(){
		super(Fornecedor.class);
	}

	/*@Override
	public List<Fornecedor> listaFornecedores() {
		@SuppressWarnings("unchecked")
		List<Fornecedor> fornecedores =  entityManagerFactory.createQuery("from Fornecedor").getResultList();
        return fornecedores;
	}
	
	public void altera(Fornecedor f){
		entityManagerFactory.merge(f);
	}
	
	public void inclui(Fornecedor f) {
		entityManagerFactory.persist(f);
	}
	
	public Fornecedor buscaPorId(int idPessoa){
		return entityManagerFactory.find(Fornecedor.class, idPessoa);
	}
 
	public void remove(Fornecedor f){
		entityManagerFactory.remove(entityManagerFactory.getReference(Fornecedor.class, f.getIdPessoa()));
	}*/
}
