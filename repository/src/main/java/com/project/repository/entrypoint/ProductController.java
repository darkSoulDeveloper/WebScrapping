package com.project.repository.entrypoint;

import com.project.repository.domain.Product;
import com.project.repository.domain.product_usecase.ProductUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@Controller
@Validated
@RequestMapping("/product")
public class ProductController {

    private final ProductUseCase productUseCase;

    public ProductController(ProductUseCase productUseCase) {this.productUseCase = productUseCase;}

    @PostMapping(path = "/save", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveProduct(@RequestBody Product body) {
        log.info("Entered to save device default attribute for device {}", body);
        Product response;
        try {
            response = productUseCase.saveProduct(body);
            log.info("Response returning {}",response);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.warn("Exception occurred during saving for device attribute {}", e.getLocalizedMessage());
            log.error("Exception ", e);
            return ResponseEntity.badRequest().body(e);
        }
    }


    @GetMapping(path = "/get", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAll() {
        log.info("Entered to receive all the device details");
        try {
            List<Product> response = productUseCase.findAll();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.warn("Exception occurred during saving for device attribute {}", e.getLocalizedMessage());
            log.error("Exception ", e);
            return ResponseEntity.badRequest().body(e);
        }
    }
}
