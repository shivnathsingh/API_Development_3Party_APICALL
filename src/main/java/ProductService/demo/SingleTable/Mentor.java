package ProductService.demo.SingleTable;


import jakarta.persistence.*;

@Entity(name="js_mentor")
@DiscriminatorValue(value = "Mentor")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Mentor extends User{

    private long rating;

}
