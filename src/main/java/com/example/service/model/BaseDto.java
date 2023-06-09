package com.example.service.model;

import lombok.Data;

import java.util.Date;
@Data
public abstract class BaseDto {
    private Boolean active;
    private Boolean deleted;
    private Date createdAt;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;
}
