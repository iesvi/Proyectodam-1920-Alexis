package OrganizeIt.login.controller;

import OrganizeIt.login.model.User;
import OrganizeIt.login.controller.constant.EndPointUris;
import OrganizeIt.login.model.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping()
public interface LoginApi {

/*
    1- Registar nuevo usuario.
    2- Comprobar credenciales.
    3- Obtener usuario a partir de email. (lo consume microservicio activity)
    4- Comprobar si usuario existe.
*/
@PostMapping(EndPointUris.LOGIN)
ResponseEntity validateUser(@RequestBody User user);


@PostMapping(EndPointUris.REGIST)
ResponseEntity registUser(@RequestBody User user);

@PostMapping(EndPointUris.USER)
ResponseEntity<List<UserDTO>> findUsersByEmail(@RequestBody List<String> usersEmails);

@GetMapping("{nombre}")
ResponseEntity<UserDTO> getUserByName(@PathVariable("nombre") String nombre);

@GetMapping(EndPointUris.EXISTS)
ResponseEntity userExists(@PathVariable("nombre") String nombre);


}