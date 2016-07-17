package com.pylonmusic.gigmanager.services.impl;

import com.pylonmusic.gigmanager.domain.IdHolder;
import com.pylonmusic.gigmanager.repository.BaseRepository;
import com.pylonmusic.gigmanager.services.ServiceBase;

public abstract class AbstractServiceImpl<E extends IdHolder, F extends BaseRepository<E>> implements ServiceBase<E,F> {
	
	@Override
	public E getEntity(long id) {
		return getRepository().findById(id);
	}

	@Override
	public E createEntity(E entity) {
		long id = getRepository().persist(entity);
		return getRepository().findById(id);
	}

	@Override
	public void updateEntity(E entity) {
		getRepository().update(entity);
	}

	@Override
	public void deleteEntity(E entity) {
		getRepository().remove(entity);
	}
	

}
