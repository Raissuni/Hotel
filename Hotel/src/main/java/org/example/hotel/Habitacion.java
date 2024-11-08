package org.example.hotel;

import java.io.Serializable;

public abstract class Habitacion implements Serializable {
    boolean disponible;
    double precioBase;
    int numHabitacion;
    String tipoHabitacion;

    static final int NUM_HAB=20;

    public Habitacion(double precioBase, int numHabitacion, String tipoHabitacion) {
        this.disponible = true;
        this.precioBase = precioBase;
        this.numHabitacion = numHabitacion;
        this.tipoHabitacion=tipoHabitacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public String setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
        return null;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public abstract double calcularPrecio();

    @Override
    public String toString() {
        return "Habitacion{" +
                "disponible=" + disponible +
                ", precioBase=" + precioBase +
                ", numHabitacion=" + numHabitacion +
                ", tipoHabitacion='" + tipoHabitacion + '\'' +
                '}';
    }

    public String getText() {
        return setNumHabitacion(numHabitacion);
    }
}
