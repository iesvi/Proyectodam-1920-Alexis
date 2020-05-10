package OrganizeIt.login.service;

import OrganizeIt.login.model.User;
import OrganizeIt.login.model.dto.UserDTO;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface LoginService {
    ResponseEntity validateUser(User user);
    ResponseEntity registUser(User user);
}