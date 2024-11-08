package org.example.hotel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hotel implements Serializable {
    ArrayList<Habitacion>habitaciones=new ArrayList<Habitacion>();
    ArrayList<Reserva>reservas=new ArrayList<Reserva>();

    public Hotel(ArrayList<Habitacion> habitaciones, ArrayList<Reserva> reservas) {
        this.habitaciones = habitaciones;
        this.reservas = reservas;
    }

    public Hotel() {

    }

    public void agregarHabitacion(Habitacion habitacion){
        habitaciones.add(habitacion);
    }
    public void registrarReserva(Reserva reserva){

        for(int i=0;i<habitaciones.size();i++){
            Habitacion habitacion=habitaciones.get(i);
            if (habitacion.numHabitacion==reserva.numeroHabitacion){
                habitacion.setDisponible(false);
                break;
            }
        }
    }
    public ArrayList<Reserva>mostrarReservas(){
        ArrayList<Reserva>resConfir=new ArrayList<>();
        return resConfir;
    }
    public List<Habitacion>mostrarHabitacionesDisponibles(){
        if (habitaciones.size()>0){
            ArrayList<Habitacion>aDevolver=new ArrayList<>();
            for (int i=0;i<habitaciones.size();i++){

                if (habitaciones.get(i).isDisponible()){
                    aDevolver.add(habitaciones.get(i));
                }
            }
            return aDevolver;
        }else {
            return null;
        }


    }
}
