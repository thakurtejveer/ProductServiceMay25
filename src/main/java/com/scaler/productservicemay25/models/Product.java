package com.scaler.productservicemay25.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Data // instead of Getter and Setter, @Data can be used
public class Product extends BaseModel{

    // for specific parameters to make accessible to setter,
    // use @Setter above parameters, and remove from class level.
    private String title;
    private Double price;
    private String description;
    private String imageUrl;
    private Category category;
}
