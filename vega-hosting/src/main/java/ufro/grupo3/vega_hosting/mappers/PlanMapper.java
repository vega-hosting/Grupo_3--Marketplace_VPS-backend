package ufro.grupo3.vega_hosting.mappers;

import ufro.grupo3.vega_hosting.DTOs.AdminPlanDTO;
import ufro.grupo3.vega_hosting.DTOs.UserPlanDTO;
import ufro.grupo3.vega_hosting.models.Plan;

public class PlanMapper {
    
    public static AdminPlanDTO toAdminPlanDTO(Plan plan){
        AdminPlanDTO adminDTO = new AdminPlanDTO();
        adminDTO.setId(plan.getId());
        adminDTO.setName(plan.getName());
        adminDTO.setVcore(plan.getVcore());
        adminDTO.setRam(plan.getRam());
        adminDTO.setStorage(plan.getStorage());
        adminDTO.setBus(plan.getBus());
        adminDTO.setQuantity(plan.getQuantity());
        adminDTO.setPrice(plan.getPrice());
        return adminDTO;
    }

    public static UserPlanDTO toUserPlanDTO(Plan plan){
        UserPlanDTO userDTO = new UserPlanDTO();
        userDTO.setId(plan.getId());
        userDTO.setName(plan.getName());
        userDTO.setVcore(plan.getVcore());
        userDTO.setRam(plan.getRam());
        userDTO.setStorage(plan.getStorage());
        userDTO.setBus(plan.getBus());
        userDTO.setPrice(plan.getPrice());
        return userDTO;
    }

    public static Plan toEntity(AdminPlanDTO dto) {
        Plan plan = new Plan();
        plan.setId(dto.getId());
        plan.setName(dto.getName());
        plan.setVcore(dto.getVcore());
        plan.setRam(dto.getRam());
        plan.setStorage(dto.getStorage());
        plan.setBus(dto.getBus());
        plan.setQuantity(dto.getQuantity());
        plan.setPrice(dto.getPrice());
        return plan;
    }
}
