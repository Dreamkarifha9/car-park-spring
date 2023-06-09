package com.example.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.io.Serializable;
import java.util.Date;
@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Column(nullable = true,name = "active")
    private Boolean active = true;
    @Column(nullable = true, name = "deleted")

    private Boolean deleted = false;
    @Column(nullable = true, name = "\"createdAt\"")
    @CreationTimestamp
    private Date createdAt;
    @Column(nullable = true, name = "\"createdBy\"")

    private String createdBy;
    @Column(nullable = true, name = "\"updatedAt\"")
    @CreationTimestamp
    private Date updatedAt;

    @Column(nullable = true, name = "\"updatedBy\"")

    private String updatedBy;
}
