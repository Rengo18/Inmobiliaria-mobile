package com.example.inmobiliaria;

public class Contrato_item {
    private String fecha_inicio;
    private String fecha_cierre;
    private double importe;

    public Contrato_item(String fecha_inicio, String fecha_cierre, double importe) {
        this.fecha_inicio = fecha_inicio;
        this.fecha_cierre = fecha_cierre;
        this.importe = importe;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_cierre() {
        return fecha_cierre;
    }

    public void setFecha_cierre(String fecha_cierre) {
        this.fecha_cierre = fecha_cierre;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
