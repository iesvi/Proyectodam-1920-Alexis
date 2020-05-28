package OrganizeIt.activity.controller;

import OrganizeIt.activity.model.Activity;
import OrganizeIt.activity.controller.constant.EndPointUris;
import OrganizeIt.activity.model.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(EndPointUris.API+EndPointUris.V1)
public interface ActivityApi {

/*
    1- Crear nueva actividad.
    2- Subir imagen.
    3- Buscar actividad por nombre.
    4- Agregar nuevo asistente.
    5- Eliminar asistente.
    6- Proponer detalles.
    7- Votar detalles
    8- Obener lista de actividades.
    9- Obtener actividad por id.
*/


@PostMapping(value=EndPointUris.IMG, consumes = "multipart/form-data")
ResponseEntity<String> uploadImage(@RequestPart(value = "file") MultipartFile request) throws IOException, ServletException;


@PostMapping(EndPointUris.NEW)
ResponseEntity newActivity (@RequestBody(required = false) ActivityDTOStringed activityDTOStringed);

@GetMapping(EndPointUris.GET)
ResponseEntity<List<Activity>> getActivity (@PathVariable("title") String title);

@PostMapping(EndPointUris.ADDUser)
ResponseEntity addUser(@RequestBody String data);


@PostMapping(EndPointUris.RemoveUser)
ResponseEntity removeUser (@RequestBody String data);


@PostMapping(EndPointUris.ADDDate)
ResponseEntity addDetail(@RequestBody FechaDTO[] fechasDTOList);


//Agregar el id de la actividad
@PostMapping(EndPointUris.ADDPlace)
ResponseEntity addDetail(@RequestBody LugarDTO[] lugaresDTOList);

@GetMapping()
ResponseEntity<List<Activity>> getActivityList();


@GetMapping(EndPointUris.GetById)
ResponseEntity<ActivityDTO> getActivityById (@PathVariable("id") String id);




@GetMapping(EndPointUris.DenieInvitation)
ResponseEntity removeUserInvitationByName (@PathVariable("id") String id, @PathVariable("name") String name);


@GetMapping(EndPointUris.DeleteById)
ResponseEntity removeById (@PathVariable("id") String id);


@GetMapping(EndPointUris.GetByUserInvited)
ResponseEntity<List<Activity>> getActivityByUserIsInvited (@PathVariable("email") String email);

@GetMapping(EndPointUris.GetByUserAssists)
ResponseEntity<List<Activity>> getActivityByUserAssist (@PathVariable("email") String email);

@GetMapping(EndPointUris.GetByUserIsCreator)
ResponseEntity<List<Activity>> getActivityByUserIsCreator (@PathVariable("email") String email);









}