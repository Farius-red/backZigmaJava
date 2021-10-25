package backZigma.Productos.controller;

import backZigma.Productos.entity.Producto;
import backZigma.Productos.mensajes.Mensaje;
import backZigma.Productos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping("/listaProductos")
    public ResponseEntity<List<Producto>>listaProductos(){
        List<Producto> listproductos = productoService.ListProductos();
        if(listproductos.isEmpty())
            return  new ResponseEntity(new Mensaje("Algo salio mal la lista esta vacia"), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<List<Producto>>(listproductos,HttpStatus.OK );
    }
}
