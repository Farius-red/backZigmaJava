package backZigma.Productos.repository;

import backZigma.Productos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

     Optional<Producto> findByIdProducto(int idProducto);

     Optional<Producto>findByNombre(String nombre);



}
