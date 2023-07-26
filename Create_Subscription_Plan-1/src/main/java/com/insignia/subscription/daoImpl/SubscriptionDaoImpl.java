package com.insignia.subscription.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insignia.subscription.dao.SubscriptionDaoInterface;
import com.insignia.subscription.model.SubscriptionRequest;
import com.insignia.subscription.model.SubscriptionResponse;
import com.insignia.subscription.repo.UserSubscriptionRepository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SubscriptionDaoImpl implements SubscriptionDaoInterface{
	
	@Autowired
	private UserSubscriptionRepository userRepo;
	
	@Override
	public SubscriptionResponse createSubscriptionPlan(SubscriptionRequest subscriptionRequest) {
		
		userRepo.createSubscriptionPlan(		 
		 subscriptionRequest.getPlanId(), 
		 subscriptionRequest.getPlanName(), 
		 subscriptionRequest.getPlanDescription(), 
		 subscriptionRequest.getPlanDuration(),
		 subscriptionRequest.getPlanPricing(),
		 subscriptionRequest.getPlanActivationStatus(),
		 subscriptionRequest.getPlanActivationDate(),
		 subscriptionRequest.getPlanDeactivationDate()
		 );
		 
		 SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
		 subscriptionResponse.setSuccess(true);
		 subscriptionResponse.setPlanId(subscriptionRequest.getPlanId());
		 subscriptionResponse.setPlanName(subscriptionRequest.getPlanName());
		 subscriptionResponse.setPlanDescription(subscriptionRequest.getPlanDescription());
		 subscriptionResponse.setPlanDuration(subscriptionRequest.getPlanDuration());
		 subscriptionResponse.setPlanPricing(subscriptionRequest.getPlanPricing());
		 subscriptionResponse.setPlanActivationStatus(subscriptionRequest.getPlanActivationStatus());
		 subscriptionResponse.setPlanActivationDate(subscriptionRequest.getPlanActivationDate());
		 subscriptionResponse.setPlanDeactivationDate(subscriptionRequest.getPlanDeactivationDate());
		 
		return subscriptionResponse;
	}
	
	@Override
	public SubscriptionResponse modifySubscriptionPlan(SubscriptionRequest subscriptionRequest) {
		
		userRepo.modifySubscriptionPlan(		 
		 subscriptionRequest.getPlanId(), 
		 subscriptionRequest.getPlanName(), 
		 subscriptionRequest.getPlanDescription(), 
		 subscriptionRequest.getPlanDuration(),
		 subscriptionRequest.getPlanPricing(),
		 subscriptionRequest.getPlanActivationStatus(),
		 subscriptionRequest.getPlanActivationDate(),
		 subscriptionRequest.getPlanDeactivationDate()
		 );
		 
		 SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
		 subscriptionResponse.setSuccess(true);
		 subscriptionResponse.setPlanId(subscriptionRequest.getPlanId());
		 subscriptionResponse.setPlanName(subscriptionRequest.getPlanName());
		 subscriptionResponse.setPlanDescription(subscriptionRequest.getPlanDescription());
		 subscriptionResponse.setPlanDuration(subscriptionRequest.getPlanDuration());
		 subscriptionResponse.setPlanPricing(subscriptionRequest.getPlanPricing());
		 subscriptionResponse.setPlanActivationStatus(subscriptionRequest.getPlanActivationStatus());
		 subscriptionResponse.setPlanActivationDate(subscriptionRequest.getPlanActivationDate());
		 subscriptionResponse.setPlanDeactivationDate(subscriptionRequest.getPlanDeactivationDate());
		 
		return subscriptionResponse;
	}

	@Override
	public SubscriptionResponse deleteSubscriptionPlan(SubscriptionRequest subscriptionRequest) {
		
		 userRepo.deleteSubscriptionPlan(		 
		 subscriptionRequest.getPlanId());
		 
		 SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
		 subscriptionResponse.setSuccess(true);
		 subscriptionResponse.setPlanId(subscriptionRequest.getPlanId());
		 subscriptionResponse.setDeleteStatus(true);
		 
		return subscriptionResponse;
	}

}
