package com.insignia.subscription.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insignia.subscription.entity.SubscriptionDetails;
import com.insignia.subscription.constants.SubscriptionConstants;
import com.insignia.subscription.model.SubscriptionRequest;
import com.insignia.subscription.model.SubscriptionResponse;
import com.insignia.subscription.repo.UserSubscriptionRepository;
import com.insignia.subscription.service.SubscriptionServiceInterface;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionSystemController {

	@Autowired
	private UserSubscriptionRepository userRepo;
	
    @Autowired
    private SubscriptionServiceInterface subscriptionServiceInterface;

    @PostMapping("/create")
    public SubscriptionResponse createSubscriptionPlan(@RequestBody SubscriptionRequest subscriptionRequest) {
    	
    	try {
            return subscriptionServiceInterface.createSubscriptionPlan(subscriptionRequest);
        } catch (DataIntegrityViolationException e) {
            // Handle DataIntegrityViolationException (e.g., duplicate key)
            SubscriptionResponse response = new SubscriptionResponse();
            response.setSuccess(false);
            response.setErrorCode(SubscriptionConstants.ERROR_CODE_DATA_INTEGRITY);
            response.setErrorMessage(SubscriptionConstants.ERROR_MESSAGE_DATA_INTEGRITY);
            return response;
        } /* catch (Exception e) {
            // Handle other unexpected exceptions
            SubscriptionResponse response = new SubscriptionResponse();
            response.setSuccess(false);
            response.setErrorCode("INTERNAL_SERVER_ERROR");
            response.setErrorMessage("An internal server error occurred.");
            return response;
        }*/
    } 

    @PostMapping("/modify")
    public SubscriptionResponse modifySubscriptionPlan(@RequestBody SubscriptionRequest subscriptionRequest) {
    	try {
    		return subscriptionServiceInterface.modifySubscriptionPlan(subscriptionRequest);
        } catch (DataIntegrityViolationException e) {
            // Handle DataIntegrityViolationException (e.g., duplicate key)
            SubscriptionResponse response = new SubscriptionResponse();
            response.setSuccess(false);
            response.setErrorCode(SubscriptionConstants.ERROR_CODE_DATA_INTEGRITY);
            response.setErrorMessage(SubscriptionConstants.ERROR_MESSAGE_DATA_INTEGRITY);
            return response;
        }      
    }
    
    @PostMapping("/delete")
    public SubscriptionResponse deleteSubscriptionPlan(@RequestBody SubscriptionRequest subscriptionRequest) {
    	
    	String planId = subscriptionRequest.getPlanId();
        SubscriptionDetails existingPlan = userRepo.findByPlanId(planId).orElse(null);

        if (existingPlan == null) {
            // Plan with the given planId already exists, handle the exception
            SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
            subscriptionResponse.setSuccess(false);
            subscriptionResponse.setErrorCode(SubscriptionConstants.ERROR_CODE_PLAN_NOT_FOUND);
            subscriptionResponse.setErrorMessage(SubscriptionConstants.ERROR_MESSAGE_PLAN_NOT_FOUND);
            return subscriptionResponse;
        }
        return subscriptionServiceInterface.deleteSubscriptionPlan(subscriptionRequest);
    }
}

    // Other methods for modifying, deleting, activating, and deactivating subscription plans

