package backZigma.Productos.controller;

import backZigma.Productos.dto.ProductoDto;
import backZigma.Productos.entity.Producto;
import backZigma.Productos.mensajes.Mensaje;
import backZigma.Productos.service.ProductoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ProductoService productoService;

    @GetMapping("/listaProductos")
    public ResponseEntity<List<Producto>>listaProductos(){
        List<Producto> listproductos = productoService.ListProductos();
        if(listproductos.isEmpty())
            return  new ResponseEntity(new Mensaje("Algo salio mal la lista esta vacia"), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<List<Producto>>(listproductos,HttpStatus.OK );
    }

    @GetMapping("/productoId/{id}")
    public ResponseEntity<Producto> getById(@PathVariable("id") int id){
        if (!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("No hay productos con ese id"),HttpStatus.NOT_FOUND);

   Producto producto = productoService.getOne(id).get();
    return  new ResponseEntity<Producto>(producto, HttpStatus.OK);
    }

    @GetMapping("/productoNombre/{nombre}")
    public ResponseEntity<Producto> getBynombre(@PathVariable("nombre") String nombre){
        if (!productoService.exitsByNombre(nombre))
            return new ResponseEntity(new Mensaje("No hay productos con ese nombre"),HttpStatus.NOT_FOUND);

        Producto producto = productoService.getByNombre(nombre).get();
        return  new ResponseEntity<Producto>(producto, HttpStatus.OK);
    }


    @PreAuthorize("hasRole('ADMIN')")
@PostMapping("/crearProducto")
    public ResponseEntity<?> crear(@RequestBody ProductoDto productoDto){
        if (StringUtils.isBlank(productoDto.getNombre()))
            return  new ResponseEntity(new Mensaje("El nombre es obligatrorio"),HttpStatus.BAD_REQUEST);
        if (productoDto.getPrecioVenta()<0)
            return  new ResponseEntity(new Mensaje("El precio de venta  es obligatrorio"),HttpStatus.BAD_REQUEST);
        if (productoService.exitsByNombre(productoDto.getNombre()))
            return  new ResponseEntity(new Mensaje("Ese nombre ya existe"),HttpStatus.BAD_REQUEST);
        if (productoDto.getMedidas().isEmpty())
            return new ResponseEntity(new Mensaje("Las medidas son obligatioras"),HttpStatus.BAD_REQUEST);

        if (productoDto.getPrecioFab()<0)
            return new ResponseEntity(new Mensaje("El precio de fabricacion es obligatorio"),HttpStatus.BAD_REQUEST);

        if (productoDto.getDescripcion().isEmpty())
            return new ResponseEntity(new Mensaje("la Descripcion es obligatoria"),HttpStatus.BAD_REQUEST);


        Producto producto = new Producto(
                productoDto.getNombre(),
                productoDto.getDescripcion(),
                productoDto.getColor(),
               productoDto.getMedidas(),
                productoDto.getPrecioFab(),
                productoDto.getPrecioVenta(),
                productoDto.getRutaImagen()
        );
 productoService.save(producto);
 return  new ResponseEntity(new Mensaje("producto Creado Correctamente"),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROl_ADMIN')")
    @PostMapping("/actualizarProducto")
    public ResponseEntity<?> actualizarProducto (@PathVariable("id") int id ,@RequestBody ProductoDto productoDto){

        if (!productoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No hay productos con ese id"), HttpStatus.NOT_FOUND);
        }else {
            if (StringUtils.isBlank(productoDto.getNombre()))

                return new ResponseEntity(new Mensaje("El nombre es obligatrorio"), HttpStatus.BAD_REQUEST);
            if (productoDto.getPrecioVenta() < 0)
                return new ResponseEntity(new Mensaje("El precio de venta  es obligatrorio"), HttpStatus.BAD_REQUEST);
            if (productoService.exitsByNombre(productoDto.getNombre()))
                return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
            if (productoDto.getMedidas().isEmpty())
                return new ResponseEntity(new Mensaje("Las medidas son obligatioras"), HttpStatus.BAD_REQUEST);

            if (productoDto.getPrecioFab() < 0)
                return new ResponseEntity(new Mensaje("El precio de fabricacion es obligatorio"), HttpStatus.BAD_REQUEST);

            if (productoDto.getDescripcion().isEmpty())
                return new ResponseEntity(new Mensaje("la Descripcion es obligatoria"), HttpStatus.BAD_REQUEST);


            Producto producto = new Producto(
                    productoDto.getNombre(),
                    productoDto.getDescripcion(),
                    productoDto.getColor(),
                    productoDto.getMedidas(),
                    productoDto.getPrecioFab(),
                    productoDto.getPrecioVenta(),
                    productoDto.getRutaImagen()
            );
            productoService.save(producto);

        }
        return  new ResponseEntity(new Mensaje("producto Creado Correctamente"),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        productoService.eliminarProducto(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
}
