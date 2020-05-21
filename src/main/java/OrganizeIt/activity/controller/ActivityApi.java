package OrganizeIt.activity.controller;

import OrganizeIt.activity.model.Activity;
import OrganizeIt.activity.controller.constant.EndPointUris;
import OrganizeIt.activity.model.Fecha;
import OrganizeIt.activity.model.Lugar;
import OrganizeIt.activity.model.dto.ActivityDTO;
import OrganizeIt.activity.model.dto.FechaDTO;
import OrganizeIt.activity.model.dto.LugarDTO;
import OrganizeIt.activity.model.dto.UserDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(EndPointUris.API+EndPointUris.V1)
public interface ActivityApi {

/*
    1- Crear nueva actividad.
    2- Subir imagen.
    3- Buscar actividad por nombre.
    4- Agregar nuevo asistente.
    5- Proponer detalles.
    6- Votar detalles
    7- Obener lista de actividades.
    8- Obtener actividad por id.
*/


@PostMapping(value=EndPointUris.IMG, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
ResponseEntity<String> uploadImage(HttpServletRequest request) throws IOException, ServletException;


@PostMapping(EndPointUris.NEW)
ResponseEntity newActivity (@RequestBody(required = false) ActivityDTO activityDTO);

@GetMapping(EndPointUris.GET)
ResponseEntity<List<Activity>> getActivity (@PathVariable("title") String title);

@PostMapping(EndPointUris.ADDUser)
ResponseEntity addUser(@RequestBody String id, @RequestBody UserDTO userDTO);

@PostMapping(EndPointUris.ADDDate)
ResponseEntity addDetail(@RequestBody FechaDTO fechaDTO);


//Agregar el id de la actividad
@PostMapping(EndPointUris.ADDPlace)
ResponseEntity addDetail(@RequestBody LugarDTO lugarDTO);

@GetMapping()
ResponseEntity<List<Activity>> getActivityList();


@GetMapping(EndPointUris.GetById)
ResponseEntity<Activity> getActivityById (@PathVariable("id") String id);
}