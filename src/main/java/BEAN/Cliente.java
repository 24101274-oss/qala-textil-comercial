package BEAN;
public class Cliente {
    private int clienteID;
    private String nombre;
    private String documento;
    private String telefono;
    private String direccion;
    private String email;

    public Cliente() {
    }

    public Cliente(int clienteID, String nombre, String documento, String telefono, String direccion, String email) {
        this.clienteID = clienteID;
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    public int getclienteID() {
        return clienteID;
    }

    public void setclienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
