import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABMEquipo {
    static List<Jugador> listaJugador = new ArrayList<>();
    static List<Tecnico> listaTecnicos = new ArrayList<>();

    public static void main(String[] args) {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);

        while (!salir) {
            System.out.println("\nGestión de Equipos\n");
            System.out.println("1. Mostrar Jugadores por Equipo");
            System.out.println("2. Mostrar Técnicos");
            System.out.println("3. Salir");
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
        System.out.print("Ingrese el equipo para listar jugadores: ");
        String nombreEquipo = scanner.nextLine();

        System.out.println("Listado de jugadores del equipo '" + nombreEquipo + "':");
        for (Jugador jugador : listaJugador) {
            if (jugador.getEquipo().equalsIgnoreCase(nombreEquipo)) {
                System.out.println("Nombre: " + jugador.getNombre());
                System.out.println("Apellido: " + jugador.getApellido());
                System.out.println("Posición: " + jugador.getPosicion());
                System.out.println();
            }
        }
    }
}


