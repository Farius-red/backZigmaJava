package backZigma.Productos.service;

import backZigma.Productos.entity.Producto;
import backZigma.Productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ProductoService {

  @Autowired
    ProductoRepository productoRepository;


    private boolean  rta = false;

    public List<Producto> ListProductos(){
        return productoRepository.findAll();
    }

    public Producto getProductoById(int idProducto){
      return productoRepository.findById(idProducto).get() ;
    }

    public Producto getProductoByNombre(String nombre){
        return  productoRepository.findByNombre(nombre).get();
    }

    public boolean  addProducto(Producto producto){
        try {
            if (producto != null){
            productoRepository.save(producto);
            rta = true;
            }
        }catch (Exception e){
           System.out.println(e);
        }
        return rta;
    }

    public  void eliminarProducto(int idProducto){
        productoRepository.deleteById(idProducto);
    }

    public  boolean exitsByNombre(String nombreProducto){
        return productoRepository.existsByNombre(nombreProducto);
    }

    public  boolean existsById(int Id){
        return productoRepository.existsById(Id);
    }

    public Optional<Producto> getOne(int id){
        return  productoRepository.findById(id);
    }

    public Optional<Producto>getByNombre(String nombre){
        return productoRepository.findByNombre(nombre);
    }

    public void save(Producto producto){
        productoRepository.save(producto);
    }
}
