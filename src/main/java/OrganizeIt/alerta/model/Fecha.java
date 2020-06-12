package OrganizeIt.alerta.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Fecha implements Serializable {
    private Date date;
    private int votes;


    public Fecha (String s){
        String newS = (s.substring(0,s.indexOf('+'))+"+00");

        this.date = new Date(newS.trim());
        this.votes = 1;
    }

    @Override
    public boolean equals(Object obj) {
        return this.date.equals(((Fecha)obj).getDate());
    }
}
