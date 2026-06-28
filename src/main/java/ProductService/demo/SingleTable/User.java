package ProductService.demo.SingleTable;


import jakarta.persistence.*;

@Entity(name = "st_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Role",discriminatorType = DiscriminatorType.STRING)
public class User {
    @Id
    private int id;
    private String name;
}
