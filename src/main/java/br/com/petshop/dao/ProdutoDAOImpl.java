package br.com.petshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshop.modelo.Produto;

@Repository
@Service
@Transactional
public class ProdutoDAOImpl implements ProdutoDAO{
	
	@PersistenceContext
	EntityManager entityManagerFactory;
	
	//private static final Logger logger = LoggerFactory.getLogger(FornecedorDAOImpl.class);
	 
	public void setEntityManagerFactory(EntityManager entityManagerFactory){
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public List<Produto> listaProdutos() {
		@SuppressWarnings("unchecked")
		List<Produto> produtos =  entityManagerFactory.createQuery("from Produto").getResultList();
        return produtos;
	}
	
	public void altera(Produto p){
		entityManagerFactory.merge(p);
	}
	
	public void inclui(Produto p) {
		entityManagerFactory.persist(p);
	}
	
	public Produto buscaPorId(int idProduto){
		return entityManagerFactory.find(Produto.class, idProduto);
	}
 
	public void remove(Produto p){
		entityManagerFactory.remove(entityManagerFactory.getReference(Produto.class, p.getIdProduto()));
	}
	
	public List<Produto> produtosCompra(){
		Query query = entityManagerFactory.createQuery("select p from Produto p where p.tipoProduto = 'compra'");
		
		return query.getResultList();
	}
}
