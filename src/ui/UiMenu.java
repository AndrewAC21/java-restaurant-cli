package ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 */
public class UiMenu {
    public static void mainMenu() {
        int response = 0;
        do {

            System.out.println("Bienvenido a la aplicación de reservas");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear reserva");
            System.out.println("2. Consultar reserva");
            System.out.println("3. Cancelar reserva");
            System.out.println("4. Salir");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            // sc.close();

            switch (response) {
                case 1:
                    crearReserva();
                    break;
                case 2:
                    consultarReserva();
                    break;
                case 3:
                    cancelarReserva();
                    break;
                case 4:
                    salir();
                    response = 0;
                    break;
                case 5:
                    showAll();
                    break;
                default:
                    System.out.println("Por favor escoja una opcion disponible");
            }

        } while (response != 0);
    }

    public static void crearReserva() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el id del cliente:");
        int idCliente = Integer.valueOf(sc.nextLine());
        System.out.println("Ingrese el nombre del cliente:");
        String nombreCliente = sc.nextLine();
        System.out.println("Ingrese el teléfono del cliente:");
        int telefonoCliente = Integer.valueOf(sc.nextLine());
        System.out.println("Ingrese el correo del cliente:");
        String correoCliente = sc.nextLine();
        System.out.println("Ingrese la fecha de la reserva (dd/mm/yyyy):");
        Date fechaReserva;
        try {
            fechaReserva = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
        } catch (ParseException e) {
            fechaReserva = new Date();
        }
        System.out.println("Ingrese la cantidad de personas:");
        int cantidadPersonas = Integer.valueOf(sc.nextLine());
        System.out.println("Ingrese el motivo de la reserva:");
        String motivo = sc.nextLine();
        System.out.println("Ingrese el tipo de decoración:");
        String tipoDecoracion = sc.nextLine();

        int reserva = Reserva.crearReservar(idCliente, nombreCliente, telefonoCliente, correoCliente, fechaReserva,
                cantidadPersonas, motivo, tipoDecoracion);

        System.out.println("Reserva creada con el id: " + reserva);
    }

    public static void consultarReserva() {
        int reservaNum = Integer.parseInt(System.console().readLine("Ingrese el id de la reserva:"));
        Reserva reserva = Reserva.consultarReserva(reservaNum);
        if (reserva != null) {
            System.out.println(reserva.toString());
        } else {
            System.out.println("No se encontró la reserva");
        }

    }

    public static void cancelarReserva() {
        int reservaNum = Integer.parseInt(System.console().readLine("Ingrese el id de la reserva:"));
        boolean cancelada = Reserva.cancelarReserva(reservaNum);
        if (cancelada) {
            System.out.println("Reserva cancelada");
        } else {
            System.out.println("No se encontró la reserva");
        }

    }

    public static void salir() {
        System.out.println("Gracias por usar la aplicación de reservas");
    }

    public static void showAll() {
        ArrayList<Reserva> reservas = Reserva.showAll();
        for (Reserva reserva : reservas) {
            System.out.println(reserva.toString());
        }
    }
}
