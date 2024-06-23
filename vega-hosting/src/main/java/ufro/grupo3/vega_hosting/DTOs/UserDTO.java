package ufro.grupo3.vega_hosting.DTOs;

import lombok.Data;

@Data
public class UserDTO {
    private Integer id;
    private String name;
    private String email;
    private String telephone;
    private String companyName;
    private String city;
    private String address;
}
