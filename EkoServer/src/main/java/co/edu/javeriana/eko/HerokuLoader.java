package co.edu.javeriana.eko;

import co.edu.javeriana.eko.services.ProductoServices;

import javax.xml.ws.Endpoint;

public class HerokuLoader {
  public static void main(String[] args) {
    String port = System.getenv("PORT");
    String host = "http://0.0.0.0:";

    // Producto
    String uri = "/eko/producto";
    ProductoServices service = new ProductoServices();
    Endpoint.publish(host + port + uri, service);
  }
}
