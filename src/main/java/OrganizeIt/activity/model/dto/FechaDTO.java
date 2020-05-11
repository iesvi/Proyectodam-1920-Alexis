package OrganizeIt.activity.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Setter
@Getter

@Document
public class FechaDTO {
    private Date date;
    private int votes;
    private String activityId;
}
