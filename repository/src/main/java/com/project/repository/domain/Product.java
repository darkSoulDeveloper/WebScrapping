package com.project.repository.domain;

import lombok.Data;

import java.util.Objects;

@Data
public class Product {

    private String id;

    private String name;

    private String imageURL;

    private String description;

    private String price;
    private long totalReviews = 0;

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getImageURL(), getDescription(), getPrice(), getTotalReviews());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getTotalReviews() == product.getTotalReviews() &&
                Objects.equals(getId(), product.getId()) &&
                Objects.equals(getName(), product.getName()) &&
                Objects.equals(getImageURL(), product.getImageURL()) &&
                Objects.equals(getDescription(), product.getDescription()) &&
                Objects.equals(getPrice(), product.getPrice());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", totalReviews=" + totalReviews +
                '}';
    }
}
