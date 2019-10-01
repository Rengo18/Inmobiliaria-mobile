package com.example.inmobiliaria;

public class Pago_item {
    private int pago;
    private String fecha;
    private double importe;

    public Pago_item(int pago, String fecha, double importe) {
        this.pago = pago;
        this.fecha = fecha;
        this.importe = importe;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
