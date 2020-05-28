package OrganizeIt.activity.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import sun.util.calendar.LocalGregorianCalendar;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

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
