package OrganizeIt.login.controller;

import OrganizeIt.login.model.User;
import OrganizeIt.login.controller.constant.EndPointUris;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping(EndPointUris.API+EndPointUris.V1)
public interface LoginApi {

/*
    1- Registar nuevo usuario.
    2- Comprobar credenciales.
    3- Obtener usuario a partir de email. (lo consume microservicio activity)
*/

@PostMapping(EndPointUris.LOGIN)
ResponseEntity validateUser(@RequestBody User user);

@PostMapping(EndPointUris.REGIST)
ResponseEntity registUser(@RequestBody User user);


}