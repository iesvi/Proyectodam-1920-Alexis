package OrganizeIt.alerta.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

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
        return place.equals( ((Lugar)o).getPlace() );
    }
}
