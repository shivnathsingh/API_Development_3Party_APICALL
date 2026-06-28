package ProductService.demo.SingleTable;

import jakarta.persistence.*;

@Entity(name="js_instructor")
@DiscriminatorValue(value = "Instructor")
public class Instructor extends User{

    private int yoe;
    private String companyName;

}
