package ufro.grupo3.vega_hosting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufro.grupo3.vega_hosting.models.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> {    
}