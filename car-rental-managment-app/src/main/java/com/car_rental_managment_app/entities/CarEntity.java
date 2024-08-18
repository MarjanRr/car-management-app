package com.car_rental_managment_app.entities;

import com.car_rental_managment_app.enums.Color;
import com.car_rental_managment_app.enums.Engine;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id")
    Long id;


    @Column(name = "brand")
    private String brand;

    @Column(name = "color")
    private Color color;

    @Column(name = "model")
    private String model;

    @Column(name = "licensePlate")
    private Integer licensePlate;

    @Column(name = "rentalPerDay")
    private Integer rentalPerDay;

    @Column(name = "engine")
    private Engine engine;

    @Column(name = "isAvailable")
    private boolean isAvailable;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "branch_id")
    private BranchEntity branchEntity;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "carEntity")
    private List<ReservationEntity> reservationEntities;


}
