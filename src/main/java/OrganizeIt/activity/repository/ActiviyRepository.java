package OrganizeIt.activity.repository;

import OrganizeIt.activity.model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActiviyRepository extends MongoRepository<Activity, String> {
    List<Activity>  findActivityByTituloLike(String titulo);

}
