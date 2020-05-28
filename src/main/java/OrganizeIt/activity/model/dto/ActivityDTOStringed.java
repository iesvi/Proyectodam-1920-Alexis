package OrganizeIt.activity.model.dto;

import OrganizeIt.activity.model.Fecha;
import OrganizeIt.activity.model.Lugar;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

//Clase que envía el cliente (react)

public class ActivityDTOStringed implements Serializable {

    private String id;
    private String titulo;
    private String descripcion;
    private String creador;
    private boolean participativa;
    private boolean publica;
    private String fechas;
    private String lugar;
    private String usuarios;
    private String usuariosInvitados;
    private String imgId;
    private String fechaLimite;

}