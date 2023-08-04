package com.insignia.subscription.daoImpl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.insignia.customExceptions.InvalidInputParametersException;
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
	public SubscriptionResponse createSubscriptionPlan(SubscriptionRequest subscriptionRequest) throws InvalidInputParametersException {
		try {
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
			
		}	
		catch(DataIntegrityViolationException e) {
            throw new InvalidInputParametersException(SubscriptionConstants.ERROR_CODE_DATA_INTEGRITY, SubscriptionConstants.ERROR_MESSAGE_DATA_INTEGRITY);
        }
		
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
	public SubscriptionResponse modifySubscriptionPlan(SubscriptionRequest subscriptionRequest) throws InvalidInputParametersException {
		   		 		
		Optional<SubscriptionDetails> existingPlanOptional = userRepo.findByPlanId(subscriptionRequest.getPlanId());
		
		if(existingPlanOptional.isEmpty())
        	throw new InvalidInputParametersException(SubscriptionConstants.ERROR_CODE_PLAN_NOT_FOUND, SubscriptionConstants.ERROR_MESSAGE_PLAN_NOT_FOUND);	
		
		SubscriptionDetails existingPlan = existingPlanOptional.get();
        if (existingPlanOptional.isPresent()) {            
            if (subscriptionRequest.getPlanName() != null) {
                existingPlan.setPlanName(subscriptionRequest.getPlanName());
            }
            if (subscriptionRequest.getPlanDescription() != null) {
                existingPlan.setPlanDescription(subscriptionRequest.getPlanDescription());
            }
            if (subscriptionRequest.getPlanDuration() != null) {
                existingPlan.setPlanDuration(subscriptionRequest.getPlanDuration());
            }
            if (subscriptionRequest.getPlanPricing() != null) {
                existingPlan.setPlanPricing(subscriptionRequest.getPlanPricing());
            }
            if (subscriptionRequest.getPlanActivationStatus() != null) {
                existingPlan.setPlanActivationStatus(subscriptionRequest.getPlanActivationStatus());
            }
            
            if (subscriptionRequest.getPlanActivationDate() == null) {
                existingPlan.setPlanActivationDate(null);
            }
            else if(subscriptionRequest.getPlanActivationDate() != null){
            	existingPlan.setPlanActivationDate(subscriptionRequest.getPlanActivationDate());
            }
            
            if(subscriptionRequest.getPlanDeactivationDate() == null) {
            	existingPlan.setPlanDeactivationDate(null);
            }
            else if (subscriptionRequest.getPlanDeactivationDate() != null) {
                existingPlan.setPlanDeactivationDate(subscriptionRequest.getPlanDeactivationDate());
            }
                     
        }		
       userRepo.modifySubscriptionPlan(		 
    		existingPlan.getPlanId(), 
    		existingPlan.getPlanName(), 
    		existingPlan.getPlanDescription(), 
    		existingPlan.getPlanDuration(),
   			existingPlan.getPlanPricing(),
   			existingPlan.getPlanActivationStatus(),
   			existingPlan.getPlanActivationDate(),
   			existingPlan.getPlanDeactivationDate()
		);
            	        
		 SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
       
   		 subscriptionResponse.setSuccess(true);
   		 subscriptionResponse.setPlanId(existingPlan.getPlanId());
   		 subscriptionResponse.setPlanName(existingPlan.getPlanName());
   		 subscriptionResponse.setPlanDescription(existingPlan.getPlanDescription());
   		 subscriptionResponse.setPlanDuration(existingPlan.getPlanDuration());
   		 subscriptionResponse.setPlanPricing(existingPlan.getPlanPricing());
   		 subscriptionResponse.setPlanActivationStatus(existingPlan.getPlanActivationStatus());
   		 subscriptionResponse.setPlanActivationDate(existingPlan.getPlanActivationDate());
   		 subscriptionResponse.setPlanDeactivationDate(existingPlan.getPlanDeactivationDate());
	
		return subscriptionResponse;
	}
	
	@Override
	public SubscriptionResponse deleteSubscriptionPlan(SubscriptionRequest subscriptionRequest) throws InvalidInputParametersException {
		
		
		int a  = userRepo.deleteSubscriptionPlan(subscriptionRequest.getPlanId());		
		if(a==0)
			 throw new InvalidInputParametersException(SubscriptionConstants.ERROR_CODE_PLAN_NOT_FOUND, SubscriptionConstants.ERROR_MESSAGE_PLAN_NOT_FOUND);	
		
		 SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
		 subscriptionResponse.setSuccess(true);
		 subscriptionResponse.setPlanId(subscriptionRequest.getPlanId());
		 subscriptionResponse.setDeleteStatus(true);
		 
		return subscriptionResponse;
	}
	
	@Override
	public SubscriptionResponse activateSubscriptionPlan(SubscriptionRequest subscriptionRequest) throws InvalidInputParametersException {
		
		Optional<SubscriptionDetails> existingPlanOptional = userRepo.findByPlanId(subscriptionRequest.getPlanId());	
		if(existingPlanOptional.isEmpty())
			throw new InvalidInputParametersException(SubscriptionConstants.ERROR_CODE_PLAN_NOT_FOUND, SubscriptionConstants.ERROR_MESSAGE_PLAN_NOT_FOUND);				
		 
		 SubscriptionDetails existingPlan = existingPlanOptional.get();
		 
		 userRepo.activateSubscriptionPlan(existingPlan.getPlanId()); 
		 existingPlan.setPlanActivationStatus("active");
		 LocalDateTime now = LocalDateTime.now( );  
				        	        		 
		 SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
		 subscriptionResponse.setSuccess(true);
		 subscriptionResponse.setPlanId(existingPlan.getPlanId());
		 subscriptionResponse.setPlanName(existingPlan.getPlanName());
		 subscriptionResponse.setPlanDescription(existingPlan.getPlanDescription());
		 subscriptionResponse.setPlanActivationStatus(existingPlan.getPlanActivationStatus());
		 subscriptionResponse.setPlanActivationDate(now);
		 
		return subscriptionResponse;
	}
	
	@Override
	public SubscriptionResponse deactivateSubscriptionPlan(SubscriptionRequest subscriptionRequest) throws InvalidInputParametersException {
		
		Optional<SubscriptionDetails> existingPlanOptional = userRepo.findByPlanId(subscriptionRequest.getPlanId());	
		if(existingPlanOptional.isEmpty())
			throw new InvalidInputParametersException(SubscriptionConstants.ERROR_CODE_PLAN_NOT_FOUND, SubscriptionConstants.ERROR_MESSAGE_PLAN_NOT_FOUND);				
		 
		SubscriptionDetails existingPlan = existingPlanOptional.get();
		
		userRepo.deactivateSubscriptionPlan(subscriptionRequest.getPlanId()); 
		existingPlan.setPlanActivationStatus("inactive");
		LocalDateTime now = LocalDateTime.now( );  

		SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
		 subscriptionResponse.setSuccess(true);
		 subscriptionResponse.setPlanId(existingPlan.getPlanId());
		 subscriptionResponse.setPlanName(existingPlan.getPlanName());
		 subscriptionResponse.setPlanDescription(existingPlan.getPlanDescription());
		 subscriptionResponse.setPlanActivationStatus(existingPlan.getPlanActivationStatus());
		 subscriptionResponse.setPlanDeactivationDate(now);
		 
		return subscriptionResponse;
	}
	
	@Override
	public SubscriptionResponse findDetailsByPlanId(SubscriptionRequest subscriptionRequest) throws InvalidInputParametersException{
		
		Optional<SubscriptionDetails> planDetails = userRepo.findByPlanId(subscriptionRequest.getPlanId());	
		if(planDetails.isEmpty())
			throw new InvalidInputParametersException(SubscriptionConstants.ERROR_CODE_PLAN_NOT_FOUND, SubscriptionConstants.ERROR_MESSAGE_PLAN_NOT_FOUND);				
	
		SubscriptionDetails existingPlan = planDetails.get();
		SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
		 
		 subscriptionResponse.setSuccess(true);		 
		 subscriptionResponse.setPlanId(existingPlan.getPlanId());
		 subscriptionResponse.setPlanName(existingPlan.getPlanName());
		 subscriptionResponse.setPlanDescription(existingPlan.getPlanDescription());
		 subscriptionResponse.setPlanDuration(existingPlan.getPlanDuration());
		 subscriptionResponse.setPlanPricing(existingPlan.getPlanPricing());
		 subscriptionResponse.setPlanActivationStatus(existingPlan.getPlanActivationStatus());
		 subscriptionResponse.setPlanActivationDate(existingPlan.getPlanActivationDate());
		 subscriptionResponse.setPlanDeactivationDate(existingPlan.getPlanDeactivationDate());	
		    			 
		return subscriptionResponse;
	}
	
}
