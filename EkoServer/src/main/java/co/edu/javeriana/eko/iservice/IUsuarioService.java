package co.edu.javeriana.eko.iservice;

import co.edu.javeriana.eko.model.usuario.Cliente;
import co.edu.javeriana.eko.model.usuario.Proveedor;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IUsuarioService {

  @WebMethod(operationName = "registrarUsuarioCliente")
  void registrarUsuarioCliente(@WebParam(name = "usuario") Cliente usuario);

  @WebMethod(operationName = "registrarUsuarioProveedor")
  void registrarUsuarioProveedor(@WebParam(name = "usuario") Proveedor usuario);

  @WebMethod(operationName = "iniciarSesion")
  void iniciarSesion(
      @WebParam(name = "correo") String correo, @WebParam(name = "contraseña") String contraseña);

  @WebMethod(operationName = "eliminarUsuarioPorCorreoCliente")
  public void eliminarUsuarioPorCorreoCliente(@WebParam(name = "correo") String correo);

  @WebMethod(operationName = "eliminarUsuarioPorCorreoProveedor")
  public void eliminarUsuarioPorCorreoProveedor(@WebParam(name = "correo") String correo);

}
