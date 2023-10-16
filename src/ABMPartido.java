import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABMPartido {
    static List<Partido> listaPartidos = new ArrayList<>();
    static List<Arbitro> listaArbitros = new ArrayList<>();
    public static void main(String[] args) {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);

        while (!salir) {
            System.out.println("\nRealización de Partido\n");
            System.out.println("1. Agregar Partido");
            System.out.println("2. Eliminar Partido");
            System.out.println("3. Modificar Partido");
            System.out.println("4. Mostrar Partido por fecha");
            System.out.println("5. Buscar Jugador por fecha");
            System.out.println("6. Salir");
            System.out.print("\nSeleccione una opción: ");

            int opcion;
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea después del número
                switch (opcion) {
                    case 1:
                        agregarPartido();
                        break;
                    case 2:
                        eliminarPartido();
                        break;
                    case 3:
                        modificarPartido();
                        break;
                    case 4:
                        mostrarPartidoPorFecha();
                        break;
                    case 5:
                        buscarPartidoPorFecha();
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



    static void agregarPartido() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos del partido:");

        System.out.print("Fecha(con barra): ");
        String fecha = scanner.nextLine();

        System.out.print("hora: ");
        String hora = scanner.nextLine();

        System.out.print("EquipoA: ");
        String EquipoA = scanner.nextLine();

        System.out.print("EquipoB: ");
        String EquipoB = scanner.nextLine();

        System.out.println("Árbitros disponibles:");
        for (Arbitro arbitro : listaArbitros) {
            System.out.println(arbitro.getNombre());
        }
        System.out.print("Seleccione un árbitro por su nombre: ");
        String nombreArbitro = scanner.nextLine();

        Arbitro arbitroSeleccionado = null;
        for (Arbitro arbitro : listaArbitros) {
            if (arbitro.getNombre().equalsIgnoreCase(nombreArbitro)) {
                arbitroSeleccionado = arbitro;
                break;
            }
        }

        if (arbitroSeleccionado != null) {
            listaPartidos.add(new Partido(fecha, hora, EquipoA, EquipoB, arbitroSeleccionado));
            System.out.println("Partido agregado con éxito.");
        } else {
            System.out.println("Árbitro no encontrado. El partido no se ha creado.");
        }
    }
    private static void buscarPartidoPorFecha() {
    }

    private static void mostrarPartidoPorFecha() {
    }

    private static void modificarPartido() {
    }

    private static void eliminarPartido() {
    }
}
