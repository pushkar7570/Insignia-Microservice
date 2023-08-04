package com.insignia.subscription.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionRequest {
    private String planId;
    private String planName;
    private String planDescription;
    private Integer planDuration;
    private BigDecimal planPricing;
    private String planActivationStatus;
    private LocalDateTime planActivationDate;
    private boolean isActivationDateNull;
    private boolean isDeactivationDateNull;
    private LocalDateTime planDeactivationDate;
    
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
	public Integer getPlanDuration() {
		return planDuration;
	}
	public void setPlanDuration(Integer planDuration) {
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
            this.isActivationDateNull = true;
	}	
	public LocalDateTime getPlanDeactivationDate() {
		return planDeactivationDate;
	}
	public void setPlanDeactivationDate(LocalDateTime planDeactivationDate) {
		
		if (planDeactivationDate != null) {
	        this.planDeactivationDate = planDeactivationDate;
	        this.isDeactivationDateNull = false;
	    } else {
	        this.isDeactivationDateNull = true;
	    }
	}		
	public boolean isActivationDateNull() {
		return isActivationDateNull;
	}
	public boolean isDeactivationDateNull() {
		return isDeactivationDateNull;
	}

	
	@Override
	public String toString() {
		return "SubscriptionRequest [planId=" + planId + ", planName=" + planName + ", planDescription="
				+ planDescription + ", planDuration=" + planDuration + ", planPricing=" + planPricing
				+ ", planActivationStatus=" + planActivationStatus + ", planActivationDate=" + planActivationDate
				+ ", planDeactivationDate=" + planDeactivationDate + "]";
	}
    
	
}