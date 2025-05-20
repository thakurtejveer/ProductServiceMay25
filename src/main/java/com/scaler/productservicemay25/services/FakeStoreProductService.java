package com.scaler.productservicemay25.services;

import com.scaler.productservicemay25.dtos.FakeStoreProductDto;
import com.scaler.productservicemay25.models.Category;
import com.scaler.productservicemay25.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    // This service class is just a fake implementation of ProductService
    // RestTemplate is used to make calls to the external store API.

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/" + productId, FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductDtoResponseEntity.getBody();

        // convert FakeStoreProductDto to Product
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
        return null;
    }

    @Override
    public boolean deleteProduct(Long id) {
        return false;
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
}
