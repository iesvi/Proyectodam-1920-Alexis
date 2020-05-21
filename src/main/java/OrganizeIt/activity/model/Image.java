package OrganizeIt.activity.model;

import lombok.*;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor

@Document
public class Image {

    @Id
    @Field
    private String id;
    @Field
    private Binary file;
}
