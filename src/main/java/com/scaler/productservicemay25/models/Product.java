package com.scaler.productservicemay25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Data // instead of Getter and Setter, @Data can be used
//@Table(name = "products", schema = "productservicemay25")
@Entity(name = "products")
public class Product extends BaseModel{

    // for specific parameters to make accessible to setter,
    // use @Setter above parameters, and remove from class level.
    private String title;
    private Double price;
    private String description;
    private String imageUrl;
    @ManyToOne
    private Category category;
}
