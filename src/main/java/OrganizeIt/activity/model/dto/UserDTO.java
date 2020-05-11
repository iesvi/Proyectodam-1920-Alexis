package OrganizeIt.activity.model.dto;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document
public class UserDTO {
    @Id
    private String name;
    private String password;
}
