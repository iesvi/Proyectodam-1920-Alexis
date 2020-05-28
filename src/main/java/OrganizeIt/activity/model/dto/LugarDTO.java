package OrganizeIt.activity.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Setter
@Getter

public class LugarDTO implements Serializable {
    private String place;
    private String userEmail;
    private String activityId;

    @Override
    public boolean equals(Object o) {
        return this.place.equalsIgnoreCase(((LugarDTO)o).place);
    }
}
