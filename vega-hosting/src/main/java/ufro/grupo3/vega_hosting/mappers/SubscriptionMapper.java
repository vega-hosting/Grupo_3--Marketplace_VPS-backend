package ufro.grupo3.vega_hosting.mappers;



import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import ufro.grupo3.vega_hosting.DTOs.SubscriptionDTO;
import ufro.grupo3.vega_hosting.models.Plan;
import ufro.grupo3.vega_hosting.models.Subscription;
import ufro.grupo3.vega_hosting.models.User;
import ufro.grupo3.vega_hosting.repositories.PlanRepository;
import ufro.grupo3.vega_hosting.repositories.UserRepository;

@Component
@RequiredArgsConstructor
public class SubscriptionMapper {

    private final PlanRepository planRepository;
    private final UserRepository userRepository;

    public SubscriptionDTO toSubscriptionDTO(Subscription subscription){
        SubscriptionDTO subscriptionDto = new SubscriptionDTO();
        subscriptionDto.setId(subscription.getId());
        subscriptionDto.setDuration(subscription.getDuration());
        subscriptionDto.setPrice(subscription.getPrice());
        subscriptionDto.setHostname(subscription.getHostname());
        subscriptionDto.setOs(subscription.getOs());
        subscriptionDto.setPassAdmin(subscription.getPassAdmin());
        subscriptionDto.setAddVcore(subscription.getAddVcore());
        subscriptionDto.setAddRam(subscription.getAddRam());
        subscriptionDto.setAddStorage(subscription.getAddStorage());
        subscriptionDto.setPlanId(subscription.getPlan().getId());
        subscriptionDto.setNamePlan(subscription.getPlan().getName());
        subscriptionDto.setVcore(subscription.getPlan().getVcore());
        subscriptionDto.setRam(subscription.getPlan().getRam());
        subscriptionDto.setStorage(subscription.getPlan().getStorage());
        subscriptionDto.setBus(subscription.getPlan().getBus());
        subscriptionDto.setUserId(subscription.getUser().getId());
        return subscriptionDto;
    }

    public Subscription toEntity(SubscriptionDTO subscriptionDTO) throws Exception{
        Subscription subscription = new Subscription();

        subscription.setId(subscriptionDTO.getId());
        subscription.setDuration(subscriptionDTO.getDuration());
        subscription.setPrice(subscriptionDTO.getPrice());
        subscription.setHostname(subscriptionDTO.getHostname());
        subscription.setOs(subscriptionDTO.getOs());
        subscription.setPassAdmin(subscriptionDTO.getPassAdmin());
        subscription.setAddVcore(subscriptionDTO.getAddVcore());
        subscription.setAddRam(subscriptionDTO.getAddRam());
        subscription.setAddStorage(subscriptionDTO.getAddStorage());


        Plan plan = planRepository.findById(subscriptionDTO.getPlanId()).
        orElseThrow(() -> new Exception("Plan not found with ID: " + subscriptionDTO.getPlanId()));
        subscription.setPlan(plan);

        User user = userRepository.findById(subscriptionDTO.getUserId()).
        orElseThrow(() -> new Exception("User not found with ID: " + subscriptionDTO.getUserId()));
        subscription.setUser(user);

        return subscription;
    }    
}
