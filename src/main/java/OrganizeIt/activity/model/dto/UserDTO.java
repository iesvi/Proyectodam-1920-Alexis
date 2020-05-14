package OrganizeIt.activity.model.dto;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Document
public class UserDTO implements Serializable {
    @Id
    private String name;
    private String password;
}
