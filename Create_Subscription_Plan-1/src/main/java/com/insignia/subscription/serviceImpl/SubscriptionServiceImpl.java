package com.insignia.subscription.serviceImpl;

import org.springframework.stereotype.Service;

import com.insignia.subscription.entity.SubscriptionDetails;
import com.insignia.subscription.model.SubscriptionResponse;
import com.insignia.subscription.service.SubscriptionServiceInterface;
import com.insignia.subscription.repo.UserSubscriptionRepository;

import jakarta.transaction.Transactional;


@Service
public class SubscriptionServiceImpl implements SubscriptionServiceInterface{
	
    private final UserSubscriptionRepository userSubscriptionRepository;
	
    public SubscriptionServiceImpl(UserSubscriptionRepository userSubscriptionRepository){
        this.userSubscriptionRepository = userSubscriptionRepository;
    }

    @Override
    @Transactional
    public String createSubscriptionPlan(SubscriptionDetails subscriptionDetails) {
        try {
            userSubscriptionRepository.createSubscriptionPlan(
                    subscriptionDetails.getPlanId(),
                    subscriptionDetails.getPlanName(),
                    subscriptionDetails.getPlanDescription(),
                    subscriptionDetails.getPlanDuration(),
                    subscriptionDetails.getPlanPricing(),
                    subscriptionDetails.getPlanActivationStatus(),
                    subscriptionDetails.getPlanActivationDate(),
                    subscriptionDetails.getPlanDeactivationDate()
            );
            return new SubscriptionResponse().createSubscriptionResponse();
        } catch (Exception e) {
            // Handle the exception (e.g., log the error, throw a custom exception, etc.)
            // You can customize this part based on your error handling requirements
           return "Hello";
        }
    }
}