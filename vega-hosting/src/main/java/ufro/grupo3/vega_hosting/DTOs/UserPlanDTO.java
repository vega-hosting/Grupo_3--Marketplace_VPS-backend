package ufro.grupo3.vega_hosting.DTOs;

import lombok.Data;

@Data
public class UserPlanDTO {
    
    private Integer id;
    private String name;
    private Integer vcore;
    private Integer ram;
    private Integer bus;
    private Integer price;
}
