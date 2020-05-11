package OrganizeIt.activity.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder

public class Fecha {
    private Date date;
    private int votes;
}
