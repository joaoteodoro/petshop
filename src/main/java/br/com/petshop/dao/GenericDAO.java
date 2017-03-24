package br.com.petshop.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.Valid;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Service
@Transactional
public abstract class GenericDAO<T, I extends Serializable> {

	@PersistenceContext
	EntityManager entityManagerFactory;

	private Class<T> persistedClass;

	public void setEntityManagerFactory(EntityManager entityManagerFactory){
		this.entityManagerFactory = entityManagerFactory;
	}

	protected GenericDAO() {
	}

	protected GenericDAO(Class<T> persistedClass) {
		this();
		this.persistedClass = persistedClass;
	}

	public T salvar(@Valid T entity) {
//		EntityTransaction t = entityManagerFactory.getTransaction();
//		t.begin();
		entityManagerFactory.persist(entity);
//		entityManagerFactory.flush();
//		t.commit();
		return entity;
	}

	public T atualizar(@Valid T entity) {
//		EntityTransaction t = entityManagerFactory.getTransaction();
//		t.begin();
		entityManagerFactory.merge(entity);
//		entityManagerFactory.flush();
//		t.commit();
		return entity;
	}

	public void remover(I id) {
		T entity = encontrar(id);
//		EntityTransaction tx = entityManagerFactory.getTransaction();
//		tx.begin();
		T mergedEntity = entityManagerFactory.merge(entity);
		entityManagerFactory.remove(mergedEntity);
//		entityManagerFactory.flush();
//		tx.commit();
	}

	public List<T> getList() {
		CriteriaBuilder builder = entityManagerFactory.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(persistedClass);
		query.from(persistedClass);
		return entityManagerFactory.createQuery(query).getResultList();
	}

	public T encontrar(I id) {
		return entityManagerFactory.find(persistedClass, id);
	}
}