package ufro.grupo3.vega_hosting.services;

import java.util.List;

import ufro.grupo3.vega_hosting.DTOs.AdminPlanDTO;
import ufro.grupo3.vega_hosting.DTOs.UserPlanDTO;

public interface PlanService {

    public List<AdminPlanDTO> getAllPlansForAdmin() throws Exception;

    public List<UserPlanDTO> getAllPlansForUser() throws Exception;

    public AdminPlanDTO getPlanByIdForAdmin(Integer id) throws Exception;

    public UserPlanDTO getPlanByIdForUser(Integer id) throws Exception;

    public void deletePlan(Integer id) throws Exception;

    public AdminPlanDTO createPlan(AdminPlanDTO planToCreate) throws Exception;

    public AdminPlanDTO updatePlan(AdminPlanDTO planDetails) throws Exception;

    public UserPlanDTO reducePlanQuantity(Integer id) throws Exception;
}
