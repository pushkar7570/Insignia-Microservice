package com.insignia.subscription.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insignia.customExceptions.InvalidInputParametersException;
import com.insignia.subscription.constants.SubscriptionConstants;
import com.insignia.subscription.model.SubscriptionRequest;
import com.insignia.subscription.model.SubscriptionResponse;
import com.insignia.subscription.service.SubscriptionServiceInterface;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionSystemController {
	
    @Autowired
    private SubscriptionServiceInterface subscriptionServiceInterface;

    @PostMapping("/create")
    public ResponseEntity<?> createSubscriptionPlan(@RequestBody SubscriptionRequest subscriptionRequest) {
    	
    	try {
            return ResponseEntity.ok(subscriptionServiceInterface.createSubscriptionPlan(subscriptionRequest));
        } catch (InvalidInputParametersException ex) {
            // Handle DataIntegrityViolationException (e.g., duplicate key)
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SubscriptionResponse(ex.getErrorCode(), ex.getStrMsg()));
        } 
    	catch (Exception e) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SubscriptionResponse(SubscriptionConstants.ERROR_CODE_UNEXPECTED_ERROR,
    				SubscriptionConstants.ERROR_MESSAGE_UNEXPECTED_ERROR));
    	}
    	
    } 
    
    @PostMapping("/modify")
    public ResponseEntity<?> modifySubscriptionPlan(@RequestBody SubscriptionRequest subscriptionRequest) {
    	try {
    		return ResponseEntity.ok(subscriptionServiceInterface.modifySubscriptionPlan(subscriptionRequest));
          }
    	catch (InvalidInputParametersException ex) {
            // Handle DataIntegrityViolationException (e.g., duplicate key)
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SubscriptionResponse(ex.getErrorCode(), ex.getStrMsg()));
        }    		
    	catch (Exception e) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SubscriptionResponse(SubscriptionConstants.ERROR_CODE_UNEXPECTED_ERROR,
    				SubscriptionConstants.ERROR_MESSAGE_UNEXPECTED_ERROR));
    	}
    }   

    @PostMapping("/delete")
    public ResponseEntity<?> deleteSubscriptionPlan(@RequestBody SubscriptionRequest subscriptionRequest) {
    	
    	try {
    		return ResponseEntity.ok(subscriptionServiceInterface.deleteSubscriptionPlan(subscriptionRequest));
    	} catch (InvalidInputParametersException ex) {
            // Handle DataIntegrityViolationException (e.g., duplicate key)
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SubscriptionResponse(ex.getErrorCode(), ex.getStrMsg()));
        }
    	catch (Exception e) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SubscriptionResponse(SubscriptionConstants.ERROR_CODE_UNEXPECTED_ERROR,
    				SubscriptionConstants.ERROR_MESSAGE_UNEXPECTED_ERROR));
    	}
    }
    
    @PostMapping("/activate")
    public ResponseEntity<?> activateSubscriptionPlan(@RequestBody SubscriptionRequest subscriptionRequest) {
    	
    	try {
    		return ResponseEntity.ok(subscriptionServiceInterface.activateSubscriptionPlan(subscriptionRequest));
    	} catch (InvalidInputParametersException ex) {
            // Handle DataIntegrityViolationException (e.g., duplicate key)
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SubscriptionResponse(ex.getErrorCode(), ex.getStrMsg()));
        }
    	catch (Exception e) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SubscriptionResponse(SubscriptionConstants.ERROR_CODE_UNEXPECTED_ERROR,
    				SubscriptionConstants.ERROR_MESSAGE_UNEXPECTED_ERROR));
    	}
    }
    
    @PostMapping("/deactivate")
    public ResponseEntity<?> deactivateSubscriptionPlan(@RequestBody SubscriptionRequest subscriptionRequest) {
    	
    	try {
    		return ResponseEntity.ok(subscriptionServiceInterface.deactivateSubscriptionPlan(subscriptionRequest));
    	} catch (InvalidInputParametersException ex) {
            // Handle DataIntegrityViolationException (e.g., duplicate key)
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SubscriptionResponse(ex.getErrorCode(), ex.getStrMsg()));
        }
    	catch (Exception e) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SubscriptionResponse(SubscriptionConstants.ERROR_CODE_UNEXPECTED_ERROR,
    				SubscriptionConstants.ERROR_MESSAGE_UNEXPECTED_ERROR));
    	}
    }
    
    @GetMapping("/find")
    public ResponseEntity<?> findDetailsByPlanId(@RequestBody SubscriptionRequest subscriptionRequest) {   	
    	try {
    		return ResponseEntity.ok(subscriptionServiceInterface.findDetailsByPlanId(subscriptionRequest));
    	} catch (InvalidInputParametersException ex) {
            // Handle DataIntegrityViolationException (e.g., duplicate key)
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SubscriptionResponse(ex.getErrorCode(), ex.getStrMsg()));
        }
    	catch (Exception e) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SubscriptionResponse(SubscriptionConstants.ERROR_CODE_UNEXPECTED_ERROR,
    				SubscriptionConstants.ERROR_MESSAGE_UNEXPECTED_ERROR));
    	}
    }
}


