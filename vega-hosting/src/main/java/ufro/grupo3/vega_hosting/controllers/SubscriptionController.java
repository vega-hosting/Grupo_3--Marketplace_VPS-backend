package ufro.grupo3.vega_hosting.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ufro.grupo3.vega_hosting.DTOs.SubscriptionDTO;
import ufro.grupo3.vega_hosting.services.SubscriptionService;

@RestController
@RequestMapping("v1/api/subscriptions")
@CrossOrigin(origins = "http://localhost:8080")
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @GetMapping("user/{userId}")
    public ResponseEntity<List<SubscriptionDTO>> getSubscriptionsForUser(@PathVariable("userId") Integer id) {
        try {
            return ResponseEntity.ok(subscriptionService.getSubscriptionsForUser(id));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<SubscriptionDTO> createSubscription(@RequestBody SubscriptionDTO subscriptionToCreate) {
        try {
            return ResponseEntity.ok(subscriptionService.createSubscription(subscriptionToCreate));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
