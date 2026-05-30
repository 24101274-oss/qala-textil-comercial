package BEAN;
public class Entrada {
    private int entradaID;
    private int proveedorID;
    private int usuarioID;
    private String numeroFactura;
    private String fechaEntrada;
    private double totalCompra;
    private String observacion;
    public Entrada() {
    }

    public Entrada(int entradaID, int proveedorID, int usuarioID, String numeroFactura, String fechaEntrada, double totalCompra, String observacion) {
        this.entradaID = entradaID;
        this.proveedorID = proveedorID;
        this.usuarioID = usuarioID;
        this.numeroFactura = numeroFactura;
        this.fechaEntrada = fechaEntrada;
        this.totalCompra = totalCompra;
        this.observacion = observacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getEntradaID() {
        return entradaID;
    }

    public void setEntradaID(int entradaID) {
        this.entradaID = entradaID;
    }

    public int getProveedorID() {
        return proveedorID;
    }

    public void setProveedorID(int proveedorID) {
        this.proveedorID = proveedorID;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }
    
}
