package OrganizeIt.login.controller.impl;

import OrganizeIt.login.controller.LoginApi;
import OrganizeIt.login.model.User;
import OrganizeIt.login.model.dto.UserDTO;
import OrganizeIt.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public ResponseEntity<List<UserDTO>> findUsersByEmail(List<String> usersEmails) {


        if(!usersEmails.isEmpty()){
            return ls.findUsersByEmail(usersEmails);
        }
        else{
            System.out.println("entra");
            List<UserDTO> tmp = new ArrayList<>();
            return ResponseEntity.ok(tmp);
        }

    }

    @Override
    public ResponseEntity<UserDTO> getUserByName(String nombre) {
        return ls.getUserByName(nombre);
    }

    @Override
    public ResponseEntity userExists(String nombre) {
        return ls.userExists(nombre);
    }
}
