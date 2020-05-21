package OrganizeIt.activity.service.util;
import OrganizeIt.activity.model.Activity;
import OrganizeIt.activity.model.Fecha;
import OrganizeIt.activity.model.Lugar;
import OrganizeIt.activity.model.dto.ActivityDTO;
import OrganizeIt.activity.model.dto.FechaDTO;
import OrganizeIt.activity.model.dto.LugarDTO;
import OrganizeIt.activity.model.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

public class Converter {

    public static Lugar convertLugarDtoToLugar(LugarDTO lugarDTO){
        return Lugar.builder().place(lugarDTO.getPlace()).votos(lugarDTO.getVotes()).build();
    }

    public static Fecha convertFechaDtoToFecha(FechaDTO fechaDTO){
        return Fecha.builder().date(fechaDTO.getDate()).votes(fechaDTO.getVotes()).build();
    }

    public static Activity converActivityDtoToActivity(ActivityDTO activityDTO){

        return Activity.builder().id(activityDTO.getId()).descripcion(activityDTO.getDescripcion())
                .fechaLimite(activityDTO.getFechaLimite()).participativa(activityDTO.isParticipativa())
                .publica(activityDTO.isPublica()).titulo(activityDTO.getTitulo())
                .usuarios(activityDTO.getUsuarios().stream().map(UserDTO::new).collect(Collectors.toList()))
                .lugar(activityDTO.getLugar().stream().map(e -> new Lugar(e, 1)).collect(Collectors.toList()))
                .fechas(activityDTO.getFechas().stream().map(e -> new Fecha(e,1)).collect(Collectors.toList()))
                .imgId(activityDTO.getImgId()).build();
    }
}
