package com.insignia.subscription.dao;

import com.insignia.subscription.model.SubscriptionRequest;
import com.insignia.subscription.model.SubscriptionResponse;

public interface SubscriptionDaoInterface {

	public SubscriptionResponse createSubscriptionPlan(SubscriptionRequest subscriptionRequest);
	public SubscriptionResponse modifySubscriptionPlan(SubscriptionRequest subscriptionRequest);
	public SubscriptionResponse deleteSubscriptionPlan(SubscriptionRequest subscriptionRequest);
}
