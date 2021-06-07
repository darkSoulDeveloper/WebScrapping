package com.project.repository.domain.product_usecase;

import com.project.repository.domain.Product;

import java.util.List;

public interface ReadProduct {

    List<Product> findAll();

}
