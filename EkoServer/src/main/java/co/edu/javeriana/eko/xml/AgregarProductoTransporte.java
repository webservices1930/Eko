
package co.edu.javeriana.eko.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para agregarProductoTransporte complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="agregarProductoTransporte">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="transporte" type="{http://iservice.eko.javeriana.edu.co/}transporte" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "agregarProductoTransporte", propOrder = {
    "transporte"
})
public class AgregarProductoTransporte {

    protected Transporte transporte;

    /**
     * Obtiene el valor de la propiedad transporte.
     * 
     * @return
     *     possible object is
     *     {@link Transporte }
     *     
     */
    public Transporte getTransporte() {
        return transporte;
    }

    /**
     * Define el valor de la propiedad transporte.
     * 
     * @param value
     *     allowed object is
     *     {@link Transporte }
     *     
     */
    public void setTransporte(Transporte value) {
        this.transporte = value;
    }

}
