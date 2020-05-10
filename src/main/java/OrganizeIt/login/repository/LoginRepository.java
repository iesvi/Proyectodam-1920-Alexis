package OrganizeIt.login.repository;

import OrganizeIt.login.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends MongoRepository<User, String> {
    User findUserByName(String name);

}
