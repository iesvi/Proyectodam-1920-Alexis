package OrganizeIt.activity.service.impl;

import OrganizeIt.activity.model.Activity;
import OrganizeIt.activity.model.Fecha;
import OrganizeIt.activity.model.Image;
import OrganizeIt.activity.model.Lugar;
import OrganizeIt.activity.model.dto.*;
import OrganizeIt.activity.repository.ActiviyRepository;
import OrganizeIt.activity.repository.ImageRepository;
import OrganizeIt.activity.service.ActivityService;
import OrganizeIt.activity.service.util.Converter;
import org.apache.commons.io.IOUtils;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    ActiviyRepository activiyRepository;


    @Override
    public ResponseEntity newActivity(Activity activity) {
        return ResponseEntity.ok(activiyRepository.insert(activity));
    }

    @Override
    public ResponseEntity<String> uploadImage(MultipartFile imageFile) throws IOException {
        Image image = new Image();
        image.setFile(new Binary(BsonBinarySubType.BINARY, IOUtils.toByteArray(imageFile.getInputStream())));
        return ResponseEntity.ok(imageRepository.insert(image).getId());

    }

    @Override
    public ResponseEntity<List<Activity>> getActivity(String title) {
        return ResponseEntity.ok(activiyRepository.findActivityByTituloLike(title));
    }

    @Override
    public ResponseEntity addUser(String dataRequest) {

        try{
            String data = URLDecoder.decode(dataRequest,"UTF-8");
            String userEmail = data.substring(0,data.indexOf(","));
            String id = data.substring(data.indexOf(",")+1, data.length()-1);


            Activity tmpActivity = activiyRepository.findById(id).get();
            tmpActivity.getUsuarios().add(userEmail);
            activiyRepository.save(tmpActivity);

            return ResponseEntity.ok().build();

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity removeUser(String dataRequest) {


        try{
            String data = URLDecoder.decode(dataRequest,"UTF-8");
            String userEmail = data.substring(0,data.indexOf(","));
            String id = data.substring(data.indexOf(",")+1, data.length()-1);


            Activity tmpActivity = activiyRepository.findById(id).get();
            tmpActivity.getUsuarios().remove(userEmail);
            activiyRepository.save(tmpActivity);

            return ResponseEntity.ok().build();

        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity addDetail(FechaDTO[] fechasDTO) {
        List<FechaDTO> fechaDTO = Arrays.asList(fechasDTO);


        String id = fechaDTO.get(0).getActivityId();
        Activity tmpActivity = activiyRepository.findById(id).get();

        for(FechaDTO f : fechaDTO) {
            Fecha fecha = Converter.convertFechaDtoToFecha(f);

            if (tmpActivity.getFechas().contains(fecha)){
                int idx = tmpActivity.getFechas().indexOf(fecha);
                tmpActivity.getFechas().get(idx).setVotes(
                        tmpActivity.getFechas().get(idx).getVotes()+1);

            }else   tmpActivity.getFechas().add(fecha);
     }

        tmpActivity.getUsuariosParticipanFecha().add(fechaDTO.get(0).getUserEmail());

            return ResponseEntity.ok(activiyRepository.save(tmpActivity));
    }

    @Override
    public ResponseEntity addDetail(LugarDTO[] lugaresDTOList) {
        List<LugarDTO> lugares = Arrays.asList(lugaresDTOList);

        String id = lugares.get(0).getActivityId();
        Activity tmpActivity = activiyRepository.findById(id).get();

        if(!lugares.get(0).getPlace().isEmpty()) {
            for (LugarDTO l : lugares) {
                Lugar lugar = Converter.convertLugarDtoToLugar(l);

                if (tmpActivity.getLugar().contains(lugar)) {
                    int idx = tmpActivity.getLugar().indexOf(lugar);

                    tmpActivity.getLugar().get(idx).setVotos(
                            tmpActivity.getLugar().get(idx).getVotos() + lugar.getVotos());
                } else tmpActivity.getLugar().add(lugar);
            }
        }

        tmpActivity.getUsuariosParticipanLugar().add(lugares.get(0).getUserEmail());

        activiyRepository.save(tmpActivity);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<Activity>> getActivityList() {

        return ResponseEntity.ok(activiyRepository.findByPublicaIsTrue());
    }

    @Override
    public ResponseEntity<ActivityDTO> getActivityById(String id) {

        Activity activityTmp = activiyRepository.findById(id).get();

        List<UserDTO> usersDTO = Arrays.asList(
            Objects.requireNonNull(
                restTemplate.postForEntity(
                "http://localhost:8082/api/v1/user", activityTmp.getUsuarios(), UserDTO[].class).getBody()));

        return ResponseEntity.ok(Converter.convertActivityToActivityDTO(activityTmp,usersDTO));
    }

    @Override
    public ResponseEntity removeById(String id) {

        Activity tmp = activiyRepository.findById(id).get();
        activiyRepository.delete(tmp);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<Activity>> findByUserAsisst(String email) {
       return ResponseEntity.ok(activiyRepository.findByUsuariosContaining(email));
    }

    @Override
    public ResponseEntity<List<Activity>> findByUserIsCreator(String email) {
        return ResponseEntity.ok(activiyRepository.findActivityByCreador(email));
    }

    @Override
    public ResponseEntity<List<Activity>> findByUserIsIvited(String email) {
        return ResponseEntity.ok(activiyRepository.findByUsuariosInvitadosContaining(email));
    }

    @Override
    public ResponseEntity removeUserInvitationByName(String id, String name) {
        Activity tmp = activiyRepository.findById(id).get();

        tmp.getUsuariosInvitados().remove(name);
        activiyRepository.save(tmp);
        return ResponseEntity.ok().build();
    }


}