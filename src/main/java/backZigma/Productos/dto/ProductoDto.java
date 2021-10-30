package backZigma.Productos.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ProductoDto {

    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String color;
    @NotBlank
    private String medidas;
    @NotBlank
    @Min(0)
    private float precioFab;

    @NotBlank
    @Min(0)
    private float precioVenta;
    @NotBlank
    private String rutaImagen;

    public ProductoDto(String nombre, String descripcion, String color, String medidas, float precioFab, float precioVenta, String rutaImagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.color = color;
        this.medidas = medidas;
        this.precioFab = precioFab;
        this.precioVenta = precioVenta;
        this.rutaImagen = rutaImagen;
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
