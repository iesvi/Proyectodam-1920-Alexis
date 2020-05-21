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

@Document
public class ActivityDTO implements Serializable {

    @Id
    private String id;
    private String titulo;
    private String descripcion;
    private boolean participativa;
    private boolean publica;
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, pattern="dd-MM-yyyy HH:mm:ss")
    private ArrayList<String> fechas;
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private ArrayList<String> lugar;
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private ArrayList<String> usuarios;
    private String imgId;
    private Date fechaLimite;

}