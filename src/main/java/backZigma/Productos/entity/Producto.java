package backZigma.Productos.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String descripcion;
    private String color;
    private String medidas;
    private float precioFab;

    private float precioVenta;
    private String rutaImagen;

    public Producto() {

    }

    public Producto( String nombre, String descripcion, String color, String medidas, float precioFab, float precioVenta, String rutaImagen) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.color = color;
        this.medidas = medidas;
        this.precioFab = precioFab;
        this.precioVenta = precioVenta;
        this.rutaImagen = rutaImagen;
    }

    public int getIdProducto() {
        return id;
    }

    public void setIdProducto(int idProducto) {
        this.id = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public float getPrecioFab() {
        return precioFab;
    }

    public void setPrecioFab(float precioFab) {
        this.precioFab = precioFab;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}
