package com.insignia.subscription.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insignia.subscription.constants.SubscriptionConstants;
import com.insignia.subscription.model.SubscriptionRequest;
import com.insignia.subscription.model.SubscriptionResponse;
import com.insignia.subscription.service.SubscriptionServiceInterface;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionSystemController {

//	@Autowired
//	private UserSubscriptionRepository userRepo;
	
    @Autowired
    private SubscriptionServiceInterface subscriptionServiceInterface;

    @PostMapping("/create")
    public SubscriptionResponse createSubscriptionPlan(@RequestBody SubscriptionRequest subscriptionRequest) {
    	
    	try {
            return subscriptionServiceInterface.createSubscriptionPlan(subscriptionRequest);
        } catch (SQLException e) {
            // Handle DataIntegrityViolationException (e.g., duplicate key)
            SubscriptionResponse response = new SubscriptionResponse();
            response.setSuccess(false);
            response.setErrorCode(SubscriptionConstants.ERROR_CODE_DATA_INTEGRITY);
            response.setErrorMessage(e.getMessage());
            return response;
        } 
    } 
    
    @PostMapping("/modify")
    public SubscriptionResponse modifySubscriptionPlan(@RequestBody SubscriptionRequest subscriptionRequest) {
    	try {
    		return subscriptionServiceInterface.modifySubscriptionPlan(subscriptionRequest);
        } catch (SQLException e) {
            SubscriptionResponse response = new SubscriptionResponse();
            response.setSuccess(false);
            response.setErrorCode(SubscriptionConstants.ERROR_CODE_PLAN_NOT_FOUND);
            response.setErrorMessage(e.getMessage());
            return response;
        } 
    }
    
    @PostMapping("/delete")
    public SubscriptionResponse deleteSubscriptionPlan(@RequestBody SubscriptionRequest subscriptionRequest) {
    	
    	try {
    		return subscriptionServiceInterface.deleteSubscriptionPlan(subscriptionRequest);
    	} catch (SQLException e) {
            SubscriptionResponse response = new SubscriptionResponse();
            response.setSuccess(false);
            response.setErrorCode(SubscriptionConstants.ERROR_CODE_PLAN_NOT_FOUND);
            response.setErrorMessage(e.getMessage());
            return response;
        } 
    }
    
    @PostMapping("/activate")
    public SubscriptionResponse activateSubscriptionPlan(@RequestBody SubscriptionRequest subscriptionRequest) {
    	
    	try {
    		return subscriptionServiceInterface.activateSubscriptionPlan(subscriptionRequest);
    	} catch (SQLException e) {
            SubscriptionResponse response = new SubscriptionResponse();
            response.setSuccess(false);
            response.setErrorCode(SubscriptionConstants.ERROR_CODE_PLAN_NOT_FOUND);
            response.setErrorMessage(e.getMessage());
            return response;
        } 
    }
    
    @PostMapping("/deactivate")
    public SubscriptionResponse deactivateSubscriptionPlan(@RequestBody SubscriptionRequest subscriptionRequest) {
    	
    	try {
    		return subscriptionServiceInterface.deactivateSubscriptionPlan(subscriptionRequest);
    	} catch (SQLException e) {
            SubscriptionResponse response = new SubscriptionResponse();
            response.setSuccess(false);
            response.setErrorCode(SubscriptionConstants.ERROR_CODE_PLAN_NOT_FOUND);
            response.setErrorMessage(e.getMessage());
            return response;
        } 
    }
    
    @GetMapping("/find")
    public SubscriptionResponse findDetailsByPlanId(@RequestBody SubscriptionRequest subscriptionRequest) {
    	
//    	try {
//    		return subscriptionServiceInterface.deactivateSubscriptionPlan(subscriptionRequest);
//    	} catch (SQLException e) {
//            SubscriptionResponse response = new SubscriptionResponse();
//            response.setSuccess(false);
//            response.setErrorCode(SubscriptionConstants.ERROR_CODE_PLAN_NOT_FOUND);
//            response.setErrorMessage(e.getMessage());
//            return response;
//        } 
    	return subscriptionServiceInterface.findDetailsByPlanId(subscriptionRequest);
    }
}


