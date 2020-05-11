package OrganizeIt.activity.service;

import OrganizeIt.activity.model.Activity;
import OrganizeIt.activity.model.Fecha;
import OrganizeIt.activity.model.Lugar;
import OrganizeIt.activity.model.dto.FechaDTO;
import OrganizeIt.activity.model.dto.LugarDTO;
import OrganizeIt.activity.model.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface ActivityService {
    ResponseEntity newActivity(Activity activity);
    ResponseEntity getActivity (String title);
    ResponseEntity addUser(UserDTO userDTO, String id);
    ResponseEntity addDetail(FechaDTO fechaDTO);
    ResponseEntity addDetail(LugarDTO lugarDTO);




}