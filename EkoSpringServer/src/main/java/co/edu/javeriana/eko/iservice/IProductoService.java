package co.edu.javeriana.eko.iservice;

import co.edu.javeriana.eko.model.Producto;

public interface IProductoService {
	public void crearProducto(Producto nProducto);

	public Producto obtenerProducto(String nombreColeccion, String idProducto);

	public void eliminarProducto(String nombreColeccion, String idProducto);

	public void actualizarProducto(Producto nProducto);
}
