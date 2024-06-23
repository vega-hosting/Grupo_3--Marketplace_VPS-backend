package ufro.grupo3.vega_hosting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ufro.grupo3.vega_hosting.models.Subscription;

import java.util.List;


public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

    List<Subscription> findByPlanId(Integer planId);

    List<Subscription> findByUserId(Integer userId);
}
