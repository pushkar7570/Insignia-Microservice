package com.insignia.subscription.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class SubscriptionResponse {
    private boolean success;
    private boolean deleteStatus;
    private int errorCode;
    private String errorMessage;
    private String planId;
    private String planName;
    private String planDescription;
    private int planDuration;
    private BigDecimal planPricing;
    private String planActivationStatus;
    private LocalDateTime planActivationDate;
    private LocalDateTime planDeactivationDate;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
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
	public boolean isDeleteStatus() {
		return deleteStatus;
	}
	public void setDeleteStatus(boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	@Override
	public String toString() {
		return "SubscriptionResponse [success=" + success + ", errorCode=" + errorCode + ", errorMessage="
				+ errorMessage + ", planId=" + planId + ", planName=" + planName + ", planDescription="
				+ planDescription + ", planDuration=" + planDuration + ", planPricing=" + planPricing
				+ ", planActivationStatus=" + planActivationStatus + ", planActivationDate=" + planActivationDate
				+ ", planDeactivationDate=" + planDeactivationDate + "]";
	}
}