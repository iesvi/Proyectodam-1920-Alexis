package OrganizeIt.login.service.impl;

import OrganizeIt.login.model.User;
import OrganizeIt.login.repository.LoginRepository;
import OrganizeIt.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    RestTemplate restTemplate;

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

        System.out.println("entra");
        if( (repository.findUserByEmail(user.getEmail())!=null)){

            if( (repository.findUserByName(user.getName())!=null)){
                repository.insert(user);
                return ResponseEntity.ok().build();

            }else return new ResponseEntity<>("name", HttpStatus.valueOf(403));
        }else return new ResponseEntity<>("email", HttpStatus.valueOf(403));
    }
}
