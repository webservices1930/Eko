
package co.edu.javeriana.eko.xml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.edu.javeriana.eko.xml package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CalificacionPromedioResponse_QNAME = new QName("http://iservice.eko.javeriana.edu.co/", "calificacionPromedioResponse");
    private final static QName _AgregarProductoTransporte_QNAME = new QName("http://iservice.eko.javeriana.edu.co/", "agregarProductoTransporte");
    private final static QName _AgregarProductoTransporteResponse_QNAME = new QName("http://iservice.eko.javeriana.edu.co/", "agregarProductoTransporteResponse");
    private final static QName _BuscarProductoTransportePorIDResponse_QNAME = new QName("http://iservice.eko.javeriana.edu.co/", "buscarProductoTransportePorIDResponse");
    private final static QName _BuscarProductoTransportePorID_QNAME = new QName("http://iservice.eko.javeriana.edu.co/", "buscarProductoTransportePorID");
    private final static QName _EliminarProductoTransportePorID_QNAME = new QName("http://iservice.eko.javeriana.edu.co/", "eliminarProductoTransportePorID");
    private final static QName _EliminarProductoTransportePorIDResponse_QNAME = new QName("http://iservice.eko.javeriana.edu.co/", "eliminarProductoTransportePorIDResponse");
    private final static QName _CalificacionPromedio_QNAME = new QName("http://iservice.eko.javeriana.edu.co/", "calificacionPromedio");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.edu.javeriana.eko.xml
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EliminarProductoTransportePorID }
     * 
     */
    public EliminarProductoTransportePorID createEliminarProductoTransportePorID() {
        return new EliminarProductoTransportePorID();
    }

    /**
     * Create an instance of {@link EliminarProductoTransportePorIDResponse }
     * 
     */
    public EliminarProductoTransportePorIDResponse createEliminarProductoTransportePorIDResponse() {
        return new EliminarProductoTransportePorIDResponse();
    }

    /**
     * Create an instance of {@link BuscarProductoTransportePorID }
     * 
     */
    public BuscarProductoTransportePorID createBuscarProductoTransportePorID() {
        return new BuscarProductoTransportePorID();
    }

    /**
     * Create an instance of {@link CalificacionPromedio }
     * 
     */
    public CalificacionPromedio createCalificacionPromedio() {
        return new CalificacionPromedio();
    }

    /**
     * Create an instance of {@link AgregarProductoTransporte }
     * 
     */
    public AgregarProductoTransporte createAgregarProductoTransporte() {
        return new AgregarProductoTransporte();
    }

    /**
     * Create an instance of {@link CalificacionPromedioResponse }
     * 
     */
    public CalificacionPromedioResponse createCalificacionPromedioResponse() {
        return new CalificacionPromedioResponse();
    }

    /**
     * Create an instance of {@link BuscarProductoTransportePorIDResponse }
     * 
     */
    public BuscarProductoTransportePorIDResponse createBuscarProductoTransportePorIDResponse() {
        return new BuscarProductoTransportePorIDResponse();
    }

    /**
     * Create an instance of {@link AgregarProductoTransporteResponse }
     * 
     */
    public AgregarProductoTransporteResponse createAgregarProductoTransporteResponse() {
        return new AgregarProductoTransporteResponse();
    }

    /**
     * Create an instance of {@link Transporte }
     * 
     */
    public Transporte createTransporte() {
        return new Transporte();
    }

    /**
     * Create an instance of {@link Disponibilidad }
     * 
     */
    public Disponibilidad createDisponibilidad() {
        return new Disponibilidad();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalificacionPromedioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iservice.eko.javeriana.edu.co/", name = "calificacionPromedioResponse")
    public JAXBElement<CalificacionPromedioResponse> createCalificacionPromedioResponse(CalificacionPromedioResponse value) {
        return new JAXBElement<CalificacionPromedioResponse>(_CalificacionPromedioResponse_QNAME, CalificacionPromedioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarProductoTransporte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iservice.eko.javeriana.edu.co/", name = "agregarProductoTransporte")
    public JAXBElement<AgregarProductoTransporte> createAgregarProductoTransporte(AgregarProductoTransporte value) {
        return new JAXBElement<AgregarProductoTransporte>(_AgregarProductoTransporte_QNAME, AgregarProductoTransporte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarProductoTransporteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iservice.eko.javeriana.edu.co/", name = "agregarProductoTransporteResponse")
    public JAXBElement<AgregarProductoTransporteResponse> createAgregarProductoTransporteResponse(AgregarProductoTransporteResponse value) {
        return new JAXBElement<AgregarProductoTransporteResponse>(_AgregarProductoTransporteResponse_QNAME, AgregarProductoTransporteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarProductoTransportePorIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iservice.eko.javeriana.edu.co/", name = "buscarProductoTransportePorIDResponse")
    public JAXBElement<BuscarProductoTransportePorIDResponse> createBuscarProductoTransportePorIDResponse(BuscarProductoTransportePorIDResponse value) {
        return new JAXBElement<BuscarProductoTransportePorIDResponse>(_BuscarProductoTransportePorIDResponse_QNAME, BuscarProductoTransportePorIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarProductoTransportePorID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iservice.eko.javeriana.edu.co/", name = "buscarProductoTransportePorID")
    public JAXBElement<BuscarProductoTransportePorID> createBuscarProductoTransportePorID(BuscarProductoTransportePorID value) {
        return new JAXBElement<BuscarProductoTransportePorID>(_BuscarProductoTransportePorID_QNAME, BuscarProductoTransportePorID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarProductoTransportePorID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iservice.eko.javeriana.edu.co/", name = "eliminarProductoTransportePorID")
    public JAXBElement<EliminarProductoTransportePorID> createEliminarProductoTransportePorID(EliminarProductoTransportePorID value) {
        return new JAXBElement<EliminarProductoTransportePorID>(_EliminarProductoTransportePorID_QNAME, EliminarProductoTransportePorID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarProductoTransportePorIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iservice.eko.javeriana.edu.co/", name = "eliminarProductoTransportePorIDResponse")
    public JAXBElement<EliminarProductoTransportePorIDResponse> createEliminarProductoTransportePorIDResponse(EliminarProductoTransportePorIDResponse value) {
        return new JAXBElement<EliminarProductoTransportePorIDResponse>(_EliminarProductoTransportePorIDResponse_QNAME, EliminarProductoTransportePorIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalificacionPromedio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iservice.eko.javeriana.edu.co/", name = "calificacionPromedio")
    public JAXBElement<CalificacionPromedio> createCalificacionPromedio(CalificacionPromedio value) {
        return new JAXBElement<CalificacionPromedio>(_CalificacionPromedio_QNAME, CalificacionPromedio.class, null, value);
    }

}
