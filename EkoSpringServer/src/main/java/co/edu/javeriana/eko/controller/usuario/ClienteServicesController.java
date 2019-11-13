package co.edu.javeriana.eko.controller.usuario;

import co.edu.javeriana.eko.iservice.IUsuarioService;
import co.edu.javeriana.eko.model.usuario.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true")
public class ClienteServicesController {

    @Autowired
    IUsuarioService usuarioService;


    @RequestMapping(value = "/api/usuarios/cliente", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registrarUsuarioCliente(@RequestBody Cliente cliente) {
        usuarioService.registrarUsuarioCliente(cliente);
        return new ResponseEntity<String>("{\"respuesta\": \"Se ha registrado correctamente el cliente.\"}",
                HttpStatus.OK);
    }



    @RequestMapping(value = "/api/usuario/cliente", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> eliminarUsuarioPorCorreoCliente(@RequestParam ("correo") String correo, @RequestParam ("contrasena") String contrasena ) {
        usuarioService.eliminarUsuarioPorCorreoCliente(correo,contrasena);
        return new ResponseEntity<String>("{\"respuesta\": \"Se ha eliminado correctamente el Cliente.\"}",
                HttpStatus.OK);
    }


    @RequestMapping(value = "/api/usuario/cliente/correo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente>  obtenerUsuarioPorCorreoCliente(@RequestParam("correo") String correo) {
        return new ResponseEntity<Cliente>(
                (Cliente) usuarioService.buscarUsuarioPorCorreoCliente(correo),
                HttpStatus.OK);
    }


    @RequestMapping(value = "/api/usuario/cliente", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String>  obtenerContrasenaUsuarioCliente(@RequestParam("correo") String correo) {
        return new ResponseEntity<String>(
                 usuarioService.buscarContrasenaUsuarioCliente(correo),
                HttpStatus.OK);
    }


    @RequestMapping(value = "/api/usuario/cliente", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> actualizarUsuarioCliente(@RequestBody Cliente cliente,@PathVariable("correo") String correo) {
        usuarioService.actualizarUsuarioCliente(cliente,correo);
        return new ResponseEntity<String>("{\"respuesta\": \"Se ha actualizado correctamente el cliente.\"}",
                HttpStatus.OK);
    }



}
