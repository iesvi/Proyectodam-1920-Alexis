package OrganizeIt.login.service.impl;

import OrganizeIt.login.model.User;
import OrganizeIt.login.model.dto.UserDTO;
import OrganizeIt.login.repository.LoginRepository;
import OrganizeIt.login.service.LoginService;
import OrganizeIt.login.service.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepository repository;

    @Override
    public ResponseEntity validateUser(User user) {

      Optional<User> user1 = Optional.ofNullable(repository.findUserByName(user.getName()));

      if (user1.isPresent() && user1.get().getPassword().equals(user.getPassword())){
          return ResponseEntity.ok().build();
        }else return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<String> registUser(User user){

        if( (repository.findUserByEmail(user.getEmail())==null)){

            if( (repository.findUserByName(user.getName())==null)){
                repository.insert(user);
                return ResponseEntity.ok().build();

            }else return new ResponseEntity<>("name", HttpStatus.valueOf(403));
        }else return new ResponseEntity<>("email", HttpStatus.valueOf(403));
    }

    @Override
    public ResponseEntity<List<UserDTO>> findUsersByEmail(List<String> usersEmails){

        ArrayList<UserDTO> users = new ArrayList<>();

        for (String s : usersEmails){
            if (!s.isEmpty()) {
                users.add(Converter.converterUserToUserDTO(repository.findUserByEmail(s)));
            }
        }
        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<UserDTO> getUserByName(String name) {
        return ResponseEntity.ok(Converter.converterUserToUserDTO(repository.findUserByName(name)));
    }

    @Override
    public ResponseEntity userExists(String name) {

        User tmp = repository.findUserByName(name);

        if (tmp!=null) return ResponseEntity.ok().build();
        else return ResponseEntity.notFound().build();
    }

}
