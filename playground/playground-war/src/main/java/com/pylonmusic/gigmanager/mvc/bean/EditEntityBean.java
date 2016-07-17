package com.pylonmusic.gigmanager.mvc.bean;

import com.pylonmusic.gigmanager.domain.IdHolder;

/**
 * Helper interface for our edit bean pojos
 * @author johan
 *
 * @param <E> any bean extending {@link IdHolder}
 */
public interface EditEntityBean<E extends IdHolder> {
	
	/**
	 * Set the bean used
	 * @param bean our {@link IdHolder} bean
	 */
	void setBean(E bean);
	
	/**
	 * @return the {@link IdHolder} used
	 */
	E getBean();
}
