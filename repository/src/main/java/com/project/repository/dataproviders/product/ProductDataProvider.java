package com.project.repository.dataproviders.product;

import com.project.repository.domain.Product;
import com.project.repository.domain.product_usecase.ReadProduct;
import com.project.repository.domain.product_usecase.WriteProduct;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class ProductDataProvider implements ReadProduct, WriteProduct {

    private final ProductRepository productRepository;

    public ProductDataProvider(ProductRepository productRepository) {this.productRepository = productRepository;}

    @Override
    public List<Product> findAll() {
        return productRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    private Product toDomain(ProductDao productDao) {
        Product product = new Product();
        product.setDescription(productDao.getDescription());
        product.setId(productDao.getId());
        product.setImageURL(productDao.getImageURL());
        product.setName(productDao.getName());
        product.setPrice(productDao.getPrice());
        product.setTotalReviews(productDao.getTotalReviews());
        return product;
    }

    @Override
    public Product saveProduct(Product product) {
        return toDomain(productRepository.save(toDao(product)));
    }

    private ProductDao toDao(Product product) {
        ProductDao productDao = new ProductDao();
        productDao.setDescription(product.getDescription());
        productDao.setImageURL(product.getImageURL());
        productDao.setName(product.getName());
        productDao.setPrice(product.getPrice());
        productDao.setTotalReviews(product.getTotalReviews());
        return productDao;
    }

}
