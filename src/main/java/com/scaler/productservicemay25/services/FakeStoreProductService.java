package com.scaler.productservicemay25.services;

import com.scaler.productservicemay25.dtos.FakeStoreProductDto;
import com.scaler.productservicemay25.exceptions.ProductNotFoundException;
import com.scaler.productservicemay25.models.Category;
import com.scaler.productservicemay25.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
//@Primary
public class FakeStoreProductService implements ProductService {

    // This service class is just a fake implementation of ProductService
    // RestTemplate is used to make calls to the external store API.

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
//        throw new RuntimeException("Something wrong happened in service method");
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/" + productId, FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductDtoResponseEntity.getBody();

        // convert FakeStoreProductDto to Product
        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("Product with given id : " + productId + " is not found", productId);
        }
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        ResponseEntity<FakeStoreProductDto[]> fakeStoreProductDtos = restTemplate.getForEntity("https://fakestoreapi.com/products/", FakeStoreProductDto[].class);
        FakeStoreProductDto[] fakeStoreProductDtoArray = fakeStoreProductDtos.getBody();
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtoArray) {
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreProductDto fakeStoreProductDto = convertProductToFakeStoreProductDto(product);
        ResponseEntity<FakeStoreProductDto> productResponseEntity = restTemplate.postForEntity("https://fakestoreapi.com/products", fakeStoreProductDto, FakeStoreProductDto.class);
        if(!productResponseEntity.getStatusCode().is2xxSuccessful() || productResponseEntity.getBody() == null) {
            throw new RuntimeException("Something wrong happened while creating a new product");
        }
        return convertFakeStoreProductDtoToProduct(productResponseEntity.getBody());
    }

    @Override
    public void deleteProduct(Long id) {

    }

    private static Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        if(fakeStoreProductDto == null) {
            return null;
        }
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImage());

        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }

    private static FakeStoreProductDto convertProductToFakeStoreProductDto(Product product) {
        if(product == null) {
            return null;
        }
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setImage(product.getImageUrl());
        fakeStoreProductDto.setCategory(product.getCategory().getTitle());
        return fakeStoreProductDto;
    }
}
