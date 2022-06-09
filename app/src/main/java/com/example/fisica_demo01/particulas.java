package com.example.fisica_demo01;

public class particulas {

    private String nombre;
    private String simbolo;
    private double carga;
    private double masa;
    private String custom;


    public particulas(String nombre, double carga, double masa, String simbolo) {
        this.nombre = nombre;
        this.carga = carga;
        this.masa = masa;
        this.simbolo = simbolo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }

    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        this.masa = masa;
    }

    @Override
    public String toString() {
        custom = nombre + " / " + simbolo;
        return custom;
    }
}
