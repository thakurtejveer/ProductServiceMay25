package com.scaler.productservicemay25.inheritanceDemo.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="st_tas") // no use of this as this is child of User which is marked as Single table
@DiscriminatorValue(value="1")
public class TA extends User {
    private String numberOfHRs;
}
