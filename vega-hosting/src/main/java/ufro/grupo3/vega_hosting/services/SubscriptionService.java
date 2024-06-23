package ufro.grupo3.vega_hosting.services;

import java.util.List;

import ufro.grupo3.vega_hosting.DTOs.SubscriptionDTO;

public interface SubscriptionService {

    public List<SubscriptionDTO> getSubscriptionsForUser(Integer id) throws Exception;
    
    public SubscriptionDTO createSubscription(SubscriptionDTO subscriptionToCreate) throws Exception;
}
