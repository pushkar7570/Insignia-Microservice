package com.insignia.subscription.repo;

import java.math.BigDecimal;
//import java.util.List;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.insignia.subscription.entity.SubscriptionDetails;


@Repository
public interface UserSubscriptionRepository extends JpaRepository<SubscriptionDetails, Long> {

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO subscription_details (plan_id, plan_name, planDescription, planDuration, planPricing, planActivationDate, planDeactivation, planActivationStatus) " +
	        "VALUES (:planId, :planName, :planDescription, :planDuration, :planPricing, :planActivationStatus, :planActivationDate, :planDeactivationDate)", nativeQuery = true)
	void createSubscriptionPlan(@Param("planId") String planId,
	                            @Param("planName") String planName,
	                            @Param("planDescription") String planDescription,
	                            @Param("planDuration") int planDuration,
	                            @Param("planPricing") BigDecimal planPricing,
	                            @Param("planActivationStatus") String planActivationStatus,
	                            @Param("planActivationDate") LocalDateTime planActivationDate,
	                            @Param("planDeactivationDate") LocalDateTime planDeactivationDate
	                            );

}