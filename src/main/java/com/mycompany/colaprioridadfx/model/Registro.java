/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.colaprioridadfx.model;

/**
 *
 * @author Admin
 */
public class Registro {

    private String nombre;
    private int prioridad;

    public Registro(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;

    }

    public String getNombre() {
        return nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {
        return "Registro{" + "nombre=" + nombre + ", prioridad=" + prioridad + '}';
    }

    

}
