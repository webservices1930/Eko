package co.edu.javeriana.eko.iservice;

import co.edu.javeriana.eko.model.Carrito;

public interface ICarritoService {
	
	public void crearCarrito(Carrito nCarrito);

	public Carrito obtenerCarritoPorUsuario(String idUsuario);

	public void actualizarCarrito(Carrito nCarrito);

	public void eliminarCarritoPorID(String _id);

}
