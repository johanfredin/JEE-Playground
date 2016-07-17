package se.fredin.playground.services;

import se.fredin.playground.domain.IdHolder;
import se.fredin.playground.repository.BaseRepository;

/**
 * Basic service to contain the basic CRUD functionality for our services.
 * Much like the {@link BaseRepository} interface. 
 * @author johan
 *
 * @param <E> Any JPA entity extending {@link IdHolder}
 */
public interface ServiceBase<E extends IdHolder, F extends BaseRepository<E>> {
	
	
	/**
	 * Set what {@link BaseRepository} implementation this service will use.
	 * @param repository any interface extending the {@link BaseRepository} interface.
	 */
	void setRepository(F repository);
	
	/**
	 * Get the {@link BaseRepository} implementation this service is using
	 */
	F getRepository();
	
	/**
	 * Find and return the {@link IdHolder} with the id
	 * @param id the identity of the {@link IdHolder}
	 * @return {@link IdHolder} with matching id or <code>null</code>
	 */
	E getEntity(long id);
	
	/**
	 * Create a new {@link IdHolder} entity
	 * @param entity the {@link IdHolder} we want to create
	 * @return the Entity created
	 * @throws Exception
	 */
	E createEntity(E entity);
	
	/**
	 * Update an entity
	 * @param entity the {@link IdHolder} to update
	 */
	void updateEntity(E entity);

	/**
	 * Delete {@link IdHolder} with the given id
	 * @param entity the {@link IdHolder} to delete
	 */
	void deleteEntity(E entity);
	
	
}
