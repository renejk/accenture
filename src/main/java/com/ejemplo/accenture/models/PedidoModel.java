package com.ejemplo.accenture.models;

import com.ejemplo.accenture.models.*;

import java.time.LocalDateTime;
import java.util.*;

public class PedidoModel {

    private long id;
    private LocalDateTime fecha;
    private List<ProductoModel> products;
    private String estado;
    private double total;


    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<ProductoModel> getProducts() {
        return this.products;
    }

    public void setProducts(List<ProductoModel> products) {
        this.products = products;
    }


}