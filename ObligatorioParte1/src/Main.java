
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Jugador> listaJugador = new ArrayList<>();

    public static void main(String[] args) {

        boolean salir = false;
        Scanner scanner = new Scanner(System.in);

        while (!salir) {
            System.out.println("\nGestión de Partidos de Fútbol 5\n");
            System.out.println("1. Agregar Jugador");
            System.out.println("2. Agregar Técnico");
            System.out.println("3. Agregar Árbitro");
            System.out.println("4. Mostrar Jugadores por Equipo");
            System.out.println("5. Mostrar Árbitro del Partido");
            System.out.println("6. Salir");
            System.out.print("\nSeleccione una opción: ");

            int opcion;
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea después del número
                switch (opcion) {
                    case 1:
                        agregarJugador();
                        break;
                    case 2:
                        agregarTecnico();
                        break;
                    case 3:
                        agregarArbitro();
                        break;
                    case 4:
                        mostrarJugadoresPorEquipo();
                        break;
                    case 5:
                        mostrarArbitro();
                        break;
                    case 6:
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

    static void agregarJugador() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            System.out.println("Ingrese los datos del jugador:");

            System.out.print("Cédula: ");
            String cedula = scanner.nextLine();

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();

            System.out.print("Pocicion: ");
            String pocicion = scanner.nextLine();

            System.out.print("Equipo: ");
            String equipo = scanner.nextLine();


            listaJugador.add(new Jugador(cedula, nombre, apellido, pocicion, equipo));


        }
        mostrarListaJugadores();
    }
    static void mostrarListaJugadores() {
        System.out.println("Lista de Jugadores:");
        for (Jugador jugador : listaJugador) {
            System.out.println(jugador);
        }
    }
}
