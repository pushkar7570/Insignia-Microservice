package com.insignia.subscription.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SubscriptionResponse {
    private boolean success;
    private String errorCode;
    private String errorMessage;
    private String planId;
    private String planName;
    private String planDescription;
    private int planDuration;
    private BigDecimal planPricing;
    private String planActivationStatus;
    private LocalDateTime planActivationDate;
    private LocalDateTime planDeactivationDate;

    // Constructor
    public SubscriptionResponse() {
    }

    public SubscriptionResponse(boolean success, String errorCode, String errorMessage, String planId,
            String planName, String planDescription, int planDuration, BigDecimal planPricing,
            String planActivationStatus, LocalDateTime planActivationDate, LocalDateTime planDeactivationDate) {
        this.success = success;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.planId = planId;
        this.planName = planName;
        this.planDescription = planDescription;
        this.planDuration = planDuration;
        this.planPricing = planPricing;
        this.planActivationStatus = planActivationStatus;
        this.planActivationDate = planActivationDate;
        this.planDeactivationDate = planDeactivationDate;
    }

    // Getters and Setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }

    public int getPlanDuration() {
        return planDuration;
    }

    public void setPlanDuration(int planDuration) {
        this.planDuration = planDuration;
    }

    public BigDecimal getPlanPricing() {
        return planPricing;
    }

    public void setPlanPricing(BigDecimal planPricing) {
        this.planPricing = planPricing;
    }

    public String getPlanActivationStatus() {
        return planActivationStatus;
    }

    public void setPlanActivationStatus(String planActivationStatus) {
        this.planActivationStatus = planActivationStatus;
    }

    public LocalDateTime getPlanActivationDate() {
        return planActivationDate;
    }

    public void setPlanActivationDate(LocalDateTime planActivationDate) {
        this.planActivationDate = planActivationDate;
    }

    public LocalDateTime getPlanDeactivationDate() {
        return planDeactivationDate;
    }

    public void setPlanDeactivationDate(LocalDateTime planDeactivationDate) {
        this.planDeactivationDate = planDeactivationDate;
    }

    // toString method
    public String createSubscriptionResponse() {
        return "{" +
                "\"planId\": \"" + planId + "\"," +
                "\"planName\": \"" + planName + "\"," +
                "\"description\": \"" + planDescription + "\"," +
                "\"duration\": " + planDuration + "," +
                "\"pricing\": " + planPricing + "," +
                "\"startDate\": \"" + planActivationDate + "\"," +
                "\"endDate\": \"" + planDeactivationDate + "\"," +
                "\"subscriptionStatus\": \"" + planActivationStatus + "\"," +
                "\"errorCode\": \"" + errorCode + "\"," +
                "\"errorMessage\": \"" + errorMessage + "\"" +
                "}";
    }
}
