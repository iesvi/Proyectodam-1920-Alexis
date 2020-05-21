package OrganizeIt.activity.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Lugar implements Serializable {
    private String place;
    private int votos;

    @Override
    public boolean equals(Object o) {
        if (this.place.equals( ((Lugar)o).getPlace() ) ) return true;
        else return false;
    }
}
