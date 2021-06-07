package com.project.repository.domain.product_usecase;

import com.project.repository.domain.Product;

import java.util.List;

public class ProductUseCase {


    private final ReadProduct readProduct;
    private final WriteProduct writeProduct;

    public ProductUseCase(ReadProduct readProduct, WriteProduct writeProduct) {
        this.readProduct = readProduct;
        this.writeProduct = writeProduct;
    }

    public List<Product> findAll() {
        return readProduct.findAll();
    }

    public Product saveProduct(Product product) {
        validate(product);
        return writeProduct.saveProduct(product);
    }

    private void validate(Product product) {
        nullAndEmptyCheck(product.getDescription(), "Description");
        nullAndEmptyCheck(product.getImageURL(), "image URL");
        nullAndEmptyCheck(product.getName(), "product name");
        nullAndEmptyCheck(product.getPrice(), "price");
        nullAndEmptyCheck(product.getTotalReviews(), "total reviews");
    }

    private void nullAndEmptyCheck(String value, String errMessage) {
        if (value == null || value.isEmpty())
            throw new NullPointerException(errMessage);
    }


    private void nullAndEmptyCheck(long value, String errMessage) {
        if (value < 0)
            throw new NullPointerException(errMessage);
    }

}
