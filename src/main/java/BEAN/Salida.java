package BEAN;
public class Salida {
    private int salidaID;
    private int usuarioID;
    private int tipoSalidaID;
    private int clienteID;
    private String numeroFactura;
    private String fechasalida;
    private double totalVenta;
    private String observacion;
    public Salida() {
    }

    public Salida(int salidaID, int usuarioID, int tipoSalidaID, int clienteID, String numeroFactura, String fechasalida, double totalVenta, String observacion) {
        this.salidaID = salidaID;
        this.usuarioID = usuarioID;
        this.tipoSalidaID = tipoSalidaID;
        this.clienteID = clienteID;
        this.numeroFactura = numeroFactura;
        this.fechasalida = fechasalida;
        this.totalVenta = totalVenta;
        this.observacion = observacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    public int getSalidaID() {
        return salidaID;
    }

    public void setSalidaID(int salidaID) {
        this.salidaID = salidaID;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public int getTipoSalidaID() {
        return tipoSalidaID;
    }

    public void setTipoSalidaID(int tipoSalidaID) {
        this.tipoSalidaID = tipoSalidaID;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(String fechasalida) {
        this.fechasalida = fechasalida;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }
    
}
