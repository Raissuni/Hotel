package org.example.hotel;

public class HabitacionIndividual extends Habitacion implements Reservable{
    public HabitacionIndividual(double precioBase, int numHabitacion, String tipoHabitacion) {
        super(precioBase, numHabitacion,tipoHabitacion);
    }

    @Override
    public boolean verificarDisponibilidad() {
        return isDisponible();
    }

    @Override
    public double calcularPrecio() {
        return getPrecioBase();
    }

}
