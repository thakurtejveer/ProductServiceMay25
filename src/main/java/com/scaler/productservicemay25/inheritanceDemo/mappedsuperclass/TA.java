package com.scaler.productservicemay25.inheritanceDemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_tas")
public class TA extends User {
    private String numberOfHRs;
}
