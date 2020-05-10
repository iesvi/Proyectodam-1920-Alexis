package OrganizeIt.login.controller.impl;

import OrganizeIt.login.controller.LoginApi;
import OrganizeIt.login.model.User;
import OrganizeIt.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController implements LoginApi {
    @Autowired
    private LoginService ls;


    @Override
    public ResponseEntity validateUser(User user) {
        return ls.validateUser(user);
    }

    @Override
    public ResponseEntity registUser(User user){
        return ls.registUser(user);
    }

}
