
package co.edu.javeriana.eko.xml;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IMarketPlace", targetNamespace = "http://iservice.eko.javeriana.edu.co/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IMarketPlace {


    /**
     * 
     * @return
     *     returns co.edu.javeriana.eko.xml.MarketPlace
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerTodosLosProductos", targetNamespace = "http://iservice.eko.javeriana.edu.co/", className = "co.edu.javeriana.eko.xml.ObtenerTodosLosProductos")
    @ResponseWrapper(localName = "obtenerTodosLosProductosResponse", targetNamespace = "http://iservice.eko.javeriana.edu.co/", className = "co.edu.javeriana.eko.xml.ObtenerTodosLosProductosResponse")
    @Action(input = "http://iservice.eko.javeriana.edu.co/IMarketPlace/obtenerTodosLosProductosRequest", output = "http://iservice.eko.javeriana.edu.co/IMarketPlace/obtenerTodosLosProductosResponse")
    public MarketPlace obtenerTodosLosProductos();

}
