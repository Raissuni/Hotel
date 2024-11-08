package org.example.hotel;

public class Suite extends Habitacion implements Reservable {
    public Suite(double precioBase, int numHabitacion, String tipoHabitacion) {
        super(precioBase, numHabitacion,tipoHabitacion);
    }

    @Override
    public boolean verificarDisponibilidad() {
        return isDisponible();
    }

    @Override
    public double calcularPrecio() {
        return getPrecioBase()*2;
    }
}
