package co.edu.javeriana.eko.iservice;

import java.util.List;

import co.edu.javeriana.eko.model.Producto;

public interface IProductoService {
	public List<Producto> obtenerTodosProductos();
	
	public List<Producto> obtenerProductosPorUsuario(String _idUsuario);
		
	public void crearProducto(Producto nProducto);

	public Producto obtenerProducto(String nombreColeccion, String idProducto);

	public void eliminarProducto(String nombreColeccion, String idProducto);

	public void actualizarProducto(Producto nProducto);
	
	public Producto buscarProductoPorId(String _id);
	
	public List<Producto> buscarPorCadena(String cadena);
	
	public String twitterApi(String cadena);
}
