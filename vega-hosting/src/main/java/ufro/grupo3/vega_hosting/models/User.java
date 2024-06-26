package ufro.grupo3.vega_hosting.models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "INT")
    private Integer id;

    @Column(name = "name", nullable = false, length = 75)
    private String name;

    @Column(name = "email", nullable = false, length = 85)
    private String email;

    @Column(name = "telephone", nullable = false, length = 20)
    private String telephone;

    @Column(name = "name_company", length = 45)
    private String companyName;

    @Column(name = "city", nullable = false, length = 65)
    private String city;

    @Column(name = "address", nullable = false, length = 125)
    private String address;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Subscription> subscriptions;
}
