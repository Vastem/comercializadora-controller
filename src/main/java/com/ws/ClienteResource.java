package com.ws;

import com.logica.FachadaModelo;
import entidades.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteResource {
    FachadaModelo fm= new FachadaModelo();

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<Cliente>> getPedidos() {
        List<Cliente> clientes = fm.getClientes();
        if (clientes == null) {
            return ResponseEntity.notFound().build(); // devuelve 404 Not Found
        } else {
            return ResponseEntity.ok(clientes); // devuelve 200 OK y el objeto Pedido
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteID(@PathVariable("id") Integer id) {
        Cliente c = fm.getClienteById(id);
        if (c == null) {
            return ResponseEntity.notFound().build(); // devuelve 404 Not Found
        } else {
            return ResponseEntity.ok(c); // devuelve 200 OK y el objeto Pedido
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente){
        Cliente c = fm.addCliente(cliente);
        return ResponseEntity.status(201).body(c);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable("id") int id) {
        Cliente c = fm.getClienteById(id);
        if (c == null) {
            return ResponseEntity.notFound().build(); // devuelve 404 Not Found
        } else {
            fm.deleteCliente(c);
            return ResponseEntity.noContent().build(); //
        }
    }

    @CrossOrigin(origins = "*")
    @PutMapping
    public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente) {
        Cliente c = fm.getClienteById(cliente.getId());
        if (c == null) {
            return ResponseEntity.notFound().build(); // devuelve 404 Not Found
        } else {
            fm.updateCliente(cliente);
            return ResponseEntity.noContent().build(); //
        }
    }

}
