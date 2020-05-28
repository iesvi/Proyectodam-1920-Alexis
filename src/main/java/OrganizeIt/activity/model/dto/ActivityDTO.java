package OrganizeIt.activity.model.dto;

import OrganizeIt.activity.model.Fecha;
import OrganizeIt.activity.model.Lugar;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ActivityDTO implements Serializable {

    private String id;
    private String titulo;
    private String descripcion;
    private String creador;
    private boolean participativa;
    private boolean publica;
    private List<Fecha> fechas;
    private List<Lugar> lugar;
    private String imgId;
    private List<UserDTO> usuarios;
    private List<String> usuariosInvitados;
    private List<String> usuariosParticipanLugar;
    private List<String> usuariosParticipanFecha;
    private Date fechaLimite;

}
