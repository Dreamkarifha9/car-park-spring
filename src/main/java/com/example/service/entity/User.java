package com.example.service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity()
@Table(name = "user", schema = "parking")
public class User extends BaseEntity implements Serializable {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(length = 36, nullable = false, updatable = false)
    private  String id;
    @Column(nullable = false, unique = true, length = 60)
    private String email;
    @Column(nullable = false, length = 120)
    private String password;
    @Column(nullable = false,length = 120)
    private String name;
}
