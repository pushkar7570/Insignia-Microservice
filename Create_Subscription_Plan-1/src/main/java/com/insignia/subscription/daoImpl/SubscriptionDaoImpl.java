package com.insignia.subscription.daoImpl;

import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insignia.subscription.constants.SubscriptionConstants;
import com.insignia.subscription.dao.SubscriptionDaoInterface;
import com.insignia.subscription.entity.SubscriptionDetails;
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
	public SubscriptionResponse createSubscriptionPlan(SubscriptionRequest subscriptionRequest) throws SQLException {
		
		Optional<SubscriptionDetails> planId = userRepo.findByPlanId(subscriptionRequest.getPlanId());
		if(planId.isPresent()){
            throw new SQLException(SubscriptionConstants.ERROR_MESSAGE_DATA_INTEGRITY);
        }
			
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
	public SubscriptionResponse modifySubscriptionPlan(SubscriptionRequest subscriptionRequest) throws SQLException {
		
		Optional<SubscriptionDetails> planId = userRepo.findByPlanId(subscriptionRequest.getPlanId());
		if(planId.isEmpty()){
            throw new SQLException(SubscriptionConstants.ERROR_MESSAGE_PLAN_NOT_FOUND);
		}
		
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
	public SubscriptionResponse deleteSubscriptionPlan(SubscriptionRequest subscriptionRequest) throws SQLException {
		
		Optional<SubscriptionDetails> planId = userRepo.findByPlanId(subscriptionRequest.getPlanId());
		if(planId.isEmpty()){
            throw new SQLException(SubscriptionConstants.ERROR_MESSAGE_PLAN_NOT_FOUND);
        }
		
		 userRepo.deleteSubscriptionPlan(subscriptionRequest.getPlanId());
		 
		 SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
		 subscriptionResponse.setSuccess(true);
		 subscriptionResponse.setPlanId(subscriptionRequest.getPlanId());
		 subscriptionResponse.setDeleteStatus(true);
		 
		return subscriptionResponse;
	}
	
	@Override
	public SubscriptionResponse activateSubscriptionPlan(SubscriptionRequest subscriptionRequest) throws SQLException {
		
		Optional<SubscriptionDetails> planId = userRepo.findByPlanId(subscriptionRequest.getPlanId());
		if(planId.isEmpty()){
            throw new SQLException(SubscriptionConstants.ERROR_MESSAGE_PLAN_NOT_FOUND);
        }
		
		 userRepo.activateSubscriptionPlan(subscriptionRequest.getPlanId());
		 
		 SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
		 subscriptionResponse.setSuccess(true);
		 subscriptionResponse.setPlanId(subscriptionRequest.getPlanId());
		 subscriptionResponse.setPlanName(subscriptionRequest.getPlanName());
		 subscriptionResponse.setPlanDescription(subscriptionRequest.getPlanDescription());
		 subscriptionResponse.setPlanActivationStatus(subscriptionRequest.getPlanActivationStatus());
		 subscriptionResponse.setPlanActivationDate(subscriptionRequest.getPlanActivationDate());
		 
		return subscriptionResponse;
	}
	
	@Override
	public SubscriptionResponse deactivateSubscriptionPlan(SubscriptionRequest subscriptionRequest) throws SQLException {
		
		Optional<SubscriptionDetails> planId = userRepo.findByPlanId(subscriptionRequest.getPlanId());
		if(planId.isEmpty()){
            throw new SQLException(SubscriptionConstants.ERROR_MESSAGE_PLAN_NOT_FOUND);
        }
		
		 userRepo.deactivateSubscriptionPlan(subscriptionRequest.getPlanId());
		 
		 SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
		 subscriptionResponse.setSuccess(true);
		 subscriptionResponse.setPlanId(subscriptionRequest.getPlanId());
		 subscriptionResponse.setPlanName(subscriptionRequest.getPlanName());
		 subscriptionResponse.setPlanDescription(subscriptionRequest.getPlanDescription());
		 subscriptionResponse.setPlanActivationStatus(subscriptionRequest.getPlanActivationStatus());
		 subscriptionResponse.setPlanDeactivationDate(subscriptionRequest.getPlanDeactivationDate());
		 
		return subscriptionResponse;
	}
	

}
