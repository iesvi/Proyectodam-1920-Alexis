package OrganizeIt.login.service.util;
import OrganizeIt.login.model.User;
import OrganizeIt.login.model.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Converter {


    public static UserDTO converterUserToUserDTO(User user){
        return UserDTO.builder().email(user.getEmail()).name(user.getName()).build();
    }

}
