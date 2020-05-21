package OrganizeIt.activity.repository;

import OrganizeIt.activity.model.Activity;
import OrganizeIt.activity.model.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends MongoRepository<Image, String> {
}
