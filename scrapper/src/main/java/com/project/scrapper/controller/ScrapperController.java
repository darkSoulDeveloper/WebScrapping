package com.project.scrapper.controller;

import com.project.scrapper.domain.Body;
import com.project.scrapper.domain.Product;
import com.project.scrapper.domain.use_case.ProductUseCase;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@Controller
@Validated
@RequestMapping("/fetch")
public class ScrapperController {

    private final ProductUseCase productUseCase;

    public ScrapperController(ProductUseCase productUseCase) {this.productUseCase = productUseCase;}

    @PostMapping(path = "/url", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveProduct(@RequestParam(value = "url") String url) {
        log.info("Entered to fetch for url {}", url);
        Body response = new Body();
        try {
            response.setUrl(url);
            Document doc = Jsoup.connect(url).get();
            Document review;
            Element r = doc.getElementById("reviews-medley-footer");
            if (r != null) {
                review = Jsoup.connect(r.getElementsByTag("a").first().attr("href")).get();
                parseDocument(doc, response, review.getElementById("filter-info-section").getElementsByTag("span"));
            } else
                parseDocument(doc, response, null);
            System.out.println(response);
            response.setProduct(productUseCase.saveProduct(response.getProduct()));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.warn("Exception occurred during saving for device attribute {}", e.getLocalizedMessage());
            log.error("Exception ", e);
            return ResponseEntity.badRequest().body(e);
        }
    }

    private void parseDocument(Document doc, Body response, Elements review) {
        Product product = new Product();
        Element infoTab = doc.getElementById("centerCol");
        Element imageTab = doc.getElementById("leftCol");
        String title = infoTab.getElementById("productTitle").text();
        String description = doc.getElementById("feature-bullets").select("ul.a-unordered-list.a-vertical.a-spacing-mini").text();
        Element price = infoTab.getElementById("price");
        if (price == null) {
            price = infoTab.getElementById("olp_feature_div").getElementsByClass("a-size-base a-color-price").first();
        } else {
            price = price.getElementById("priceblock_ourprice");
            if (price == null)
                price = infoTab.getElementById("priceblock_saleprice");

        }
        String imageUrl = imageTab.getElementById("imgTagWrapperId").getElementsByTag("img").attr("src");
        long totalReview = 0;
        if (review != null)
            totalReview = getNumber(review.text());
        else {
            Element e = infoTab.getElementById("acrCustomerReviewText");
            if (e != null)
                totalReview = getNumber(e.text());
        }
        product.setDescription(description);
        product.setImageURL(imageUrl);
        product.setName(title);
        product.setPrice(price.text());
        product.setTotalReviews(totalReview);
        response.setProduct(product);
    }

    private long getNumber(String text) {
        return Long.parseLong(text.replaceAll("[^\\d.]", ""));
    }
}
