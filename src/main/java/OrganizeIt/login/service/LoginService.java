package OrganizeIt.login.service;

import OrganizeIt.login.model.User;
import OrganizeIt.login.model.dto.UserDTO;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface LoginService {
    ResponseEntity validateUser(User user);
    ResponseEntity<String> registUser(User user);
    ResponseEntity<List<UserDTO>> findUsersByEmail(List<String> usersEmails);
    ResponseEntity<UserDTO> getUserByName(String name);
    ResponseEntity userExists (String name);
}
