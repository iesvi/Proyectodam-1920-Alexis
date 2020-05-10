package OrganizeIt.login.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Document
public class User {

    @Id
    String name;
    String password;
    String email;
}