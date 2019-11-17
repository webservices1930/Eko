package co.edu.javeriana.eko.controller.usuario;

import co.edu.javeriana.eko.iservice.IUsuarioService;
import co.edu.javeriana.eko.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true")
public class UsuarioServicesController {

    @Autowired
    IUsuarioService usuarioService;

    @RequestMapping(value = "/api/usuarios", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> iniciarSesion(@RequestParam ("correo") String correo, @RequestParam ("contrasena") String contrasena) {
    	System.out.println(correo);
    	System.out.println(contrasena);
        return new ResponseEntity<Usuario>(
                (Usuario) usuarioService.iniciarSesion(correo,contrasena),
                HttpStatus.OK);

    }


}
