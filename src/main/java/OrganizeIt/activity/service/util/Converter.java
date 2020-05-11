package OrganizeIt.activity.service.util;
import OrganizeIt.activity.model.Fecha;
import OrganizeIt.activity.model.Lugar;
import OrganizeIt.activity.model.dto.FechaDTO;
import OrganizeIt.activity.model.dto.LugarDTO;
import org.springframework.stereotype.Component;

public class Converter {

    public static Lugar convertLugarDtoToLugar(LugarDTO lugarDTO){
        return Lugar.builder().place(lugarDTO.getPlace()).votes(lugarDTO.getVotes()).build();
    }

    public static Fecha convertFechaDtoToFecha(FechaDTO fechaDTO){
        return Fecha.builder().date(fechaDTO.getDate()).votes(fechaDTO.getVotes()).build();
    }

}
