package co.edu.javeriana.eko.model;

import java.util.List;

public class MarketPlace {
	
	private List<Producto> productos;

	public MarketPlace() {}

	public MarketPlace(List<Producto> productos) {
		this.productos = productos;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
}
