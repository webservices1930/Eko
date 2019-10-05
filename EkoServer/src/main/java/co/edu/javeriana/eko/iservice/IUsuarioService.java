package co.edu.javeriana.eko.iservice;

import co.edu.javeriana.eko.model.Usuario;
import co.edu.javeriana.eko.model.usuario.Cliente;
import co.edu.javeriana.eko.model.usuario.Proveedor;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface IUsuarioService {

  @WebMethod(operationName = "registrarUsuarioCliente")
  void registrarUsuarioCliente(@WebParam(name = "usuario") Cliente usuario);

  @WebMethod(operationName = "registrarUsuarioProveedor")
  void registrarUsuarioProveedor(@WebParam(name = "usuario") Proveedor usuario);

  @WebMethod(operationName = "iniciarSesion")
  @WebResult(name = "usuario")
  Usuario iniciarSesion(
      @WebParam(name = "correo") String correo, @WebParam(name = "contrasena") String contrasena);

  @WebMethod(operationName = "eliminarUsuarioPorCorreoCliente")
  void eliminarUsuarioPorCorreoCliente(
      @WebParam(name = "correo") String correo, @WebParam(name = "contrasena") String contrasena);

  @WebMethod(operationName = "eliminarUsuarioPorCorreoProveedor")
  void eliminarUsuarioPorCorreoProveedor(
      @WebParam(name = "correo") String correo, @WebParam(name = "contrasena") String contrasena);

  @WebMethod(operationName = "buscarUsuarioPorCorreoCliente")
  @WebResult(name = "usuarioCliente")
  Cliente buscarUsuarioPorCorreoCliente(@WebParam(name = "correo") String correo);

  @WebMethod(operationName = "buscarContrasenaUsuario")
  @WebResult(name = "contrasena")
  String buscarContrasenaUsuario(@WebParam(name = "correo") String correo);
  
  @WebMethod(operationName = "buscarContrasenaUsuarioCliente")
  @WebResult(name = "contrasena")
  String buscarContrasenaUsuarioCliente(@WebParam(name = "correo") String correo);

  @WebMethod(operationName = "buscarContrasenaUsuarioProveedor")
  @WebResult(name = "contrasena")
  String buscarContrasenaUsuarioProveedor(@WebParam(name = "correo") String correo);

  @WebMethod(operationName = "buscarUsuarioPorCorreoProveedor")
  @WebResult(name = "usuarioProveedor")
  Proveedor buscarUsuarioPorCorreoProveedor(@WebParam(name = "correo") String correo);

  @WebMethod(operationName = "actualizarUsuarioCliente")
  void actualizarUsuarioCliente(
      @WebParam(name = "usuario") Cliente usuario, @WebParam(name = "correo") String correo);

  @WebMethod(operationName = "actualizarUsuarioProovedor")
  void actualizarUsuarioProovedor(
      @WebParam(name = "usuario") Proveedor usuario, @WebParam(name = "correo") String correo);
}
