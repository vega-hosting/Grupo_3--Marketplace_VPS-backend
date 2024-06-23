package ufro.grupo3.vega_hosting.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ufro.grupo3.vega_hosting.DTOs.AdminPlanDTO;
import ufro.grupo3.vega_hosting.DTOs.UserPlanDTO;
import ufro.grupo3.vega_hosting.mappers.PlanMapper;
import ufro.grupo3.vega_hosting.models.Plan;
import ufro.grupo3.vega_hosting.repositories.PlanRepository;

@Service
@AllArgsConstructor
public class PlanServiceImpl implements PlanService {

    private final PlanRepository planRepository;

    @Override
    public List<AdminPlanDTO> getAllPlansForAdmin() throws Exception {
        try {

            List<Plan> plans = planRepository.findAll();
            return plans.stream()
                    .map(PlanMapper::toAdminPlanDTO)
                    .collect(Collectors.toList());
        } catch (DataAccessException e) {
            throw new Exception("Error fetching plans: " + e.getMessage());
        }
    }

    @Override
    public List<UserPlanDTO> getAllPlansForUser() throws Exception {
        try {
            List<Plan> plans = planRepository.findAll();
            return plans.stream()
                    .map(PlanMapper::toUserPlanDTO)
                    .collect(Collectors.toList());
        } catch (DataAccessException e) {
            throw new Exception("Error fetching plans: " + e.getMessage());
        }
    }

    @Override
    public AdminPlanDTO getPlanByIdForAdmin(Integer id) throws Exception {
        Plan plan = planRepository.findById(id).orElseThrow(
                () -> new Exception("This plan doesn't exist!"));
        return PlanMapper.toAdminPlanDTO(plan);
    }

    @Override
    public UserPlanDTO getPlanByIdForUser(Integer id) throws Exception {
        Plan plan = planRepository.findById(id).orElseThrow(
                () -> new Exception("This plan doesn't exist!"));
        return PlanMapper.toUserPlanDTO(plan);
    }

    @Override
    public void deletePlan(Integer id) throws Exception {
        if (!planRepository.existsById(id)) {
            throw new Exception("This plan doesn't exist!");
        }
        planRepository.deleteById(id);
    }

    @Override
    public AdminPlanDTO createPlan(AdminPlanDTO planToCreate) throws Exception {
        Plan plan = PlanMapper.toEntity(planToCreate);
        Plan savedPlan = planRepository.save(plan);
        return PlanMapper.toAdminPlanDTO(savedPlan);
    }

    @Override
    public AdminPlanDTO updatePlan(AdminPlanDTO planDetails) throws Exception {
        Plan planToUpdate = planRepository.findById(planDetails.getId())
                .orElseThrow(() -> new Exception("This plan doesn't exist!"));

        planToUpdate.setName(planDetails.getName());
        planToUpdate.setVcore(planDetails.getVcore());
        planToUpdate.setRam(planDetails.getRam());
        planToUpdate.setStorage(planDetails.getStorage());
        planToUpdate.setBus(planDetails.getBus());
        planToUpdate.setQuantity(planDetails.getQuantity());
        planToUpdate.setPrice(planDetails.getPrice());

        Plan updatedPlan = planRepository.save(planToUpdate);

        return PlanMapper.toAdminPlanDTO(updatedPlan);
    }

    @Override
    public UserPlanDTO reducePlanQuantity(Integer id) throws Exception {
        Plan planToUpdate = planRepository.findById(id)
                .orElseThrow(() -> new Exception("This plan doesn't exist!"));

        int currentQuantity = planToUpdate.getQuantity();

        if (currentQuantity > 0) {
            planToUpdate.setQuantity(currentQuantity - 1);
        } else {
            throw new Exception("The quantity cannot be reduced below zero");
        }

        Plan updatedPlan = planRepository.save(planToUpdate);

        return PlanMapper.toUserPlanDTO(updatedPlan);
    }

}
