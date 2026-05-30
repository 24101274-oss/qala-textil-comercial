package BEAN;
public class DetalleEntrada {
    private int detalleEntradaID;
    private int entradaID;
    private int materialID;
    private double cantidad;
    private double costoUnitario;

    public DetalleEntrada() {
    }

    public DetalleEntrada(int detalleEntradaID, int entradaID, int materialID, double cantidad, double costoUnitario) {
        this.detalleEntradaID = detalleEntradaID;
        this.entradaID = entradaID;
        this.materialID = materialID;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
    }

    public int getDetalleEntradaID() {
        return detalleEntradaID;
    }

    public void setDetalleEntradaID(int detalleEntradaID) {
        this.detalleEntradaID = detalleEntradaID;
    }

    public int getEntradaID() {
        return entradaID;
    }

    public void setEntradaID(int entradaID) {
        this.entradaID = entradaID;
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

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }
    
}
