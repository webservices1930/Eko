package co.edu.javeriana.eko.model.usuario;

import co.edu.javeriana.eko.model.Usuario;
import co.edu.javeriana.eko.utils.TipoUsuario;

public class Proveedor  extends Usuario {

    private String telefono;
    private String paginaWeb;
    private String contactoFacebook;
    private String contactoTwitter;

    public Proveedor(String telefono, String paginaWeb, String contactoFacebook, String contactoTwitter) {
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;
        this.contactoFacebook = contactoFacebook;
        this.contactoTwitter = contactoTwitter;
    }

    public Proveedor(String nombre, int edad, String foto, TipoUsuario tipoUsuario, String descripcion, String correo, String contrasena, String telefono, String paginaWeb, String contactoFacebook, String contactoTwitter) {
        super(nombre, edad, foto, descripcion, correo, contrasena,tipoUsuario);
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;
        this.contactoFacebook = contactoFacebook;
        this.contactoTwitter = contactoTwitter;
    }

    public Proveedor() {

    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getContactoFacebook() {
        return contactoFacebook;
    }

    public void setContactoFacebook(String contactoFacebook) {
        this.contactoFacebook = contactoFacebook;
    }

    public String getContactoTwitter() {
        return contactoTwitter;
    }

    public void setContactoTwitter(String contactoTwitter) {
        this.contactoTwitter = contactoTwitter;
    }
}
