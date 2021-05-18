package com.amit.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amit.library.entity.SubscriptionEntity;

public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity,Integer> {

}
