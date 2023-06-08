package com.api.rest.app.controller;

import com.api.rest.app.model.Producto;
import com.api.rest.app.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    //Creacion
    @PostMapping
    public Producto agregarProducto(@RequestBody Producto producto) {
        return productoService.saveProducto(producto);
    }

    //Lectura
    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.getProductos();
    }
    @GetMapping("/{id}")
    public Producto encontrarProducto(@PathVariable int id) {
        return productoService.getProductoById(id);
    }

    //Actualizacion
    @PutMapping
    public Producto actualizarProducto(@RequestBody Producto producto) {
        return productoService.updateProducto(producto);
    }

    //Eliminar
    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable int id) {
        return productoService.deleteProducto(id);
    }

}
