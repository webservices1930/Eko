package co.edu.javeriana.eko.iservice;

import co.edu.javeriana.eko.model.Usuario;
import co.edu.javeriana.eko.model.usuario.Cliente;
import co.edu.javeriana.eko.model.usuario.Proveedor;

public interface IUsuarioService {

    void registrarUsuarioCliente(Cliente usuario);

    void registrarUsuarioProveedor(Proveedor usuario);

    Usuario iniciarSesion (String correo, String contrasena);

    void eliminarUsuarioPorCorreoCliente(String correo, String contrasena);

    void eliminarUsuarioPorCorreoProveedor(String correo, String contrasena);

    Cliente buscarUsuarioPorCorreoCliente(String correo);

    String buscarContrasenaUsuarioCliente(String correo);

    String buscarContrasenaUsuarioProveedor(String correo);

    Proveedor buscarUsuarioPorCorreoProveedor(String correo);

    void actualizarUsuarioCliente(Cliente usuario, String correo);

    void actualizarUsuarioProovedor(Proveedor usuario, String correo);
}

