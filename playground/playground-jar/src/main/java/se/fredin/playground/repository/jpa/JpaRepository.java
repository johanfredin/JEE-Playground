package se.fredin.playground.repository.jpa;



import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import se.fredin.playground.domain.IdHolder;
import se.fredin.playground.repository.BaseRepository;

/**
 * Generic JPA repository that takes care of basic CRUD (Create, Update, Delete)
 * operations. This is a way of reusing common repository functionality.
 * 
 * @param <E>
 *            The entity type that this repository operates on.
 */
public abstract class JpaRepository<E extends IdHolder> implements BaseRepository<E> {

	/**
	 * The JPA type this repository can handle. Only known at runtime. This
	 * value is set in the constructor.
	 */
	protected Class<E> entityClass;

	@PersistenceContext
	protected EntityManager em;

	@SuppressWarnings("unchecked")
	public JpaRepository() {
		/*
		 * A little magic to look into the superclass to find the type we are
		 * working on. We use that type in findById() for example .
		 */
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
	}

	@Override
	public long persist(E entity) {
		em.persist(entity);
		return entity.getId();
	}

	@Override
	public void remove(E entity) {
		em.remove(entity);
	}

	@Override
	public E findById(long id) {
		return em.find(entityClass, id);
	}

	@Override
	public void update(E entity) {
		em.merge(entity);
	}

}
