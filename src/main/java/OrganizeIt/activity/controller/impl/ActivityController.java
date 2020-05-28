package OrganizeIt.activity.controller.impl;

import OrganizeIt.activity.controller.ActivityApi;
import OrganizeIt.activity.model.Activity;
import OrganizeIt.activity.model.dto.*;
import OrganizeIt.activity.service.ActivityService;
import OrganizeIt.activity.service.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
public class ActivityController implements ActivityApi {
    @Autowired
    private ActivityService as;


    @Override
    public ResponseEntity<String> uploadImage(MultipartFile imageData) {
        try {
            return as.uploadImage(imageData);
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity newActivity(ActivityDTOStringed activityDTOStringed) {
        return as.newActivity(Converter.converActivityDtoStringedToActivity(activityDTOStringed));
    }


    @Override
    public ResponseEntity<List<Activity>> getActivity(String title) {
        return as.getActivity(title);
    }

    @Override
    public ResponseEntity addUser(String data) {
        return as.addUser(data);
    }

    @Override
    public ResponseEntity removeUser(String data) {
        return as.removeUser(data);
    }

    @Override
    public ResponseEntity addDetail(LugarDTO[] lugaresDTOList) {
        return as.addDetail(lugaresDTOList);
    }

    @Override
    public ResponseEntity addDetail(FechaDTO[] fechasDTO) {
        return as.addDetail(fechasDTO);
    }

    @Override
    public ResponseEntity<List<Activity>> getActivityList() {
        return as.getActivityList();
    }

    @Override
    public ResponseEntity<ActivityDTO> getActivityById(String id) {
        return as.getActivityById(id);
    }

    @Override
    public ResponseEntity removeUserInvitationByName(String id, String name) {
        return as.removeUserInvitationByName(id,name);
    }

    @Override
    public ResponseEntity removeById(String id) {
        return as.removeById(id);
    }


    @Override
    public ResponseEntity<List<Activity>> getActivityByUserIsInvited(String email) {
        return as.findByUserIsIvited(email);
    }

    @Override
    public ResponseEntity<List<Activity>> getActivityByUserAssist(String email) {
        return as.findByUserAsisst(email);
    }

    @Override
    public ResponseEntity<List<Activity>> getActivityByUserIsCreator(String email) {
        return as.findByUserIsCreator(email);
    }

}
