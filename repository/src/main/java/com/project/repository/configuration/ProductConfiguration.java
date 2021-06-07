package com.project.repository.configuration;

import com.project.repository.dataproviders.product.ProductDataProvider;
import com.project.repository.dataproviders.product.ProductRepository;
import com.project.repository.domain.product_usecase.ProductUseCase;
import com.project.repository.domain.product_usecase.ReadProduct;
import com.project.repository.domain.product_usecase.WriteProduct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {

    @Bean(name = "productUseCase")
    public ProductUseCase getProductUseCase(ReadProduct readProduct, WriteProduct writeProduct) {
        return new ProductUseCase(readProduct,writeProduct);
    }

    @Bean(name = "productDataProvider")
    public ProductDataProvider getProductDataProvider(ProductRepository repository) {
        return new ProductDataProvider(repository);
    }

}
