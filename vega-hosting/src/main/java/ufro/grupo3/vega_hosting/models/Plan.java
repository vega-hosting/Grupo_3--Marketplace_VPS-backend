package ufro.grupo3.vega_hosting.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "vcore", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer vcore;

    @Column(name = "ram", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer ram;

    @Column(name = "storage", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer storage;

    @Column(name = "bus", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer bus;

    @Column(name = "quantity", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer quantity;

    @Column(name = "price", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer price;
}
