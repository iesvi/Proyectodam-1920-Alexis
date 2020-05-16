package OrganizeIt.login.service;

import OrganizeIt.login.model.User;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface LoginService {
    ResponseEntity validateUser(User user);
    ResponseEntity<String> registUser(User user);
}