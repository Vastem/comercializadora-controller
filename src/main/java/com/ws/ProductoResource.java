package com.ws;

import com.logica.FachadaModelo;
import entidades.Producto;
import entidades.Producto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("productos")
public class ProductoResource {
    FachadaModelo fm= new FachadaModelo();

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<Producto>> getPedidos() {
        List<Producto> prods = fm.getProductos();
        if (prods == null) {
            return ResponseEntity.notFound().build(); // devuelve 404 Not Found
        } else {
            return ResponseEntity.ok(prods); // devuelve 200 OK y el objeto Pedido
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getPedidoID(@PathVariable("id") Integer id) {
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
        Producto c = fm.addProducto(Producto);
        return ResponseEntity.status(201).body(c);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> deleteProducto(@PathVariable("id") int id) {
        Producto c = fm.getProductoById(id);
        if (c == null) {
            return ResponseEntity.notFound().build(); // devuelve 404 Not Found
        } else {
            fm.deleteProducto(c);
            return ResponseEntity.noContent().build(); //
        }
    }

    @CrossOrigin(origins = "*")
    @PutMapping
    public ResponseEntity<Producto> updateProducto(@RequestBody Producto Producto) {
        Producto c = fm.getProductoById(Producto.getId());
        if (c == null) {
            return ResponseEntity.notFound().build(); // devuelve 404 Not Found
        } else {
            fm.updateProducto(c);
            return ResponseEntity.noContent().build(); //
        }
    }
}
