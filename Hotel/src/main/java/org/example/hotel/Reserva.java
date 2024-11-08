package org.example.hotel;

import java.io.Serializable;

public class Reserva implements Serializable {
    String nombre;
    String apellido;
    String correo_electronico;
    int numeroTel;
    String fecha_llegada;
    String fecha_salida;
    int numeroHabitacion;

    public Reserva(String nombre, String apellido, String correo_electronico, int numeroTel, String fecha_llegada, String fecha_salida, int numeroHabitacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo_electronico = correo_electronico;
        this.numeroTel = numeroTel;
        this.fecha_llegada = fecha_llegada;
        this.fecha_salida = fecha_salida;
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public int getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(int numeroTel) {
        this.numeroTel = numeroTel;
    }

    public String getFecha_llegada() {
        return fecha_llegada;
    }

    public void setFecha_llegada(String fecha_llegada) {
        this.fecha_llegada = fecha_llegada;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo_electronico='" + correo_electronico + '\'' +
                ", numeroTel=" + numeroTel +
                ", fecha_llegada='" + fecha_llegada + '\'' +
                ", fecha_salida='" + fecha_salida + '\'' +
                ", numeroHabitacion=" + numeroHabitacion +
                '}';
    }
}
