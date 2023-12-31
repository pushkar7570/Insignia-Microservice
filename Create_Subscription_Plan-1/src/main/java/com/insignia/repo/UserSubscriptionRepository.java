package com.insignia.repo;

import java.math.BigDecimal;
//import java.util.List;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.insignia.entity.SubscriptionDetails;


@Repository
public interface UserSubscriptionRepository extends JpaRepository<SubscriptionDetails, Long> {

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO subscription_plan_master_table (plan_id, plan_name, plan_description, plan_duration, plan_pricing, plan_activation_status, plan_activation_date, plan_deactivation_date) " +
	        "VALUES (:plan_id, :plan_name, :plan_description, :plan_duration, :plan_pricing, :plan_activation_status, :plan_activation_date, :plan_deactivation_date)", nativeQuery = true)
	void createSubscriptionPlan(@Param("plan_id") String planId,
	                            @Param("plan_name") String planName,
	                            @Param("plan_description") String planDescription,
	                            @Param("plan_duration") Integer planDuration,
	                            @Param("plan_pricing") BigDecimal planPricing,
	                            @Param("plan_activation_status") String planActivationStatus,
	                            @Param("plan_activation_date") LocalDateTime planActivationDate,
	                            @Param("plan_deactivation_date") LocalDateTime planDeactivationDate
	                            );

	Optional<SubscriptionDetails> findByPlanId(String planId);
	
	List<SubscriptionDetails> findDetailsByPlanId(String planId);

	
	@Transactional
    @Modifying
	@Query(value = "UPDATE subscription_plan_master_table " +
            "SET plan_name = :plan_name, " +
            "plan_description = :plan_description, " +
            "plan_duration = :plan_duration, " +
            "plan_pricing = :plan_pricing, " +
            "plan_activation_status = :plan_activation_status, " +
            "plan_activation_date = :plan_activation_date, " +
            "plan_deactivation_date = :plan_deactivation_date " +
            "WHERE plan_id = :plan_id", nativeQuery = true)
    void modifySubscriptionPlan(@Param("plan_id") String planId,
                                @Param("plan_name") String planName,
                                @Param("plan_description") String planDescription,
                                @Param("plan_duration") int planDuration,
                                @Param("plan_pricing") BigDecimal planPricing,
                                @Param("plan_activation_status") String planActivationStatus,
                                @Param("plan_activation_date") LocalDateTime planActivationDate,
                                @Param("plan_deactivation_date") LocalDateTime planDeactivationDate);

	
	
	@Transactional
    @Modifying
    @Query(value = "DELETE FROM subscription_plan_master_table WHERE plan_id = :plan_id", nativeQuery = true)
    int deleteSubscriptionPlan(@Param("plan_id") String planId);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE subscription_plan_master_table " +
            "SET plan_activation_status = 'active', " +
            "plan_activation_date = CURRENT_TIMESTAMP, " +
            "plan_deactivation_date = NULL " +
            "WHERE plan_id = :plan_id", nativeQuery = true)
	void activateSubscriptionPlan(@Param("plan_id") String planId);
	
	@Transactional
    @Modifying
    @Query(value = "UPDATE subscription_plan_master_table " +
            "SET plan_activation_status = 'inactive', " +
            "plan_deactivation_date = CURRENT_TIMESTAMP, " +
            "plan_activation_date = NULL " +
            "WHERE plan_id = :plan_id", nativeQuery = true)
    int deactivateSubscriptionPlan(@Param("plan_id") String planId);
	
}