package OrganizeIt.activity.controller.impl;

import OrganizeIt.activity.controller.ActivityApi;
import OrganizeIt.activity.model.Activity;
import OrganizeIt.activity.model.Fecha;
import OrganizeIt.activity.model.Lugar;
import OrganizeIt.activity.model.dto.ActivityDTO;
import OrganizeIt.activity.model.dto.FechaDTO;
import OrganizeIt.activity.model.dto.LugarDTO;
import OrganizeIt.activity.model.dto.UserDTO;
import OrganizeIt.activity.service.ActivityService;
import OrganizeIt.activity.service.util.Converter;
import org.apache.commons.io.FileUtils;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
public class ActivityController implements ActivityApi {
    @Autowired
    private ActivityService as;


   /* @Override
    public ResponseEntity<String> uploadImage(MultipartFile imageData) {
        try {
            return as.uploadImage(imageData);
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }*/

    @Override
    public ResponseEntity<String> uploadImage(HttpServletRequest request) throws IOException, ServletException {

        try {
            Collection<Part> parts = request.getParts();
            parts.forEach(e -> System.out.println(e.getName()));
            ArrayList<Part> partsList = new ArrayList<Part>(parts);
            return as.uploadImage(partsList.get(0));
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity newActivity(ActivityDTO activityDTO) {
        return as.newActivity(Converter.converActivityDtoToActivity(activityDTO));
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

    @Override
    public ResponseEntity<List<Activity>> getActivityList() {
        return as.getActivityList();
    }

    @Override
    public ResponseEntity<Activity> getActivityById(String id) {
        return as.getActivityById(id);
    }

}
