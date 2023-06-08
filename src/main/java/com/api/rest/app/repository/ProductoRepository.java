package com.api.rest.app.repository;

import com.api.rest.app.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// El repositorio es el que va a interactuar con la base de datos, este es el que interactua con la capa de la base de datos
@Repository
public class ProductoRepository {

    // Si no tengo una base de datos,esta es la manera en la que deberia guardar los datos
    private List<Producto> productos = new ArrayList<>();

    // Ahora agregaremos los metodos para hacer un crud

    //Listar todos los productos
    public List<Producto> getAllProductos() {
        return productos;
    }

    //Buscar un producto
    public Producto findById(int id) {
        for (int i = 0; i < productos.size(); i++) {
            if(productos.get(i).getId() == id) {
                return productos.get(i);
            }
        }

        return null;
    }

    // Se encarga de buscar un producto
    public List<Producto> search(String nombre) {
        return productos.stream()
                .filter(x -> x.getNombre().startsWith(nombre))
                .collect(Collectors.toList());
    }

    // Guardar un producto
    public Producto save (Producto p) {
        Producto producto = new Producto();

        producto.setId(p.getId());
        producto.setNombre(p.getNombre());
        producto.setCantidad(p.getCantidad());
        producto.setPrecio(p.getPrecio());

        productos.add(producto);
        return producto;
    }

    // Eminar un producto
    public String delete(Integer id){
        productos.removeIf(x -> x.getId() == id);
        return null;
    }

    // Actualizar un producto
    public Producto update( Producto producto) {
        int idIndex = 0;
        int id = 0;

        // Comprobamos si existe el producto y obtenemos la posicion y ID del prod.
        for (int i = 0; i < productos.size(); i++) {
            if(productos.get(i).getId() == producto.getId()) {
                id = producto.getId();
                idIndex = i;
                break;
            }
        }

        Producto producto1 = new Producto();
        producto.setId(id);
        producto1.setNombre(producto.getNombre());
        producto1.setCantidad(producto.getCantidad());
        producto1.setPrecio(producto.getPrecio());

        productos.set(idIndex,producto);
        return producto1;

    }

}
