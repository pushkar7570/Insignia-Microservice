package com.insignia.subscription.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insignia.subscription.entity.SubscriptionDetails;
import com.insignia.subscription.service.SubscriptionServiceInterface;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionSystemController {

    @Autowired
    private SubscriptionServiceInterface subscriptionServiceInterface;

    @PostMapping("/create")
    public String createSubscriptionPlan(
    		@RequestParam("plan_id") String planId,
            @RequestParam("plan_name") String planName,
            @RequestParam("plan_description") String planDescription,
            @RequestParam("plan_duration") Integer planDuration,
            @RequestParam("plan_pricing") BigDecimal planPricing,
            @RequestParam("plan_activation_status") String planActivationStatus,
            @RequestParam("plan_activation_date") LocalDateTime planActivationDate,
            @RequestParam("plan_deactivation_date") LocalDateTime planDeactivationDate
            ) {
    	
    		SubscriptionDetails subscriptionDetails = new SubscriptionDetails(planId, planName, planDescription, planDuration, planPricing,
    														planActivationStatus, planActivationDate, planDeactivationDate);

            return subscriptionServiceInterface.createSubscriptionPlan(subscriptionDetails);
        } 
}

    // Other methods for modifying, deleting, activating, and deactivating subscription plans

