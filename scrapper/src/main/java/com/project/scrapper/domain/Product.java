package com.project.scrapper.domain;

import lombok.Data;

@Data
public class Product {

    private String name;

    private String imageURL;

    private String description;

    private String price;

    private long totalReviews = 0;
}
