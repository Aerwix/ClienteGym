package clientegym.POJOS;

public class clientes {
    private Integer idCliente;
    private String nombre;
    private String calle;
    private String colonia;
    private String numero;
    private String correo;
    private String fechaNac;
    private String estatus;
    private double altura;

    public clientes() {
    }

    public clientes(Integer idCliente, String nombre, String calle, String colonia, String numero, String correo, String fechaNac, String estatus, double altura) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.calle = calle;
        this.colonia = colonia;
        this.numero = numero;
        this.correo = correo;
        this.fechaNac = fechaNac;
        this.estatus = estatus;
        this.altura = altura;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    
    
    
    
    
}
