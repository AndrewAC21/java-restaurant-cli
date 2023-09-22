package ui;

import java.util.ArrayList;
import java.util.Date;

public class Reserva {
    static int count = 0;
    int id;
    int idCliente;
    String nombreCliente;
    int telefonoCliente;
    String correoCliente;
    Date fechaReserva;
    String estado = "activa";
    int cantidadPersonas;
    String motivo;
    String tipoDecoracion;

    static ArrayList<Reserva> reservas = new ArrayList<>();

    public Reserva(int idCliente, String nombreCliente, int telefonoCliente, String correoCliente,
            Date fechaReserva, int cantidadPersonas, String motivo, String tipoDecoracion) {
        this.id = count + 1;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.correoCliente = correoCliente;
        this.fechaReserva = fechaReserva;
        this.estado = "activa";
        this.cantidadPersonas = cantidadPersonas;
        this.motivo = motivo;
        this.tipoDecoracion = tipoDecoracion;
    }

    public static int crearReservar(int idCliente, String nombreCliente, int telefonoCliente, String correoCliente,
            Date fechaReserva, int cantidadPersonas, String motivo, String tipoDecoracion) {

        Reserva reserva = new Reserva(idCliente, nombreCliente, telefonoCliente, correoCliente, fechaReserva,
                cantidadPersonas, motivo, tipoDecoracion);

        reservas.add(reserva);
        count++;
        return reserva.id;
    }

    public static Reserva consultarReserva(int id) {
        for (Reserva reserva : reservas) {
            if (reserva.id == id) {
                return reserva;
            }
        }
        return null;
    }

    public static boolean cancelarReserva(int id) {
        for (Reserva reserva : reservas) {
            if (reserva.id == id) {
                reserva.estado = "cancelada";
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Reserva> showAll() {
        return reservas;
    }

    @Override
    public String toString() {
        return "Reserva: " + id + ", a nombre de: " + nombreCliente + ", para el dia " + fechaReserva
                + ", la cual está:" + estado;
    }
}
