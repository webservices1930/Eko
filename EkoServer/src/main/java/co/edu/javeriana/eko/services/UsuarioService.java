package co.edu.javeriana.eko.services;

import co.edu.javeriana.eko.db.controller.DBController;
import co.edu.javeriana.eko.iservice.IUsuarioService;
import co.edu.javeriana.eko.model.Usuario;
import co.edu.javeriana.eko.model.usuario.Cliente;
import co.edu.javeriana.eko.model.usuario.Proveedor;
import co.edu.javeriana.eko.utils.Utils;
import org.bson.Document;

import javax.jws.WebService;

@WebService(endpointInterface = "co.edu.javeriana.eko.iservice.IUsuarioService")
public class UsuarioService implements IUsuarioService {

  /* --- Se genera un Singleton de Producto Web Services --- */
  private static final UsuarioService instance = new UsuarioService();

  public static UsuarioService getInstance() {
    return instance;
  }

  @Override
  public void registrarUsuarioCliente(Cliente usuario) {
    Document nUsuarioDoc = Utils.deObjetoClienteADocumento(usuario);
    DBController.insertarObjeto("usuario-cliente", nUsuarioDoc);
  }

  @Override
  public void registrarUsuarioProveedor(Proveedor usuario) {
    Document nUsuarioDoc = Utils.deObjetoProveedorADocumento(usuario);
    DBController.insertarObjeto("usuario-proveedor", nUsuarioDoc);
  }

  @Override
  public Usuario iniciarSesion(String correo, String contraseña) {
    if (contraseña.equals(buscarContraseñaUsuarioCliente(correo))) {
      return DBController.buscarEnColeccionPorCorreo("usuario-cliente", correo);
    } else if (contraseña.equals(buscarContraseñaUsuarioProveedor(correo))) {
      return DBController.buscarEnColeccionPorCorreo("usuario-proveedor", correo);
    } else return null;
  }

  @Override
  public void eliminarUsuarioPorCorreoCliente(String correo, String contraseña) {
    if (contraseña.equals(buscarContraseñaUsuarioCliente(correo))) {
      DBController.eliminarEnColeccionPorCorreo("usuario-cliente", correo);
    }
  }

  @Override
  public void eliminarUsuarioPorCorreoProveedor(String correo, String contraseña) {
    if (contraseña.equals(buscarContraseñaUsuarioProveedor(correo))) {
      DBController.eliminarEnColeccionPorCorreo("usuario-proveedor", correo);
    }
  }

  @Override
  public Cliente buscarUsuarioPorCorreoCliente(String correo) {
    return (Cliente) DBController.buscarEnColeccionPorCorreo("usuario-cliente", correo);
  }

  @Override
  public String buscarContraseñaUsuarioCliente(String correo) {
    Usuario user;
    user = DBController.buscarContraseñaUsuario("usuario-cliente", correo);
    return user.getContraseña();
  }

  @Override
  public String buscarContraseñaUsuarioProveedor(String correo) {
    Usuario user;
    user = DBController.buscarContraseñaUsuario("usuario-proveedor", correo);
    return user.getContraseña();
  }

  @Override
  public Proveedor buscarUsuarioPorCorreoProveedor(String correo) {
    return (Proveedor) DBController.buscarEnColeccionPorCorreo("usuario-proveedor", correo);
  }

  @Override
  public void actualizarUsuarioCliente(Cliente usuario, String correo) {
    DBController.actualizarUsuarioCliente("usuario-cliente", usuario, correo);
  }

  @Override
  public void actualizarUsuarioProovedor(Proveedor usuario, String correo) {
    DBController.actualizarUsuarioProveedor("usuario-proveedor", usuario, correo);
  }
}
