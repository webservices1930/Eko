
package co.edu.javeriana.eko.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoProducto.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoProducto">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TRANSPORTE"/>
 *     &lt;enumeration value="ALOJAMIENTO"/>
 *     &lt;enumeration value="SITIO"/>
 *     &lt;enumeration value="EXPERIENCIA"/>
 *     &lt;enumeration value="SALIDA"/>
 *     &lt;enumeration value="EVENTO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipoProducto")
@XmlEnum
public enum TipoProducto {

    TRANSPORTE,
    ALOJAMIENTO,
    SITIO,
    EXPERIENCIA,
    SALIDA,
    EVENTO;

    public String value() {
        return name();
    }

    public static TipoProducto fromValue(String v) {
        return valueOf(v);
    }

}
