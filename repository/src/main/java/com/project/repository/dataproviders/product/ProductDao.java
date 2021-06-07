package com.project.repository.dataproviders.product;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(value = "product")
@Data
@NoArgsConstructor
public class ProductDao {

    @Id
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
        if (!(o instanceof ProductDao)) return false;
        ProductDao that = (ProductDao) o;
        return getTotalReviews() == that.getTotalReviews() &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getImageURL(), that.getImageURL()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public String toString() {
        return "ProductDao{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", totalReviews=" + totalReviews +
                '}';
    }

}
