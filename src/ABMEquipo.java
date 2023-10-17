import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABMEquipo {
    static List<Jugador> listaJugador = new ArrayList<>();
    static List<Tecnico> listaTecnicos = new ArrayList<>();
    static List<Equipo> listaEquipos = new ArrayList<>();

    public static void main(String[] args) {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);

        while (!salir) {
            System.out.println("\nGestión de Equipos\n");
            System.out.println("1. Mostrar Jugadores por Equipo");
            System.out.println("2. Mostrar Técnicos");
            System.out.println("3. Agregar equipo");
            System.out.println("4. Salir");
            System.out.print("\nSeleccione una opción: ");

            int opcion;
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea después del número
                switch (opcion) {
                    case 1:
                        listarJugadoresPorEquipo();
                        break;
                    case 2:
                        mostrarTecnicos();
                        break;
                    case 3:
                        agregarEquipo();
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo. \n");
                        break;
                }
            } else {
                System.out.println("Entrada no válida. Intente de nuevo. \n");
                scanner.nextLine(); // Consumir la entrada no válida
            }
        }
        scanner.close();
    }

    private static void agregarEquipo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos del equipo:");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        listaEquipos.add(new Equipo(nombre));
        mostrarEquipos();
    }

    static void mostrarEquipos() {
        System.out.println("Lista de Equipos:");
        if (listaEquipos.isEmpty()) {
            System.out.println("No hay Equipos registrados.");
        } else {
            for (Equipo equipo : listaEquipos) {
                System.out.println(equipo);
            }
        }
    }
    static void mostrarTecnicos() {
        System.out.println("Lista de Técnicos:");
        if (listaTecnicos.isEmpty()) {
            System.out.println("No hay técnicos registrados.");
        } else {
            for (Tecnico tecnico : listaTecnicos) {
                System.out.println(tecnico);
            }
        }
    }


    static void listarJugadoresPorEquipo() {
        Scanner scanner = new Scanner(System.in);
        for (Equipo equipo : listaEquipos) {
            System.out.println(equipo.getNombreE());
        }
        System.out.print("Seleccione un equipo por su nombre para mostrar: ");
        String nombreEquipo = scanner.nextLine();

        System.out.println("Listado de jugadores del equipo '" + nombreEquipo + "':");
        for (Jugador jugador : listaJugador) {
            if (jugador.getEquipo().equals(nombreEquipo)) {
                System.out.println("Nombre: " + jugador.getNombre());
                System.out.println("Apellido: " + jugador.getApellido());
                System.out.println("Posición: " + jugador.getPosicion());
                System.out.println();
            }
        }
    }
}


