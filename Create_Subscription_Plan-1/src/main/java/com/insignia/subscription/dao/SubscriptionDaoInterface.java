package com.insignia.subscription.dao;

import java.sql.SQLException;

import com.insignia.subscription.model.SubscriptionRequest;
import com.insignia.subscription.model.SubscriptionResponse;

public interface SubscriptionDaoInterface {

	public SubscriptionResponse createSubscriptionPlan(SubscriptionRequest subscriptionRequest) throws SQLException;
	public SubscriptionResponse modifySubscriptionPlan(SubscriptionRequest subscriptionRequest) throws SQLException;
	public SubscriptionResponse deleteSubscriptionPlan(SubscriptionRequest subscriptionRequest) throws SQLException;
	public SubscriptionResponse activateSubscriptionPlan(SubscriptionRequest subscriptionRequest) throws SQLException;
	public SubscriptionResponse deactivateSubscriptionPlan(SubscriptionRequest subscriptionRequest) throws SQLException;
}
