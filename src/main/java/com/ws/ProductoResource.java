package com.ws;

import com.logica.FachadaModelo;
import entidades.Producto;
import entidades.Producto;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("productos")
public class ProductoResource {
    FachadaModelo fm= new FachadaModelo();

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<Producto>> getProductos() {
        List<Producto> prods = fm.getProductos();
        if (prods == null) {
            return ResponseEntity.notFound().build(); // devuelve 404 Not Found
        } else {
            return ResponseEntity.ok(prods); // devuelve 200 OK y el objeto Pedido
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoID(@PathVariable("id") Integer id) {
        Producto p = fm.getProductoById(id);
        if (p == null) {
            return ResponseEntity.notFound().build(); // devuelve 404 Not Found
        } else {
            return ResponseEntity.ok(p); // devuelve 200 OK y el objeto Pedido
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Producto> addProducto(@RequestBody Producto Producto){
        try {
            Producto c = fm.addProducto(Producto);
            return ResponseEntity.status(201).body(c);
        }catch (Exception e){
            return ResponseEntity.status(400).build();
        }
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> deleteProducto(@PathVariable("id") int id) {
        Producto c = fm.getProductoById(id);
        if (c == null) {
            return ResponseEntity.notFound().build(); // devuelve 404 Not Found
        }
        try {
            fm.deleteProducto(c);
            return ResponseEntity.noContent().build(); //
        }catch (Exception e){
            return ResponseEntity.badRequest().build(); //
        }
    }

    @CrossOrigin(origins = "*")
    @PutMapping
    public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto) {
        Producto c = fm.getProductoById(producto.getId());
        if (c == null) {
            return ResponseEntity.notFound().build(); // devuelve 404 Not Found
        }
        try {
            fm.updateProducto(producto);
            return ResponseEntity.noContent().build(); //
        }catch (Exception e){
            return ResponseEntity.badRequest().build(); //

        }
    }
}
