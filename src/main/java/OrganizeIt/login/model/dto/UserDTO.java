package OrganizeIt.login.model.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;


@Builder
@Getter
@Setter

public class UserDTO {
    String email;
}
