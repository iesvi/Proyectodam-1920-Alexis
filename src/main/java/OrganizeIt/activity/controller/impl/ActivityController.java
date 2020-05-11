package OrganizeIt.activity.controller.impl;

import OrganizeIt.activity.controller.ActivityApi;
import OrganizeIt.activity.model.Activity;
import OrganizeIt.activity.model.Fecha;
import OrganizeIt.activity.model.Lugar;
import OrganizeIt.activity.model.dto.FechaDTO;
import OrganizeIt.activity.model.dto.LugarDTO;
import OrganizeIt.activity.model.dto.UserDTO;
import OrganizeIt.activity.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActivityController implements ActivityApi {
    @Autowired
    private ActivityService as;

    @Override
    public ResponseEntity newActivity(Activity activity) {
        return as.newActivity(activity);
    }

    @Override
    public ResponseEntity<List<Activity>> getActivity(String title) {
        return as.getActivity(title);
    }

    @Override
    public ResponseEntity addUser(String id, UserDTO userDTO) {
        return as.addUser(userDTO,id);
    }

    @Override
    public ResponseEntity addDetail(LugarDTO lugarDTO) {
        return as.addDetail(lugarDTO);
    }

    @Override
    public ResponseEntity addDetail(FechaDTO fechaDTO) {
        return as.addDetail(fechaDTO);
    }

}
