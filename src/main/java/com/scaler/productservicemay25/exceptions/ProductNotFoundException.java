package com.scaler.productservicemay25.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundException extends Exception {
    private Long productId;
    public ProductNotFoundException(String message, Long id) {
        super(message);
        this.productId = id;
    }

    public ProductNotFoundException() {
        super();
    }
}
