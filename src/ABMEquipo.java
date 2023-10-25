import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class ABMEquipo {
    static List<Jugador> listaJugador = new ArrayList<>();
    static List<Tecnico> listaTecnicos = new ArrayList<>();
    static List<Equipo> listaEquipos = new ArrayList<>();
    private static final String EQUIPOS_FILENAME = "equipos.txt";

    public static void main(String[] args) {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);

        cargarEquipos();
        mostrarEquipos();
        while (!salir) {
            System.out.println("\nGestión de Equipos\n");
            System.out.println("1. Agregar equipo");
            System.out.println("2. Eliminar equipo");
            System.out.println("3. Mostrar Jugadores por Equipo");
            System.out.println("4. Salir");
            System.out.print("\nSeleccione una opción: ");

            int opcion;
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea después del número
                switch (opcion) {
                    case 1:
                        agregarEquipo();
                        break;
                    case 2:
                        eliminarEquipo();
                        break;
                    case 3:
                        listarJugadoresPorEquipo();
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
        guardarEquipos();
    }

    static void mostrarEquipos() {
        System.out.println("\n Lista de Equipos:");
        if (listaEquipos.isEmpty()) {
            System.out.println("No hay Equipos registrados.");
        } else {
            for (Equipo equipo : listaEquipos) {
                System.out.println(equipo);
            }
        }
    }
    // Método para guardar la lista de equipos en un archivo de texto
    private static void guardarEquipos() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(EQUIPOS_FILENAME))) {
            for (Equipo equipo : listaEquipos) {
                writer.println(equipo.getNombreE());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Método para cargar la lista de equipos desde un archivo de texto
    private static void cargarEquipos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(EQUIPOS_FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                listaEquipos.add(new Equipo(line));
            }
        } catch (IOException e) {
            // Manejo de excepciones en caso de fallo (puede no haber un archivo al inicio)
        }
    }
    static void eliminarEquipo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del equipo que desea eliminar: ");
        String nombre = scanner.nextLine();
        Equipo[] arrayEquipo = listaEquipos.toArray(new Equipo[0]);
        for (Equipo equipo : listaEquipos) {
            if (arrayEquipo[0].equals(nombre)) {
                arrayEquipo[0] = equipo;
                break;
            }
        }

        if (arrayEquipo[0] != null) {
            listaEquipos.remove(arrayEquipo[0]);
            mostrarEquipos();
            guardarEquipos();
        } else {
            System.out.println("Equipo no encontrado. \n");
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


