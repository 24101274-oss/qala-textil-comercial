package BEAN;
public class TipoSalida {
    private int tipoSalidaID;
    private String descripcion;

    public TipoSalida() {
    }

    public TipoSalida(int tipoSalidaID, String descripcion) {
        this.tipoSalidaID = tipoSalidaID;
        this.descripcion = descripcion;
    }

    public int getTipoSalidaID() {
        return tipoSalidaID;
    }

    public void setTipoSalidaID(int tipoSalidaID) {
        this.tipoSalidaID = tipoSalidaID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
