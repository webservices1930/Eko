
package co.edu.javeriana.eko.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para transporte complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="transporte">
 *   &lt;complexContent>
 *     &lt;extension base="{http://iservice.eko.javeriana.edu.co/}producto">
 *       &lt;sequence>
 *         &lt;element name="duracion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="horaLlegada" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="horaSalida" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tipoTransporte" type="{http://iservice.eko.javeriana.edu.co/}tipoTransporte" minOccurs="0"/>
 *         &lt;element name="trayecto" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transporte", propOrder = {
    "duracion",
    "horaLlegada",
    "horaSalida",
    "tipoTransporte",
    "trayecto"
})
public class Transporte
    extends Producto
{

    protected int duracion;
    protected int horaLlegada;
    protected int horaSalida;
    @XmlSchemaType(name = "string")
    protected TipoTransporte tipoTransporte;
    @XmlElement(nillable = true)
    protected List<String> trayecto;

    /**
     * Obtiene el valor de la propiedad duracion.
     * 
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Define el valor de la propiedad duracion.
     * 
     */
    public void setDuracion(int value) {
        this.duracion = value;
    }

    /**
     * Obtiene el valor de la propiedad horaLlegada.
     * 
     */
    public int getHoraLlegada() {
        return horaLlegada;
    }

    /**
     * Define el valor de la propiedad horaLlegada.
     * 
     */
    public void setHoraLlegada(int value) {
        this.horaLlegada = value;
    }

    /**
     * Obtiene el valor de la propiedad horaSalida.
     * 
     */
    public int getHoraSalida() {
        return horaSalida;
    }

    /**
     * Define el valor de la propiedad horaSalida.
     * 
     */
    public void setHoraSalida(int value) {
        this.horaSalida = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoTransporte.
     * 
     * @return
     *     possible object is
     *     {@link TipoTransporte }
     *     
     */
    public TipoTransporte getTipoTransporte() {
        return tipoTransporte;
    }

    /**
     * Define el valor de la propiedad tipoTransporte.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoTransporte }
     *     
     */
    public void setTipoTransporte(TipoTransporte value) {
        this.tipoTransporte = value;
    }

    /**
     * Gets the value of the trayecto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trayecto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrayecto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTrayecto() {
        if (trayecto == null) {
            trayecto = new ArrayList<String>();
        }
        return this.trayecto;
    }

}
