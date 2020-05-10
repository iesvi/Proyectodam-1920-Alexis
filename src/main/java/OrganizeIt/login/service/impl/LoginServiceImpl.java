package OrganizeIt.login.service.impl;

import OrganizeIt.login.model.User;
import OrganizeIt.login.model.dto.UserDTO;
import OrganizeIt.login.repository.LoginRepository;
import OrganizeIt.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity registUser(User user){
        if (repository.findUserByName(user.getName())!=null){
            repository.insert(user);
            return ResponseEntity.ok().build();
        }else return ResponseEntity.notFound().build();
    }

}
