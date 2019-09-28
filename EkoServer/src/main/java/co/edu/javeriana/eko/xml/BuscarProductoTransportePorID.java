
package co.edu.javeriana.eko.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para buscarProductoTransportePorID complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="buscarProductoTransportePorID">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="transporteID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buscarProductoTransportePorID", propOrder = {
    "transporteID"
})
public class BuscarProductoTransportePorID {

    protected String transporteID;

    /**
     * Obtiene el valor de la propiedad transporteID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransporteID() {
        return transporteID;
    }

    /**
     * Define el valor de la propiedad transporteID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransporteID(String value) {
        this.transporteID = value;
    }

}
