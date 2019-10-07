package co.edu.javeriana.eko;

import co.edu.javeriana.eko.services.CatalogoService;
import co.edu.javeriana.eko.services.ProductoServices;
import co.edu.javeriana.eko.services.UsuarioService;

import javax.xml.ws.Endpoint;

public class HerokuLoader {
  public static void main(String[] args) {
    String port = System.getenv("PORT");
    String host = "http://0.0.0.0:";

    // Producto
    String uri = "/eko/producto";
    ProductoServices service = new ProductoServices();
    Endpoint.publish(host + port + uri, service);

    //Usuario
    String uriUsuario ="/eko/usuario";
    UsuarioService usuarioService = new UsuarioService();
    Endpoint.publish(host + port + uriUsuario, usuarioService);

    //Catalogo
    String uriCatalogo ="/eko/catalogo";
    CatalogoService catalogoService = new CatalogoService();
    Endpoint.publish(host + port + uriCatalogo, catalogoService);

    //Carrito
    String uriCarrito ="/eko/carrito";
    CatalogoService carritoService = new CatalogoService();
    Endpoint.publish(host + port + uriCarrito, carritoService);
  }
}
