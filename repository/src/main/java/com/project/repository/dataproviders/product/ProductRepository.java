package com.project.repository.dataproviders.product;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductDao, Long> {

}
