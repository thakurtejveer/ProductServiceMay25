package com.scaler.productservicemay25.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scaler.productservicemay25.models.Product;
import com.scaler.productservicemay25.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProductController.class)
public class ProductControllerMockMvcTest {

    @MockitoBean
    private ProductService productService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getAllProductsAPITest() throws Exception {
        List<Product> expectedProducts = new ArrayList<>();
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        product1.setId(11111L);
        product1.setTitle("iphone 16");
        product1.setPrice(70000.0);

        product2.setId(22222L);
        product1.setTitle("iphone 17");
        product1.setPrice(80000.0);

        product3.setId(33333L);
        product3.setTitle("iphone 18");
        product3.setPrice(90000.0);

        expectedProducts.add(product1);
        expectedProducts.add(product2);
        expectedProducts.add(product3);

        when(productService.getAllProducts()).thenReturn(expectedProducts);

        String jsonProducts = objectMapper.writeValueAsString(expectedProducts);

        mockMvc.perform(
                    MockMvcRequestBuilders.get("/products")
                ).andExpect(status().isOk())
                .andExpect((ResultMatcher) content().json(jsonProducts));
    }

}
