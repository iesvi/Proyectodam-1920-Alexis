package OrganizeIt.activity.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter

public class FechaDTO implements Serializable {
    private String date;
    private String userEmail;
    private String activityId;
}
