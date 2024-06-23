package ufro.grupo3.vega_hosting.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ufro.grupo3.vega_hosting.DTOs.SubscriptionDTO;
import ufro.grupo3.vega_hosting.mappers.SubscriptionMapper;
import ufro.grupo3.vega_hosting.models.Subscription;
import ufro.grupo3.vega_hosting.repositories.SubscriptionRepository;

@Service
@AllArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    private final SubscriptionMapper subscriptionMapper;

    @Override
    public List<SubscriptionDTO> getSubscriptionsForUser(Integer id) throws Exception {
        try {
            List<Subscription> subscriptions = subscriptionRepository.findByUserId(id);
            return subscriptions.stream()
            .map(subscriptionMapper::toSubscriptionDTO)
            .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception("Error fetching plans: " + e.getMessage());
        }
    }

    @Override
    public SubscriptionDTO createSubscription(SubscriptionDTO subscriptionToCreate) throws Exception {
        Subscription subscription = subscriptionMapper.toEntity(subscriptionToCreate);
        Subscription savedSubscription = subscriptionRepository.save(subscription);
        return subscriptionMapper.toSubscriptionDTO(savedSubscription);
    }

}
