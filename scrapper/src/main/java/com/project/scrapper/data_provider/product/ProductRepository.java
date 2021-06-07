package com.project.scrapper.data_provider.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "repository", url = "http://localhost:8361/repository/product")
public interface ProductRepository {

    @PostMapping(value = "/save", produces = "application/json")
    ProductDao saveProduct(ProductDao productDao);

}
