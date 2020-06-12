package OrganizeIt.alerta.repository;


import OrganizeIt.alerta.model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActiviyRepository extends MongoRepository<Activity, String> {




}
