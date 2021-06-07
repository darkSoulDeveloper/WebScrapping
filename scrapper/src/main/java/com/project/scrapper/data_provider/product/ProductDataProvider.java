package com.project.scrapper.data_provider.product;


import com.project.scrapper.domain.Product;
import com.project.scrapper.domain.use_case.WriteProduct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductDataProvider implements WriteProduct {

    private final ProductRepository productRepository;

    public ProductDataProvider(ProductRepository productRepository) {this.productRepository = productRepository;}

    @Override
    public Product saveProduct(Product product) {
        return toDomain(productRepository.saveProduct(toDao(product)));
    }

    private Product toDomain(ProductDao productDao) {
        Product product = new Product();
        product.setDescription(productDao.getDescription());
        product.setImageURL(productDao.getImageURL());
        product.setName(productDao.getName());
        product.setPrice(productDao.getPrice());
        product.setTotalReviews(productDao.getTotalReviews());
        return product;
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
