package com.pylonmusic.gigmanager.repository.jpa;

import java.util.List;

import com.pylonmusic.gigmanager.domain.entitiy.Gig;
import com.pylonmusic.gigmanager.repository.GigRepository;

public class JpaGigRepository extends JpaRepository<Gig> implements GigRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<Gig> getAllGigs() {
		return em.createQuery("select g from Gig g").getResultList();
	}

}
