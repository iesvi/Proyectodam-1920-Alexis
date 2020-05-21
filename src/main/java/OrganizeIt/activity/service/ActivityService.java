package OrganizeIt.activity.service;

import OrganizeIt.activity.model.Activity;
import OrganizeIt.activity.model.dto.FechaDTO;
import OrganizeIt.activity.model.dto.LugarDTO;
import OrganizeIt.activity.model.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ActivityService {
    ResponseEntity newActivity(Activity activity);
    ResponseEntity<String> uploadImage(Part image) throws IOException;
    ResponseEntity getActivity (String title);
    ResponseEntity addUser(UserDTO userDTO, String id);
    ResponseEntity addDetail(FechaDTO fechaDTO);
    ResponseEntity addDetail(LugarDTO lugarDTO);
    ResponseEntity<List<Activity>> getActivityList();
    ResponseEntity<Activity> getActivityById (String id);



}