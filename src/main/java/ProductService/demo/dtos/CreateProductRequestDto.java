package ProductService.demo.dtos;

import ProductService.demo.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreateProductRequestDto {

    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String categoryName;

    // Mapper method to map Product Request DTO to Product

    public Product toProduct(CreateProductRequestDto createProductRequestDto)
    {
        Product product= new Product();

        product.setTitle(createProductRequestDto.getTitle());
        product.setDescription(createProductRequestDto.getDescription());
        product.setPrice(createProductRequestDto.getPrice());
        product.setImageUrl(createProductRequestDto.getImageUrl());
        product.setCategoryName(createProductRequestDto.getCategoryName());

        return product;
    }




    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCategoryName() {
        return categoryName;
    }



    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }





}
