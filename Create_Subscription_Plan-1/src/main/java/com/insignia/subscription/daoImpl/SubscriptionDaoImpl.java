package com.insignia.subscription.daoImpl;

import org.springframework.stereotype.Repository;

import com.insignia.subscription.dao.SubscriptionDaoInterface;
import com.insignia.subscription.entity.SubscriptionDetails;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SubscriptionDaoImpl implements SubscriptionDaoInterface{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void createSubscriptionMethod(SubscriptionDetails subscriptionDetails) {
		entityManager.persist(subscriptionDetails);
	}

}
