package OrganizeIt.activity.model;

import OrganizeIt.activity.model.dto.UserDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Document
public class Activity {

    @Id
    private String id;
    private String titulo;
    private boolean participativa;
    private boolean publica;
    private List<Fecha> fechas;
    private List<Lugar> lugar;
    private Date fechaLimite;
    private List<UserDTO> usuarios;

}