package co.edu.javeriana.eko.webservices;

import co.edu.javeriana.eko.services.UsuarioService;
import co.edu.javeriana.eko.utils.VariablesDeEntorno;

import javax.xml.ws.Endpoint;

public class UsuarioWebServices {
  // Url base para todos los End Points de Usuarios
  private static final String urlUsuario = VariablesDeEntorno.urlDominio + "usuario";

  /* --- Se genera un Singleton de Usuarios Web Service --- */
  private static final UsuarioWebServices instance = new UsuarioWebServices();

  private UsuarioWebServices() {}

  public static UsuarioWebServices getInstance() {
    return instance;
  }

  /** Expone todos los servicios de Usuarios */
  public static void publicarUsuarios() {
    Endpoint.publish(urlUsuario, new UsuarioService());
  }
}
