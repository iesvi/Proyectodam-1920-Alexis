package OrganizeIt.activity.repository;

import OrganizeIt.activity.model.Activity;
import OrganizeIt.activity.model.Image;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActiviyRepository extends MongoRepository<Activity, String> {
    List<Activity> findActivityByTituloLike(String titulo);

}
