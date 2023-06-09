package com.example.service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity()
@Table(name = "parking_lot", schema = "parking")
@NoArgsConstructor
public class ParkingLot extends  BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(nullable = false, name = "id")
    private Integer id;

    @Column(nullable = false, name = "name")

    private String name;
}
