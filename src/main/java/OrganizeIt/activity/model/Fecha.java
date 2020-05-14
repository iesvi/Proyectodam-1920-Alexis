package OrganizeIt.activity.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder

public class Fecha implements Serializable {
    private Date date;
    private int votes;
}
