package OrganizeIt.activity.service;

import OrganizeIt.activity.model.Activity;
import OrganizeIt.activity.model.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ActivityService {
    ResponseEntity newActivity(Activity activity);
    ResponseEntity<String> uploadImage(MultipartFile image) throws IOException;
    ResponseEntity getActivity (String title);
    ResponseEntity addUser(String data);
    ResponseEntity removeUser(String data);
    ResponseEntity addDetail(FechaDTO[] fechasDTO);
    ResponseEntity addDetail(LugarDTO[] lugaresDTOList);
    ResponseEntity<List<Activity>> getActivityList();
    ResponseEntity<ActivityDTO> getActivityById (String id);
    ResponseEntity removeById (String id);
    ResponseEntity<List<Activity>> findByUserAsisst(String email);
    ResponseEntity<List<Activity>> findByUserIsCreator(String email);
    ResponseEntity<List<Activity>> findByUserIsIvited(String email);
    ResponseEntity removeUserInvitationByName (String id, String name);



}