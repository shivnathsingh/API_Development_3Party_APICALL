package ProductService.demo.dtos;


import ProductService.demo.models.Product;

// this DTO will convert into the formate fakestore want
public class FakeStoreCreateProductRequestDto {
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;

    public FakeStoreCreateProductRequestDto toFakeStore(Product product)
    {
        FakeStoreCreateProductRequestDto fkrequest=new FakeStoreCreateProductRequestDto();
        fkrequest.setTitle(product.getTitle());
        fkrequest.setCategory(product.getCategoryName());
        fkrequest.setDescription(product.getDescription());
        fkrequest.setPrice(product.getPrice());
        fkrequest.setCategory(product.getCategoryName());
        return fkrequest;
    }

//    Product toProduct(Fa)

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
