package com.project.scrapper.domain.use_case;


import com.project.scrapper.domain.Product;

public interface WriteProduct {

    Product saveProduct(Product product);
}
