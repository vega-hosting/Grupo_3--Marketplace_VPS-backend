package ufro.grupo3.vega_hosting.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "subscription")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer id;

    @Column(name = "duration", nullable = false, length = 15)
    private String duration;

    @Column(name = "price", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer price;

    @Column(name = "hostname", nullable = false, length = 50)
    private String hostname;

    @Column(name = "os", nullable = false, length = 30)
    private String os;

    @Column(name = "pass_admin", nullable = false, length = 20)
    private String passAdmin;

    @Column(name = "add_vcore", nullable = false, length = 25)
    private String addVcore;

    @Column(name = "add_ram", nullable = false, length = 25)
    private String addRam;

    @Column(name = "add_storage", nullable = false, length = 25)
    private String addStorage;

    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    private Plan plan;

    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private User user;
}
