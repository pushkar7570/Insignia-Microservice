package com.insignia.subscription.service;

import com.insignia.subscription.model.SubscriptionRequest;
import com.insignia.subscription.model.SubscriptionResponse;

public interface SubscriptionServiceInterface {
	
	public SubscriptionResponse createSubscriptionPlan(SubscriptionRequest subscriptionRequest);
	public SubscriptionResponse modifySubscriptionPlan(SubscriptionRequest subscriptionRequest);
	public SubscriptionResponse deleteSubscriptionPlan(SubscriptionRequest subscriptionRequest);
}
