package co.edu.javeriana.eko.iservice;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import co.edu.javeriana.eko.model.MarketPlace;

@WebService
public interface IMarketPlace {
	
	@WebMethod(operationName = "obtenerTodosLosProductos")
	@WebResult(name="marketPlace")
	public String obtenerTodosLosProductos();
}
