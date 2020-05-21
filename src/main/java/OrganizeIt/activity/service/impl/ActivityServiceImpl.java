package OrganizeIt.activity.service.impl;

import OrganizeIt.activity.model.Activity;
import OrganizeIt.activity.model.Fecha;
import OrganizeIt.activity.model.Image;
import OrganizeIt.activity.model.Lugar;
import OrganizeIt.activity.model.dto.FechaDTO;
import OrganizeIt.activity.model.dto.LugarDTO;
import OrganizeIt.activity.model.dto.UserDTO;
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
import sun.nio.ch.IOUtil;
import com.mongodb.client.model.Aggregates;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.mongodb.client.model.Aggregates.sample;

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
        Activity activityTpm = activity;
            if (activity.getLugar() == null){
            activity.setLugar(new ArrayList<>());
        }

        if (activity.getFechas() == null){
            activity.setFechas(new ArrayList<>());
        }

        return ResponseEntity.ok(activiyRepository.insert(activity));
    }

    @Override
    public ResponseEntity<String> uploadImage(Part imageFile) throws IOException {
        Image image = new Image();
        //Path path = Paths.get(imageFile.toURI());
        //byte[] x = Files.readAllBytes();
        image.setFile(new Binary(BsonBinarySubType.BINARY, IOUtils.toByteArray(imageFile.getInputStream())));
        return ResponseEntity.ok(imageRepository.insert(image).getId());

    }

    @Override
    public ResponseEntity<List<Activity>> getActivity(String title) {


        return ResponseEntity.ok(activiyRepository.findActivityByTituloLike(title));
    }

    @Override
    public ResponseEntity addUser(UserDTO userDTO, String id) {
        Activity tmpActivity = activiyRepository.findById(id).get();
        tmpActivity.getUsuarios().add(userDTO);
        activiyRepository.save(tmpActivity);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity addDetail(FechaDTO fechaDTO) {
        Fecha fecha = Converter.convertFechaDtoToFecha(fechaDTO);
        String id = fechaDTO.getActivityId();

        Activity tmpActivity = activiyRepository.findById(id).get();

        if (tmpActivity.getFechas().contains(fecha)){

            int idx = tmpActivity.getFechas().indexOf(fecha);

            tmpActivity.getFechas().get(idx).setVotes(

                    tmpActivity.getFechas().get(idx).getVotes()+fecha.getVotes());
        }else   tmpActivity.getFechas().add(fecha);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity addDetail(LugarDTO lugarDTO) {

        Lugar lugar = Converter.convertLugarDtoToLugar(lugarDTO);
        String id = lugarDTO.getActivityId();

        Activity tmpActivity = activiyRepository.findById(id).get();

        if (tmpActivity.getLugar().contains(lugar)){
            int idx = tmpActivity.getLugar().indexOf(lugar);

            tmpActivity.getLugar().get(idx).setVotos(
                    tmpActivity.getLugar().get(idx).getVotos()+lugar.getVotos());

        }else   tmpActivity.getLugar().add(lugar);

        activiyRepository.save(tmpActivity);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<Activity>> getActivityList() {
        return ResponseEntity.ok(activiyRepository.findAll());
    }

    @Override
    public ResponseEntity<Activity> getActivityById(String id) {
        return ResponseEntity.ok(activiyRepository.findById(id).get());
    }


}