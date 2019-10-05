package co.edu.javeriana.eko.utils;

import co.edu.javeriana.eko.model.Disponibilidad;
import co.edu.javeriana.eko.model.producto.Transporte;
import co.edu.javeriana.eko.model.usuario.Cliente;
import co.edu.javeriana.eko.model.usuario.Proveedor;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public final class Utils {
  /* --- Se genera un Singleton de Variables de Entorno --- */
  private static final Utils instance = new Utils();

  public static Utils getInstance() {
    return instance;
  }

  /**
   * Imprime un texto en azul
   *
   * @param info
   */
  public static void printInfo(String info) {
    System.out.println(
        //				VariablesDeEntorno.ANSI_BLUE +
        "[INFO]: " + info
        //				+ VariablesDeEntorno.ANSI_RESET
        );
  }

  /**
   * Imprime el texto en rojo
   *
   * @param err
   */
  public static void printErr(String err) {
    System.err.println(
        //				VariablesDeEntorno.ANSI_RED +
        "[ERROR]: " + err
        //				+ VariablesDeEntorno.ANSI_RESET
        );
  }

  /**
   * Imprime el texto en ver
   *
   * @param success
   */
  public static void printSuccess(String success) {
    System.out.println(
        //				VariablesDeEntorno.ANSI_GREEN +
        "[�XITO]: " + success
        //				+ VariablesDeEntorno.ANSI_RESET
        );
  }

  /**
   * M�todo que convierte un objeto de tipo Transporte a un Documento
   *
   * @param transporte
   * @return
   */
  public static Document deObjetoTransporteADocumento(Transporte transporte) {
    List<Document> disponibilidad = new ArrayList<Document>();

    for (Disponibilidad dis : transporte.getDisponibilidad()) {
      disponibilidad.add(
          new Document("fecha", dis.getFecha())
              .append("cuposDisponibles", dis.getCuposDisponibles()));
    }

    return new Document("precio", transporte.getPrecio())
        .append("infoPaisDestino", transporte.getInfoPaisDestino())
        .append("disponibilidad", disponibilidad)
        .append("descripcion", transporte.getDescripcion())
        .append("tipo", transporte.getTipo().toString())
        .append("horaSalida", transporte.getHoraSalida())
        .append("horaLlegada", transporte.getHoraLlegada())
        .append("trayecto", transporte.getTrayecto())
        .append("tipoTransporte", transporte.getTipoTransporte().toString())
        .append("duracion", transporte.getDuracion());
  }

  /**
   * M�todo que convierte un Documento con datos de Transporte a un objeto de tipo Transporte
   *
   * @param docTransporte
   * @return
   */
  public static Transporte deDocumentoAObjetoTransporte(Document docTransporte) {
    Transporte transporte = new Transporte();
    List<Disponibilidad> disponibilidad = new ArrayList<Disponibilidad>();

    List<Document> docDisponibilidad = (List<Document>) docTransporte.get("disponibilidad");
    List<String> docTrayecto = (List<String>) docTransporte.get("trayecto");
    String transporteID = ((ObjectId) docTransporte.getObjectId("_id")).toString();

    transporte.set_id(transporteID);

    for (Document docDis : docDisponibilidad) {
      Disponibilidad nDis = new Disponibilidad();
      nDis.setFecha((String) docDis.get("fecha"));
      nDis.setCuposDisponibles((Integer) docDis.get("cuposDisponibles"));
      disponibilidad.add(nDis);
    }

    transporte.setTrayecto(docTrayecto);

    transporte.setDisponibilidad(disponibilidad);
    transporte.setPrecio(docTransporte.getDouble("precio"));
    transporte.setInfoPaisDestino(docTransporte.getString("infoPaisDestino"));
    transporte.setDescripcion(docTransporte.getString("descripcion"));
    transporte.setTipo(TipoProducto.valueOf(docTransporte.getString("tipo")));
    transporte.setHoraSalida(docTransporte.getInteger("horaSalida"));
    transporte.setHoraLlegada(docTransporte.getInteger("horaLlegada"));
    transporte.setTipoTransporte(TipoTransporte.valueOf(docTransporte.getString("tipoTransporte")));
    transporte.setDuracion(docTransporte.getInteger("duracion"));

    return transporte;
  }

  /**
   * M�todo que convierte un objeto de tipo Cliente a un Documento
   *
   * @param usuario
   * @return
   */
  public static Document deObjetoClienteADocumento(Cliente usuario) {

    return new Document("nombre", usuario.getNombre())
        .append("edad", usuario.getEdad())
        .append("foto", usuario.getFoto())
        .append("descripcion", usuario.getDescripcion())
        .append("correo", usuario.getCorreo())
        .append("contrasena", usuario.getContrasena())
        .append("tipoUsuario", usuario.getTipoUsuario().toString());
  }

  /**
   * M�todo que convierte un objeto de tipo Proveedor a un Documento
   *
   * @param usuario
   * @return
   */
  public static Document deObjetoProveedorADocumento(Proveedor usuario) {

    return new Document("nombre", usuario.getNombre())
        .append("edad", usuario.getEdad())
        .append("foto", usuario.getFoto())
        .append("descripcion", usuario.getDescripcion())
        .append("correo", usuario.getCorreo())
        .append("contrasena", usuario.getContrasena())
        .append("contactoTwitter", usuario.getContactoTwitter())
        .append("contactoFacebook", usuario.getContactoFacebook())
        .append("telefono", usuario.getTelefono())
        .append("paginaWen", usuario.getPaginaWeb())
        .append("tipoUsuario", usuario.getTipoUsuario().toString());
  }

  /**
   * M�todo que convierte un Documento con datos de Usuario a un objeto de tipo Usuario
   *
   * @param docUsuario
   * @return
   */
  public static Cliente deDocumentoAObjetoCliente(Document docUsuario) {
    Cliente usuario = new Cliente();
    usuario.setNombre(docUsuario.getString("nombre"));
    usuario.setEdad(docUsuario.getInteger("edad"));
    usuario.setFoto(docUsuario.getString("foto"));
    usuario.setNombre(docUsuario.getString("nombre"));
    usuario.setDescripcion(docUsuario.getString("descripcion"));
    usuario.setCorreo(docUsuario.getString("correo"));
    usuario.setContrasena(docUsuario.getString("contrasena"));
    usuario.setTipoUsuario(TipoUsuario.valueOf(docUsuario.getString("tipoUsuario")));

    return usuario;
  }

  /**
   * M�todo que convierte un Documento con datos de Usuario a un objeto de tipo Usuario
   *
   * @param docUsuario
   * @return
   */
  public static Proveedor deDocumentoAObjetoProveedor(Document docUsuario) {
    Proveedor usuario = new Proveedor();
    usuario.setNombre(docUsuario.getString("nombre"));
    usuario.setEdad(docUsuario.getInteger("edad"));
    usuario.setFoto(docUsuario.getString("foto"));
    usuario.setNombre(docUsuario.getString("nombre"));
    usuario.setDescripcion(docUsuario.getString("descripcion"));
    usuario.setCorreo(docUsuario.getString("correo"));
    usuario.setContrasena(docUsuario.getString("contrasena"));
    usuario.setTipoUsuario(TipoUsuario.valueOf(docUsuario.getString("tipoUsuario")));
    usuario.setPaginaWeb(docUsuario.getString("paginaWeb"));
    usuario.setContactoFacebook(docUsuario.getString("contactoFacebook"));
    usuario.setContactoTwitter(docUsuario.getString("contactoTwitter"));
    usuario.setTelefono(docUsuario.getString("telefono"));

    return usuario;
  }
}
