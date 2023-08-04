package com.insignia.subscription.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insignia.customExceptions.InvalidInputParametersException;
import com.insignia.subscription.dao.SubscriptionDaoInterface;
import com.insignia.subscription.model.SubscriptionRequest;
import com.insignia.subscription.model.SubscriptionResponse;
import com.insignia.subscription.service.SubscriptionServiceInterface;

@Service
public class SubscriptionServiceImpl implements SubscriptionServiceInterface{
	
	@Autowired
    private SubscriptionDaoInterface subscriptionDao;

	@Override
	public SubscriptionResponse createSubscriptionPlan(SubscriptionRequest subscriptionRequest) throws InvalidInputParametersException {
//		 TODO Auto-generated method stub
		return subscriptionDao.createSubscriptionPlan(subscriptionRequest);
	}
	
	@Override
	public SubscriptionResponse modifySubscriptionPlan(SubscriptionRequest subscriptionRequest) throws InvalidInputParametersException {
//		 TODO Auto-generated method stub
		return subscriptionDao.modifySubscriptionPlan(subscriptionRequest);
	}
//	
	@Override
	public SubscriptionResponse deleteSubscriptionPlan(SubscriptionRequest subscriptionRequest) throws InvalidInputParametersException {
//		 TODO Auto-generated method stub
		return subscriptionDao.deleteSubscriptionPlan(subscriptionRequest);
	}
	
	@Override
	public SubscriptionResponse activateSubscriptionPlan(SubscriptionRequest subscriptionRequest) throws InvalidInputParametersException {
//		 TODO Auto-generated method stub
		return subscriptionDao.activateSubscriptionPlan(subscriptionRequest);
	}
	
	@Override
	public SubscriptionResponse deactivateSubscriptionPlan(SubscriptionRequest subscriptionRequest) throws InvalidInputParametersException {
//		 TODO Auto-generated method stub
		return subscriptionDao.deactivateSubscriptionPlan(subscriptionRequest);
	}
	@Override
	public SubscriptionResponse findDetailsByPlanId(SubscriptionRequest subscriptionRequest) throws InvalidInputParametersException{
//		 TODO Auto-generated method stub
		return subscriptionDao.findDetailsByPlanId(subscriptionRequest);
	}
}
