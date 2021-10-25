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
}
