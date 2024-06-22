package ufro.grupo3.vega_hosting.DTOs;

import lombok.Data;

@Data
public class AdminPlanDTO {
    
    private Integer id;
    private String name;
    private Integer vcore;
    private Integer ram;
    private Integer storage;
    private Integer bus;
    private Integer quantity;
    private Integer price;
}
