package OrganizeIt.alerta.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

//Clase que se guarda en la base de datos

@Document
public class Activity implements Serializable {
    @Id
    private String id;
    private String titulo;
    private String descripcion;
    private String creador;
    private boolean participativa;
    private boolean publica;
    private List<Fecha> fechas;
    private List<Lugar> lugar;
    private String imgId;
    private List<String> usuarios;
    private List<String> usuariosInvitados;
    private List<String> usuariosParticipanLugar;
    private List<String> usuariosParticipanFecha;
    private Date fechaLimite;
    private boolean finalizada;

}