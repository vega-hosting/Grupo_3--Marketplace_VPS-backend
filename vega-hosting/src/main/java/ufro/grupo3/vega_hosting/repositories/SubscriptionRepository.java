package ufro.grupo3.vega_hosting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ufro.grupo3.vega_hosting.models.Plan;
import ufro.grupo3.vega_hosting.models.Subscription;
import ufro.grupo3.vega_hosting.models.User;

import java.util.List;


public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

    List<Subscription> findByPlan(Plan plan);

    List<Subscription> findByUser(User user);
}
