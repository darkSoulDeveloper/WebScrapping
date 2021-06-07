package com.project.scrapper.configuration;

import com.project.scrapper.data_provider.product.ProductDataProvider;
import com.project.scrapper.data_provider.product.ProductRepository;
import com.project.scrapper.domain.use_case.ProductUseCase;
import com.project.scrapper.domain.use_case.WriteProduct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScrapperConfiguration {

    @Bean(name = "productUseCase")
    public ProductUseCase getProductUseCase( WriteProduct writeProduct) {
        return new ProductUseCase(writeProduct);
    }

    @Bean(name = "productDataProvider")
    public ProductDataProvider getProductDataProvider(ProductRepository repository) {
        return new ProductDataProvider(repository);
    }
}
