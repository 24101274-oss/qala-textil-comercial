package BEAN;
public class DetalleSalida {
    private int detalleSalidaID;
    private int salidaID;
    private int materialID;
    private double cantidad;
    private double precioVenta;

    public DetalleSalida() {
    }

    public DetalleSalida(int detalleSalidaID, int salidaID, int materialID, double cantidad, double precioVenta) {
        this.detalleSalidaID = detalleSalidaID;
        this.salidaID = salidaID;
        this.materialID = materialID;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
    }

    public int getDetalleSalidaID() {
        return detalleSalidaID;
    }

    public void setDetalleSalidaID(int detalleSalidaID) {
        this.detalleSalidaID = detalleSalidaID;
    }

    public int getSalidaID() {
        return salidaID;
    }

    public void setSalidaID(int salidaID) {
        this.salidaID = salidaID;
    }

    public int getMaterialID() {
        return materialID;
    }

    public void setMaterialID(int materialID) {
        this.materialID = materialID;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
    
}
