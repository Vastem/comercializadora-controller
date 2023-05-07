package com.ws;

import com.logica.FachadaModelo;
import entidades.Cliente;
import entidades.Venta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ventas")
public class VentaResource {
    FachadaModelo fm= new FachadaModelo();

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<Venta>> getVentas() {
        List<Venta> ventas = fm.getVentas();
        if (ventas == null) {
            return ResponseEntity.notFound().build(); // devuelve 404 Not Found
        } else {
            return ResponseEntity.ok(ventas); // devuelve 200 OK y el objeto Pedido
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVentaID(@PathVariable("id") Integer id) {
        Venta v = fm.getVentaById(id);
        if (v == null) {
            return ResponseEntity.notFound().build(); // devuelve 404 Not Found
        } else {
            return ResponseEntity.ok(v); // devuelve 200 OK y el objeto Pedido
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Venta> addVenta(@RequestBody Venta venta){
        Venta v = fm.addVenta(venta);
        return ResponseEntity.status(201).body(v);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Venta> deleteVenta(@PathVariable("id") int id) {
        Venta v = fm.getVentaById(id);
        if (v == null) {
            return ResponseEntity.notFound().build(); // devuelve 404 Not Found
        } else {
            fm.deleteVenta(v);
            return ResponseEntity.noContent().build(); //
        }
    }

    @CrossOrigin(origins = "*")
    @PutMapping
    public ResponseEntity<Venta> updateVenta(@RequestBody Venta venta) {
        Venta v = fm.getVentaById(venta.getId());
        if (v == null) {
            return ResponseEntity.notFound().build(); // devuelve 404 Not Found
        } else {
            fm.updateVenta(venta);
            return ResponseEntity.noContent().build(); //
        }
    }

}
