package UserAuthService.models;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@MappedSuperclass
public class BaseModel {

    private UUID id;
    private Date createdAt;
    private Date lastModifiedAt;
    private  State state;
}
