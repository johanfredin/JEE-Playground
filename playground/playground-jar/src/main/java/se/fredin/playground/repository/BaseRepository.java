package se.fredin.playground.repository;

import se.fredin.playground.domain.IdHolder;

/**
 * The most basic methods of a repository. By having them in a separate
 * interface we can force other repository interfaces to implement these
 * methods.
 */
public interface BaseRepository<E extends IdHolder> {
	
	final int MAX_RESULTS = 5;
	
	/**
	 * Create a new {@link IdHolder} and store in database
	 * @param entity the {@link IdHolder} to create
	 * @return the identity of {@link IdHolder}
	 */
	long persist(E entity);

	/**
	 * Remove {@link IdHolder}
	 * @param entity the {@link IdHolder} to remove from database
	 */
	void remove(E entity);
	
	/**
	 * Find {@link IdHolder} in database
	 * @param id the id of the {@link IdHolder}
	 * @return matching {@link IdHolder} from database or null
	 */
	E findById(long id);
	
	/**
	 * Update {@link IdHolder}
	 * @param entity the {@link IdHolder} to update in database
	 */
	void update(E entity);
	

}
