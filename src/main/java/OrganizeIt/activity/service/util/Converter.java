package OrganizeIt.activity.service.util;
import OrganizeIt.activity.model.Activity;
import OrganizeIt.activity.model.Fecha;
import OrganizeIt.activity.model.Lugar;
import OrganizeIt.activity.model.dto.*;

import java.util.*;
import java.util.stream.Collectors;

public class Converter {

    public static Lugar convertLugarDtoToLugar(LugarDTO lugarDTO){
        return Lugar.builder().place(lugarDTO.getPlace()).votos(1).build();
    }

    public static Fecha convertFechaDtoToFecha(FechaDTO fechaDTO){
        Fecha tmp = new Fecha(fechaDTO.getDate());
        return tmp;
    }

    public static Activity converActivityDtoStringedToActivity(ActivityDTOStringed activityDTOStringed){

        List<String> fechas = Arrays.asList(activityDTOStringed.getFechas().split(","));
        List<String> usuarios = Arrays.asList(activityDTOStringed.getUsuarios().split(","));
        List<String> usuariosInvitados = Arrays.asList(activityDTOStringed.getUsuariosInvitados().split(","));
        List<String> lugares = Arrays.asList(activityDTOStringed.getLugar().split(","));




        return Activity.builder().id(activityDTOStringed.getId()).descripcion(activityDTOStringed.getDescripcion())
                .fechaLimite(new Date()).participativa(activityDTOStringed.isParticipativa())
                .publica(activityDTOStringed.isPublica()).titulo(activityDTOStringed.getTitulo())
                .fechas(fechas.stream().map(e -> new Fecha(e)).collect(Collectors.toList()))
                .lugar(lugares.stream().map(e -> new Lugar(e,1)).collect(Collectors.toList()))
                .usuarios(usuarios).imgId(activityDTOStringed.getImgId())
                .usuariosParticipanFecha(new ArrayList<>()).usuariosParticipanLugar(new ArrayList<>())
                .creador(activityDTOStringed.getCreador()).usuariosInvitados(usuariosInvitados)
                .build();
    }

    public static ActivityDTO convertActivityToActivityDTO(Activity activity, List<UserDTO> usersDTO){
        return ActivityDTO.builder().descripcion(activity.getDescripcion()).fechaLimite(activity.getFechaLimite())
                .fechas(activity.getFechas()).id(activity.getId()).imgId(activity.getImgId()).lugar(activity.getLugar())
                .participativa(activity.isParticipativa()).publica(activity.isPublica()).titulo(activity.getTitulo())
                .usuarios(usersDTO).usuariosParticipanFecha(activity.getUsuariosParticipanFecha())
                .usuariosParticipanLugar(activity.getUsuariosParticipanLugar()).creador(activity.getCreador())
                .usuariosInvitados(activity.getUsuariosInvitados())
                .build();
    }

}
