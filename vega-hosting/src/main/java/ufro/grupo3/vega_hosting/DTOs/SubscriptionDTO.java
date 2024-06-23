package ufro.grupo3.vega_hosting.DTOs;

import lombok.Data;

@Data
public class SubscriptionDTO {
    
    private Integer id;
    private String duration;
    private Integer price;
    private String hostname;
    private String os;
    private String passAdmin;
    private String addVcore;
    private String addRam;
    private String addStorage;
    private Integer planId;
    private String namePlan;
    private Integer vcore;
    private Integer ram;
    private Integer storage;
    private Integer bus;
    private Integer userId;
}
