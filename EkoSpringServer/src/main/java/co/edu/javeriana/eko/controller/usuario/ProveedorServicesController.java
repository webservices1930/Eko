package co.edu.javeriana.eko.controller.usuario;

import co.edu.javeriana.eko.iservice.IUsuarioService;
import co.edu.javeriana.eko.model.usuario.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true")
public class ProveedorServicesController {

    @Autowired
    IUsuarioService usuarioService;

    @RequestMapping(value = "/api/usuarios/proveedor", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registrarUsuarioProveedor(@RequestBody Proveedor provedor) {
        usuarioService.registrarUsuarioProveedor(provedor);
        return new ResponseEntity<String>("{\"respuesta\": \"Se ha registrado correctamente el proveedor.\"}",
                HttpStatus.OK);
    }


    @RequestMapping(value = "/api/usuario/proveedor", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> eliminarUsuarioPorCorreoProveedor(@RequestParam ("correo") String correo, @RequestParam ("contrasena") String contrasena ){
        usuarioService.eliminarUsuarioPorCorreoProveedor(correo,contrasena);
        return new ResponseEntity<String>("{\"respuesta\": \"Se ha eliminado correctamente el Proveedor.\"}",
                HttpStatus.OK);
    }

    @RequestMapping(value = "/api/usuario/proveedor/correo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Proveedor> obtenerUsuarioPorCorreoProveedor(@RequestParam ("correo") String correo) {
        return new ResponseEntity<Proveedor>(
                (Proveedor) usuarioService.buscarUsuarioPorCorreoProveedor(correo),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/api/usuario/proveedor", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String>  obtenerContrasenaUsuarioProveedor(@RequestParam ("contrasena") String contrasena ) {
        return new ResponseEntity<String>(
                usuarioService.buscarContrasenaUsuarioProveedor(contrasena),
                HttpStatus.OK);
    }


    @RequestMapping(value = "/api/usuario/proveedor", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> actualizarUsuarioProovedor(@RequestBody Proveedor cliente,@PathVariable("correo") String correo) {
        usuarioService.actualizarUsuarioProovedor(cliente,correo);
        return new ResponseEntity<String>("{\"respuesta\": \"Se ha actualizado correctamente el proveedor.\"}",
                HttpStatus.OK);
    }






}
