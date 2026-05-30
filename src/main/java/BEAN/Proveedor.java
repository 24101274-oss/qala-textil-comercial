package BEAN;
public class Proveedor {
    private int proveedorID;
    private String nombre;
    private String nombreContacto;
    private String direccion;
    private String ciudad;
    private String telefono;

    public Proveedor() {
    }

    public Proveedor(int proveedorID, String nombre, String nombreContacto, String direccion, String ciudad, String telefono) {
        this.proveedorID = proveedorID;
        this.nombre = nombre;
        this.nombreContacto = nombreContacto;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    public int getProveedorID() {
        return proveedorID;
    }

    public void setProveedorID(int proveedorID) {
        this.proveedorID = proveedorID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
