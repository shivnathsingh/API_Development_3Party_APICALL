package ProductService.demo.dtos;

import ProductService.demo.models.Product;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FakeStoreCreateProductResponseDto {

    private Long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;


    public static Product toProduct(FakeStoreCreateProductResponseDto fk)
    {
        Product product=new Product();
        product.setId(fk.getId());
        product.setTitle(fk.getTitle());
        product.setPrice(fk.getPrice());
        product.setImageUrl(fk.getImage());
        product.setDescription(fk.getDescription());
        product.setCategoryName(fk.getCategory());
        return product;
    }

    public static FakeStoreCreateProductResponseDto toFakeStore(Product product)
    {
        FakeStoreCreateProductResponseDto fkresponse=new FakeStoreCreateProductResponseDto();
        fkresponse.setTitle(product.getTitle());
        fkresponse.setCategory(product.getCategoryName());
        fkresponse.setDescription(product.getDescription());
        fkresponse.setPrice(product.getPrice());
        fkresponse.setCategory(product.getCategoryName());
        return fkresponse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
