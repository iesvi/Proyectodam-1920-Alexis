package OrganizeIt.activity.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter

@Document
public class LugarDTO {
    private String place;
    private int votes;
    private String activityId;
}
