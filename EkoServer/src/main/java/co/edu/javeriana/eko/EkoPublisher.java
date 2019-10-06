package co.edu.javeriana.eko;

import javax.xml.ws.Endpoint;

import co.edu.javeriana.eko.db.controller.DBController;
import co.edu.javeriana.eko.model.MarketPlace;
import co.edu.javeriana.eko.utils.Utils;
import co.edu.javeriana.eko.webservices.CatalogoWebService;
import co.edu.javeriana.eko.webservices.MarketPlaceWebServices;
import co.edu.javeriana.eko.webservices.ProductoWebServices;
import co.edu.javeriana.eko.webservices.UsuarioWebServices;

public class EkoPublisher {

  public static void main(String[] args) {
    // Se crea una instancia del Market Place
    Utils.printInfo("Creando Market Place");

    MarketPlace marketPlace = null;
    marketPlace = new MarketPlace();

    Utils.printSuccess("Market Place creado");

    try {
      Utils.printInfo("Exponiendo servicios");

      // Expone los servicios del Market Place
    //  MarketPlaceWebServices.publicarMarketPlaceServices();
      // Expone los servicios de Producto


      ProductoWebServices.publicarProductoServices();
      UsuarioWebServices.publicarUsuarios();
      CatalogoWebService.publicarCatalogoServices();

      Utils.printSuccess("Servicios expuestos");
    } catch (Exception e) {
      Utils.printErr("" + e);
      DBController.cerrarConexionMongoDB();
    }
  }
}
