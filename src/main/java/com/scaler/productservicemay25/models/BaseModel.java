package com.scaler.productservicemay25.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    private Long id;
    private Date createdAt;
    private Date lastModifiedAt;
}
