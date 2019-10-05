package co.edu.javeriana.eko.iservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import co.edu.javeriana.eko.model.Catalogo;


@WebService
public interface ICatalogoService {

	@WebMethod(operationName = "obtenerCatalogos")
	@WebResult(name="listadoCatalogos")
	public List<Catalogo> obtenerCatalogos();	
			
	@WebMethod(operationName = "obtenerCatalogosPorUsuario")
	@WebResult(name="listaCatalogosUsuario")	
	public List<Catalogo> obtenerCatalogosPorUsuario(@WebParam(name = "usuarioID")  String _idUsuario);
	
	@WebMethod(operationName = "agregarCatalogo")
	public void agregarCatalogo(@WebParam(name = "nCatalogo") Catalogo nCatalogo);
	
	@WebMethod(operationName = "buscarCatalogoPorID")
	@WebResult(name="catalogo")
	public Catalogo buscarCatalogoPorID(@WebParam(name = "catalogoID") String _id);
	
	@WebMethod(operationName = "eliminarCatalogoPorID")
	public void eliminarCatalogoPorID(@WebParam(name = "catalogoID") String _id);
	
	@WebMethod(operationName = "actualizarCatalogo")
	public void actualizarCatalogo(@WebParam(name = "catalogo") Catalogo nCatalogo);
	
}
