package co.edu.javeriana.eko.model.usuario;

import co.edu.javeriana.eko.model.Usuario;

public class Proveedor  extends Usuario {

    private int telefono;
    private String paginaWeb;
    private String contactoFacebook;
    private String contactoTwitter;

    public Proveedor(int telefono, String paginaWeb, String contactoFacebook, String contactoTwitter) {
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;
        this.contactoFacebook = contactoFacebook;
        this.contactoTwitter = contactoTwitter;
    }

    public Proveedor(String nombre, int edad, String descripcion, String correo, String contraseña, int telefono, String paginaWeb, String contactoFacebook, String contactoTwitter) {
        super(nombre, edad, descripcion, correo, contraseña);
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;
        this.contactoFacebook = contactoFacebook;
        this.contactoTwitter = contactoTwitter;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
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
