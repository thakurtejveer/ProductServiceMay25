package com.scaler.productservicemay25.inheritanceDemo.singletable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="st_users")
@DiscriminatorColumn(name="userType",
        discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(value="0")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
}
