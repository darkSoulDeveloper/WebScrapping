package com.project.scrapper.domain.use_case;


import com.project.scrapper.domain.Product;

public class ProductUseCase {


    private final WriteProduct writeProduct;

    public ProductUseCase(WriteProduct writeProduct) {
        this.writeProduct = writeProduct;
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
