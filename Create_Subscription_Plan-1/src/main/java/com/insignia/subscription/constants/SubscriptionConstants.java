package com.insignia.subscription.constants;

public class SubscriptionConstants {
	//Success message
	public static final String SUCCESS_MESSAGE = "Request processed successfully.";

	// Error messages
	public static final String ERROR_MESSAGE_DATA_NOT_FOUND = "Enter all details correctly.";
	public static final String ERROR_MESSAGE_PLAN_NOT_FOUND = "Subscription plan not found.";
	public static final String ERROR_MESSAGE_DATA_INTEGRITY = "Plan already exists.";
	public static final String ERROR_MESSAGE_UNEXPECTED_ERROR = "Some unexpected error has occured. Please contact your support team.";
	public static final String ERROR_MESSAGE_INTERNAL_SERVER = "An internal server error occurred.";

	// Error codes
	public static final String ERROR_CODE_DATA_NOT_FOUND = "323";	
	public static final String ERROR_CODE_PLAN_NOT_FOUND = "322";
	public static final String ERROR_CODE_DATA_INTEGRITY = "321";
	public static final String ERROR_CODE_UNEXPECTED_ERROR = "320";
	public static final String ERROR_CODE_INTERNAL_SERVER = "500";
}