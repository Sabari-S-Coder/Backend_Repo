package com.ecommerce.product_service.service;

import org.springframework.stereotype.Service;

import com.ecommerce.product_service.dto.ProductRequest;
import com.ecommerce.product_service.model.Product;
import com.ecommerce.product_service.repo.ProductRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;

    public void createProduct(ProductRequest productRequest) {
        Product product=Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();
        productRepo.save(product);

    }
}
