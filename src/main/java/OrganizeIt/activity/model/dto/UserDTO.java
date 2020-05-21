package OrganizeIt.activity.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Document
@AllArgsConstructor
public class UserDTO implements Serializable {
    @Id
    private String email;
}
