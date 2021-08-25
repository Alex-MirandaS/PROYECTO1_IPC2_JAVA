/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASES;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Alex
 */
public class Venta {

    public String idVenta;
    public Date fechaVenta;
    public double precioMuebleVendido;
    public Cliente cliente;
    public Caja caja;
    public Factura factura;
    public SalaVenta salaVenta;

    public Venta(String idVenta, Date fechaVenta, double precioMuebleVendido, Cliente cliente, Caja caja, Factura factura, SalaVenta salaVenta) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.precioMuebleVendido = precioMuebleVendido;
        this.cliente = cliente;
        this.caja = caja;
        this.factura = factura;
        this.salaVenta = salaVenta;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getPrecioMuebleVendido() {
        return precioMuebleVendido;
    }

    public void setPrecioMuebleVendido(double precioMuebleVendido) {
        this.precioMuebleVendido = precioMuebleVendido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public SalaVenta getSalaVenta() {
        return salaVenta;
    }

    public void setSalaVenta(SalaVenta salaVenta) {
        this.salaVenta = salaVenta;
    }

}
