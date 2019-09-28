
package co.edu.javeriana.eko.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para producto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="producto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="disponibilidad" type="{http://iservice.eko.javeriana.edu.co/}disponibilidad" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="infoPaisDestino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="precio" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="tipo" type="{http://iservice.eko.javeriana.edu.co/}tipoProducto" minOccurs="0"/>
 *         &lt;element name="_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "producto", propOrder = {
    "descripcion",
    "disponibilidad",
    "infoPaisDestino",
    "precio",
    "tipo",
    "id"
})
@XmlSeeAlso({
    Transporte.class
})
public abstract class Producto {

    protected String descripcion;
    @XmlElement(nillable = true)
    protected List<Disponibilidad> disponibilidad;
    protected String infoPaisDestino;
    protected double precio;
    @XmlSchemaType(name = "string")
    protected TipoProducto tipo;
    @XmlElement(name = "_id")
    protected String id;

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Gets the value of the disponibilidad property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the disponibilidad property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisponibilidad().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Disponibilidad }
     * 
     * 
     */
    public List<Disponibilidad> getDisponibilidad() {
        if (disponibilidad == null) {
            disponibilidad = new ArrayList<Disponibilidad>();
        }
        return this.disponibilidad;
    }

    /**
     * Obtiene el valor de la propiedad infoPaisDestino.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfoPaisDestino() {
        return infoPaisDestino;
    }

    /**
     * Define el valor de la propiedad infoPaisDestino.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfoPaisDestino(String value) {
        this.infoPaisDestino = value;
    }

    /**
     * Obtiene el valor de la propiedad precio.
     * 
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Define el valor de la propiedad precio.
     * 
     */
    public void setPrecio(double value) {
        this.precio = value;
    }

    /**
     * Obtiene el valor de la propiedad tipo.
     * 
     * @return
     *     possible object is
     *     {@link TipoProducto }
     *     
     */
    public TipoProducto getTipo() {
        return tipo;
    }

    /**
     * Define el valor de la propiedad tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoProducto }
     *     
     */
    public void setTipo(TipoProducto value) {
        this.tipo = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
