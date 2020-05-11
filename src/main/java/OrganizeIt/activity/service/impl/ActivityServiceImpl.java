package OrganizeIt.activity.service.impl;

import OrganizeIt.activity.model.Activity;
import OrganizeIt.activity.model.Fecha;
import OrganizeIt.activity.model.Lugar;
import OrganizeIt.activity.model.dto.FechaDTO;
import OrganizeIt.activity.model.dto.LugarDTO;
import OrganizeIt.activity.model.dto.UserDTO;
import OrganizeIt.activity.repository.ActiviyRepository;
import OrganizeIt.activity.service.ActivityService;
import OrganizeIt.activity.service.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ActiviyRepository repository;


    @Override
    public ResponseEntity newActivity(Activity activity) {
        Activity activityTpm = activity;
        if (activity.getLugar() == null){
            activity.setLugar(new ArrayList<>());
        }

        if (activity.getFechas() == null){
            activity.setFechas(new ArrayList<>());
        }

        return ResponseEntity.ok(repository.insert(activity));
    }

    @Override
    public ResponseEntity<List<Activity>> getActivity(String title) {

        repository.findAll().stream().forEach(e -> System.out.println(e));
        return ResponseEntity.ok(repository.findActivityByTituloLike(title));
    }

    @Override
    public ResponseEntity addUser(UserDTO userDTO, String id) {
        Activity tmpActivity = repository.findById(id).get();
        tmpActivity.getUsuarios().add(userDTO);
        repository.save(tmpActivity);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity addDetail(FechaDTO fechaDTO) {
        Fecha fecha = Converter.convertFechaDtoToFecha(fechaDTO);
        String id = fechaDTO.getActivityId();

        Activity tmpActivity = repository.findById(id).get();

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

        Activity tmpActivity = repository.findById(id).get();

        if (tmpActivity.getLugar().contains(lugar)){
            int idx = tmpActivity.getLugar().indexOf(lugar);

            tmpActivity.getLugar().get(idx).setVotes(
                    tmpActivity.getLugar().get(idx).getVotes()+lugar.getVotes());

        }else   tmpActivity.getLugar().add(lugar);

        repository.save(tmpActivity);
        return ResponseEntity.ok().build();
    }


}