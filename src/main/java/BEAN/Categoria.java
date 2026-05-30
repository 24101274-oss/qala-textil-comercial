package BEAN;
public class Categoria {
    private int categoriaID;
    private String nombreCategoria;

    public Categoria() {
    }

    public Categoria(int categoriaID, String nombreCategoria) {
        this.categoriaID = categoriaID;
        this.nombreCategoria = nombreCategoria;
    }

    public int getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
}
