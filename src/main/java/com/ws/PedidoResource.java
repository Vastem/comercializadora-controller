package com.ws;

import com.logica.FachadaModelo;
import entidades.Pedido;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedidos")
public class PedidoResource {
	FachadaModelo fm= new FachadaModelo();

	@GetMapping
	public ResponseEntity<List<Pedido>> getPedidos() {
		List<Pedido> pedidos = fm.getPedidos();
		if (pedidos == null) {
			return ResponseEntity.notFound().build(); // devuelve 404 Not Found
		} else {
			return ResponseEntity.ok(pedidos); // devuelve 200 OK y el objeto Pedido
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> getPedidoID(@PathVariable("id") Integer id) {
		Pedido p = fm.getPedidoById(id);
		if (p == null) {
			return ResponseEntity.notFound().build(); // devuelve 404 Not Found
		} else {
			return ResponseEntity.ok(p); // devuelve 200 OK y el objeto Pedido
		}
	}

	@PostMapping
	public ResponseEntity<Pedido> addPedido(@RequestBody Pedido pedido){
		Pedido p = fm.addPedido(pedido);
		return ResponseEntity.status(201).body(p);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Pedido> deletePedido(@PathVariable("id") int id) {
		Pedido p = fm.getPedidoById(id);
		if (p == null) {
			return ResponseEntity.notFound().build(); // devuelve 404 Not Found
		} else {
			fm.deletePedido(p);
			return ResponseEntity.noContent().build(); //
		}
	}

	@PutMapping
	public ResponseEntity<Pedido> updatePedido(@RequestBody Pedido pedido) {
		Pedido p = fm.getPedidoById(pedido.getId());
		if (p == null) {
			return ResponseEntity.notFound().build(); // devuelve 404 Not Found
		} else {
			fm.updaterPedido(pedido);
			return ResponseEntity.noContent().build(); //
		}
	}

}
