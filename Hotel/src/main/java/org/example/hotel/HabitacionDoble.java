package org.example.hotel;

public class HabitacionDoble extends Habitacion implements Reservable{
    public HabitacionDoble(double precioBase, int numHabitacion, String tipoHabitacion) {
        super(precioBase, numHabitacion,tipoHabitacion);
    }

    @Override
    public boolean verificarDisponibilidad() {
        return isDisponible();
    }

    @Override
    public double calcularPrecio() {
        return getPrecioBase()*1.5;
    }


}
