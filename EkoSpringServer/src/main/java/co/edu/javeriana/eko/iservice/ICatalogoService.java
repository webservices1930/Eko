package co.edu.javeriana.eko.iservice;

import co.edu.javeriana.eko.model.Catalogo;

public interface ICatalogoService {
	
	public void crearCatalogo(Catalogo nCatalogo);
	public void actualizarCatalogo(Catalogo nCatalogo);
	void eliminarCatalogo(String _id);
	Catalogo obtenerCatalogo(String idCatalogo);

}
