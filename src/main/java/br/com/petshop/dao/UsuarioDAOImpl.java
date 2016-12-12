package br.com.petshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.petshop.modelo.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO{
	
	/*@PersistenceContext
	EntityManager entityManagerFactory;*/
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioDAOImpl.class);
	 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	
	/*public void setEntityManagerFactory(EntityManager entityManagerFactory){
		this.entityManagerFactory = entityManagerFactory;
	}*/
 
    public void addPerson(Usuario p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
		//entityManagerFactory.persist(p);
        logger.info("Person saved successfully, Person Details="+p);
    }
 
    @SuppressWarnings("unchecked")
    public List<Usuario> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Usuario> personsList =  session.createQuery("from Usuario").list();
    	//List<Usuario> personsList =  entityManagerFactory.createQuery("from Usuario").getResultList();
        for(Usuario p : personsList){
            logger.info("Person List::"+p);
        }
        return personsList;
    }
 
}
