package com.logica;

import conexiones.ConexionBD;
import entidades.Cliente;
import entidades.Pedido;
import entidades.Producto;
import entidades.Venta;
import interfaces.IModeloCliente;
import interfaces.IModeloPedido;
import interfaces.IModeloProducto;
import interfaces.IModeloVenta;
import modelos.ModeloCliente;
import modelos.ModeloPedido;
import modelos.ModeloProducto;
import modelos.ModeoVenta;

import java.util.List;

public class FachadaModelo {
    ConexionBD conexionPedido = new ConexionBD();
    ConexionBD conexionCliente = new ConexionBD();
    ConexionBD conexionProducto = new ConexionBD();
    ConexionBD conexionVenta = new ConexionBD();
    IModeloPedido mpedido;
    IModeloCliente mcliente;
    IModeloProducto mproducto;
    IModeloVenta mventa;

    public FachadaModelo() {
        this.mpedido = new ModeloPedido(conexionPedido);
        this.mcliente = new ModeloCliente(conexionCliente);
        this.mproducto = new ModeloProducto(conexionProducto);
        this.mventa = new ModeoVenta(conexionVenta);
    } 
 
    //Pedidos
    public Pedido getPedidoById(int i) {
        return mpedido.consultar(i);
    }
    public List<Pedido> getPedidos() {
        return mpedido.consultar();
    }
    public void deletePedido(Pedido pedido) throws Exception {
        mpedido.eliminar(pedido);
    }
    public Pedido updaterPedido(Pedido pedido) {
       return mpedido.actualizar(pedido);
    }
    public Pedido addPedido(Pedido pedido) {
        return mpedido.registrar(pedido);
    }


    //Clientes
    public Cliente getClienteById(int i) {
        return mcliente.consultar(i);
    }
    public List<Cliente> getClientes() {
        return mcliente.consultar();
    }
    public Cliente deleteCliente(Cliente cliente) {
        return mcliente.eliminar(cliente);
    }
    public Cliente updateCliente(Cliente cliente) {
        return mcliente.actualizar(cliente);
    }
    public Cliente addCliente(Cliente cliente) {
        return mcliente.registrar(cliente);
    }


    //Productos
    public Producto getProductoById(int i) {
        return mproducto.consultar(i);
    }
    public List<Producto> getProductos() {
        return mproducto.consultar();
    }
    public Producto deleteProducto(Producto producto) {
        return mproducto.eliminar(producto);
    }
    public Producto updateProducto(Producto producto) {
        return mproducto.actualizar(producto);
    }
    public Producto addProducto(Producto producto) {
        return mproducto.registrar(producto);
    }

    //Ventas
    public Venta getVentaById(int i) {
        return mventa.consultar(i);
    }
    public List<Venta> getVentas() {
        return mventa.consultar();
    }
    public Venta deleteVenta(Venta venta) {
        return mventa.eliminar(venta);
    }
    public Venta updateVenta(Venta venta) {
        return mventa.actualizar(venta);
    }
    public Venta addVenta(Venta venta) {
        return mventa.registrar(venta);
    }

}
