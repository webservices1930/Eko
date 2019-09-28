
package co.edu.javeriana.eko.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoTransporte.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoTransporte">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AEREO"/>
 *     &lt;enumeration value="TERRESTRE"/>
 *     &lt;enumeration value="MARITIMO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipoTransporte")
@XmlEnum
public enum TipoTransporte {

    AEREO,
    TERRESTRE,
    MARITIMO;

    public String value() {
        return name();
    }

    public static TipoTransporte fromValue(String v) {
        return valueOf(v);
    }

}
