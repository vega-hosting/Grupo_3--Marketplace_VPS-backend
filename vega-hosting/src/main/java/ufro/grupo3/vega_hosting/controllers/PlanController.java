package ufro.grupo3.vega_hosting.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ufro.grupo3.vega_hosting.DTOs.AdminPlanDTO;
import ufro.grupo3.vega_hosting.DTOs.UserPlanDTO;
import ufro.grupo3.vega_hosting.services.PlanService;

@RestController
@RequestMapping("/v1/api/plans")
@CrossOrigin(origins = "http://localhost:8080")
@RequiredArgsConstructor
public class PlanController {

    private final PlanService planService;

    @GetMapping("/admin")
    public ResponseEntity<List<AdminPlanDTO>> getAllPlansForAdmin() {
        try {
            return ResponseEntity.ok(planService.getAllPlansForAdmin());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserPlanDTO>> getAllPlansForUser() {
        try {
            return ResponseEntity.ok(planService.getAllPlansForUser());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/admin/plan/{planId}")
    public ResponseEntity<AdminPlanDTO> getPlanByIdForAdmin(@PathVariable("planId") Integer id) {
        try {
            return ResponseEntity.ok(planService.getPlanByIdForAdmin(id));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/plan/{planId}")
    public ResponseEntity<UserPlanDTO> getPlanByIdForUser(@PathVariable("planId") Integer id) {
        try {
            UserPlanDTO planDTO = planService.getPlanByIdForUser(id);
            return ResponseEntity.ok(planDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<AdminPlanDTO> createPlan(@RequestBody AdminPlanDTO planToCreate){
        try {
            return ResponseEntity.ok(planService.createPlan(planToCreate));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{planId}")
    public ResponseEntity<Void> deletePlan(@PathVariable("planId") Integer id) {
        try {
            planService.deletePlan(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<AdminPlanDTO> updatePlan(@RequestBody AdminPlanDTO planToUpdate){
        try {
            return ResponseEntity.ok(planService.updatePlan(planToUpdate));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/user/{planId}/reduce-quantity")
    public ResponseEntity<UserPlanDTO> reduceQuantity(@PathVariable("planId") Integer id){
        try {
            return ResponseEntity.ok(planService.reducePlanQuantity(id));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
