package ProductService.demo.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product extends BaseModle {


    private String title;
    private String description;
    private double price;
    private String imageUrl;
    @ManyToOne
//    @JsonManagedReference // to tell Json don't go in cycle
    private Category category;
    public static void printProduct(Product product)
    {
        if(product==null)
        {
            System.out.println("In printProduct Method product is passed as null ");
            return ;
        }
        System.out.println("ProductId "+product.getId()
        +" ProductTitle "+product.getTitle()
        +" ProductDescription "+product.getDescription()
        +" ProductPrice "+product.getPrice()
        +" ProductImageUrl "+product.getImageUrl()
        +" ProductCategoryID "+product.getCategory().getId()
        +" ProductCategoryDescription "+product.getCategory().getDescription()
        );
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
