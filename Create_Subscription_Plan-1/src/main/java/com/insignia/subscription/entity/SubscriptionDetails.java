package com.insignia.subscription.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  @Entity
  @Table(name="subscription_plan_master_table")
  public class SubscriptionDetails {
  
  	  @Id
  	  @GeneratedValue(strategy = GenerationType.IDENTITY)
  	  @Column(name = "sequence_number")
  	  private Long sequenceNumber;
  
  	  @Column(name = "plan_id", unique = true)
  	  private String planId;
  
  	  @Column(name = "plan_name")
  	  private String planName;
  
  	  @Column(name = "plan_description")
  	  private String planDescription;
  
  	  @Column(name = "plan_duration")
  	  private Integer planDuration;
  
  	  @Column(name = "plan_pricing")
  	  private BigDecimal planPricing;
  
  	  @Column(name = "plan_activation_status")
  	  private String planActivationStatus;
  
  	  @Column(name = "plan_activation_date")
  	  private LocalDateTime planActivationDate;
  	  
  	  @Column(name = "plan_deactivation_date")
  	  private LocalDateTime planDeactivationDate;

    // Constructors, getters, and setters

    public SubscriptionDetails() {
        // Default constructor
    }

    public SubscriptionDetails(String planId, String planName, String planDescription, int planDuration,
            BigDecimal planPricing, String planActivationStatus, LocalDateTime planActivationDate,
            LocalDateTime planDeactivationDate) {
        this.planId = planId;
        this.planName = planName;
        this.planDescription = planDescription;
        this.planDuration = planDuration;
        this.planPricing = planPricing;
        this.planActivationStatus = planActivationStatus;
        this.planActivationDate = planActivationDate;
        this.planDeactivationDate = planDeactivationDate;
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
}

