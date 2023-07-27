package com.insignia.subscription.constants;

public class SubscriptionConstants {
	//Success message
	public static final String SUCCESS_MESSAGE = "Request processed successfully.";

	// Error messages
	public static final String ERROR_MESSAGE_INTERNAL_SERVER = "An internal server error occurred.";
	public static final String ERROR_MESSAGE_PLAN_NOT_FOUND = "Subscription plan not found.";
	public static final String ERROR_MESSAGE_DATA_INTEGRITY = "Plan already exists.";

	// Error codes
	public static final int ERROR_CODE_INTERNAL_SERVER = 500;
	public static final int ERROR_CODE_PLAN_NOT_FOUND = 506;
	public static final int ERROR_CODE_DATA_INTEGRITY = 504;
}