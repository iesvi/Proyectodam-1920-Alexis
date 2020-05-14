package OrganizeIt.activity.controller;

import OrganizeIt.activity.model.Activity;
import OrganizeIt.activity.controller.constant.EndPointUris;
import OrganizeIt.activity.model.Fecha;
import OrganizeIt.activity.model.Lugar;
import OrganizeIt.activity.model.dto.FechaDTO;
import OrganizeIt.activity.model.dto.LugarDTO;
import OrganizeIt.activity.model.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(EndPointUris.API+EndPointUris.V1)
public interface ActivityApi {

/*
    1- Crear nueva actividad.
    2- Buscar actividad por nombre.
    3- Agregar nuevo asistente.
    4- Proponer detalles.
    5- Votar detalles
*/

@PostMapping(path = EndPointUris.GET)
ResponseEntity newActivity(
        @RequestParam("id") String id,
        @RequestParam("titulo") String titulo,
        @RequestParam("descripcion") String descripcion,
        @RequestParam("participativa") boolean participativa,
        @RequestParam("publica") boolean publica,
        @RequestParam("fechas") Fecha[] fechas,
        @RequestParam("lugar") Lugar[] lugar,
        @RequestParam("fechaLimite") Date fechaLimite,
        @RequestParam("usuarios") UserDTO[] usuarios
);

@PostMapping(EndPointUris.NEW)
ResponseEntity newActivity (@RequestBody(required = false)  Activity activity);


@GetMapping(EndPointUris.GET)
ResponseEntity getActivity (@PathVariable("title") String title);

@PostMapping(EndPointUris.ADDUser)
ResponseEntity addUser(@RequestBody String id, @RequestBody UserDTO userDTO);

@PostMapping(EndPointUris.ADDDate)
ResponseEntity addDetail(@RequestBody FechaDTO fechaDTO);

//Agregar el id de la actividad
@PostMapping(EndPointUris.ADDPlace)
ResponseEntity addDetail(@RequestBody LugarDTO lugarDTO);


}