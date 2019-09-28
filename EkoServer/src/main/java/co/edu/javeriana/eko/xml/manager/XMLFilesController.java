package co.edu.javeriana.eko.xml.manager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import co.edu.javeriana.eko.xml.TipoProducto;
import co.edu.javeriana.eko.xml.TipoTransporte;
import co.edu.javeriana.eko.utils.Utils;
import co.edu.javeriana.eko.xml.Disponibilidad;
import co.edu.javeriana.eko.xml.MarketPlace;
import co.edu.javeriana.eko.xml.Producto;
import co.edu.javeriana.eko.xml.Transporte;

public class XMLFilesController {
	/* --- Se genera un Singleton del Controlador del archivo de XML --- */
	private static final XMLFilesController instance = new XMLFilesController();
	private static final String direccionXML = "data\\market-place.xml";
//	private static final String direccionNuevoXML = "data\\market-place-edited.xml";

	public static XMLFilesController getInstance() {
		return instance;
	}
	
	/**
	 * Toma un objeto de Tipo producto para escribir en el archivo XML y lo inserta
	 * 
	 * @param nProducto
	 */
	public static String obtenerTodosLosProductos() {
		MarketPlace marketPlace = new MarketPlace();
		
		try {
			JAXBContext context = JAXBContext.newInstance(MarketPlace.class);
			marketPlace = (MarketPlace) context.createUnmarshaller().unmarshal(new FileReader(direccionXML));
			
		} catch (JAXBException e) {
			System.err
					.println("Error while reading the JAXB model in: " + direccionXML);
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.err.println("Error while trying to load the file: " + direccionXML);
			e.printStackTrace();
		}

		Utils.printInfo("Obteniendo los productos");

		try {
			JAXBContext contexto = JAXBContext.newInstance(marketPlace.getClass());
			Marshaller marshaller = contexto.createMarshaller();
			StringWriter sw = new StringWriter();
			String contenidoXML = new String();
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(marketPlace, sw);
			contenidoXML = sw.toString();
			
			return contenidoXML;
		} catch (JAXBException e) {
			System.err.println("Error while preparing to write the JAXB model in: " + direccionXML);
			e.printStackTrace();
		}
		
		return "";
	}

	/**
	 * Toma un objeto de Tipo producto para escribir en el archivo XML y lo inserta
	 * 
	 * @param nProducto
	 */
	public static void agregarProductoEnXML(Producto nProducto) {
		MarketPlace marketPlace = new MarketPlace();
		
		try {
			JAXBContext context = JAXBContext.newInstance(MarketPlace.class);
			marketPlace = (MarketPlace) context.createUnmarshaller().unmarshal(new FileReader(direccionXML));
			
		} catch (JAXBException e) {
			System.err
					.println("Error while reading the JAXB model in: " + direccionXML);
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.err.println("Error while trying to load the file: " + direccionXML);
			e.printStackTrace();
		}

		Utils.printInfo("Agregando producto con ID :" + nProducto.getId());
		List<Producto> productos = marketPlace.getProductos();
		productos.add(nProducto);

		try {
			JAXBContext contexto = JAXBContext.newInstance(marketPlace.getClass());
			Marshaller marshaller = contexto.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(marketPlace, new FileWriter(direccionXML));
			
			Utils.printSuccess("Producto con ID: " + nProducto.getId() + " agregado");
		} catch (JAXBException e) {
			System.err.println("Error while preparing to write the JAXB model in: " + direccionXML);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error while writting the JAXB model in: " + direccionXML);
			e.printStackTrace();
		}
	}
	
	/**
	 * Busca en el archivo un objeto con el ID entregado y lo elimina
	 * 
	 * @param _id
	 */
	public static void eliminarProductoEnXMLPorID(String _id) {
		MarketPlace marketPlace = new MarketPlace();
		
		try {
			JAXBContext context = JAXBContext.newInstance(MarketPlace.class);
			marketPlace = (MarketPlace) context.createUnmarshaller().unmarshal(new FileReader(direccionXML));
			
		} catch (JAXBException e) {
			System.err
					.println("Error while reading the JAXB model in: " + direccionXML);
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.err.println("Error while trying to load the file: " + direccionXML);
			e.printStackTrace();
		}

		List<Producto> productos = marketPlace.getProductos();

		for (Producto producto : productos) {
			if (producto.getId().equals(_id)) {
				Utils.printInfo("Eliminando producto con ID :" + _id);
				productos.remove(producto);
				break;
			}
		}

		try {
			JAXBContext contexto = JAXBContext.newInstance(marketPlace.getClass());
			Marshaller marshaller = contexto.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(marketPlace, new FileWriter(direccionXML));
			
			Utils.printSuccess("Producto con ID: " + _id + " eliminadi");
		} catch (JAXBException e) {
			System.err.println("Error while preparing to write the JAXB model in: " + direccionXML);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error while writting the JAXB model in: " + direccionXML);
			e.printStackTrace();
		}
	}
	
	/**
	 * Busca en el archivo un objeto con el ID entregado y lo retorna
	 * 
	 * @param _id
	 * @return
	 */
	public static co.edu.javeriana.eko.model.Producto buscarProductoEnXMLPorID(String _id) {
		MarketPlace marketPlace = new MarketPlace();
		
		try {
			JAXBContext context = JAXBContext.newInstance(MarketPlace.class);
			marketPlace = (MarketPlace) context.createUnmarshaller().unmarshal(new FileReader(direccionXML));
			
		} catch (JAXBException e) {
			System.err
					.println("Error while reading the JAXB model in: " + direccionXML);
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.err.println("Error while trying to load the file: " + direccionXML);
			e.printStackTrace();
		}

		List<Producto> productos = marketPlace.getProductos();
		for (Producto producto : productos) {
			if (producto.getId().equals(_id)) {
				Utils.printSuccess("Producto con ID: " + _id + " recuperado");
				return UtilsXML.crearTransporteModel((Transporte) producto);
			}
		}
		
		return null;
	}
	
	/**
	 * Busca un producto por su ID en el archivo y actualiza todos sus datos
	 * 
	 * @param nProducto
	 */
	public static void actualizarProductoEnXMLPorID(Producto nProducto) {
		MarketPlace marketPlace = new MarketPlace();
		
		try {
			JAXBContext context = JAXBContext.newInstance(MarketPlace.class);
			marketPlace = (MarketPlace) context.createUnmarshaller().unmarshal(new FileReader(direccionXML));
			
		} catch (JAXBException e) {
			System.err
					.println("Error while reading the JAXB model in: " + direccionXML);
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.err.println("Error while trying to load the file: " + direccionXML);
			e.printStackTrace();
		}

		List<Producto> productos = marketPlace.getProductos();
		System.out.println("PRODUCTOS: " + marketPlace.getProductos().size());
		for (Producto producto : productos) {
			if (producto.getId().equals(nProducto.getId())) {
				Utils.printInfo("Actualizando producto con ID:" + nProducto.getId());
				productos.set(productos.indexOf(producto), nProducto);
				break;
			}
		}
		
		try {
			JAXBContext contexto = JAXBContext.newInstance(marketPlace.getClass());
			Marshaller marshaller = contexto.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(marketPlace, new FileWriter(direccionXML));
			
			Utils.printSuccess("Producto con ID: " + nProducto.getId() + " actualizado");
		} catch (JAXBException e) {
			System.err.println("Error while preparing to write the JAXB model in: " + direccionXML);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error while writting the JAXB model in: " + direccionXML);
			e.printStackTrace();
		}
	}
}
