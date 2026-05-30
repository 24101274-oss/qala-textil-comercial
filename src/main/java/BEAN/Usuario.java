package BEAN;
public class Usuario {
    private int usuarioID;
    private String username;
    private String password;
    private int rolID;
    private int estado;

    public Usuario() {
    }

    public Usuario(int usuarioID, String username, String password, int rolID, int estado) {
        this.usuarioID = usuarioID;
        this.username = username;
        this.password = password;
        this.rolID = rolID;
        this.estado = estado;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRolID() {
        return rolID;
    }

    public void setRolID(int rolID) {
        this.rolID = rolID;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
