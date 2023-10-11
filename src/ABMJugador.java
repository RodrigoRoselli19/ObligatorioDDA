
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ABMJugador {
    static List<Jugador> listaJugador = new ArrayList<>();
    public static void main(String[] args) {
            boolean salir = false;
            Scanner scanner = new Scanner(System.in);

            while (!salir) {
                System.out.println("\nGestión de Lista de Personas\n");
                System.out.println("1. Agregar Jugador");
                System.out.println("2. Eliminar Jugador");
                System.out.println("3. Modificar Jugador");
                System.out.println("4. Mostrar Jugadores");
                System.out.println("4. Mostrar Jugadores por Equipo");
                System.out.println("5. Buscar Jugador por Nombre o ID");
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
                            eliminarJugador();
                            break;
                        case 3:
                            modificarJugador();
                            break;
                        case 4:
                            mostrarJugadoresPorPosicion();
                            break;
                        case 5:
                            buscarJugador();
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

            System.out.print("Posicion: ");
            String posicion = scanner.nextLine();

            System.out.print("Equipo: ");
            String equipo = scanner.nextLine();


            listaJugador.add(new Jugador(cedula, nombre, apellido, posicion, equipo));


        }
        mostrarListaJugadores();
    }
    static void mostrarListaJugadores() {
        System.out.println("Lista de Jugadores:");
        for (Jugador jugador : listaJugador) {
            System.out.println(jugador);
        }
    }
    static void eliminarJugador() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione cómo desea eliminar al jugador:");
        System.out.println("1. Por CI");
        System.out.println("2. Por Nombre");
        System.out.println("3. Por Apellido");
        System.out.print("Seleccione una opción: ");

        int opcionEliminar = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después del número

        switch (opcionEliminar) {
            case 1:
                System.out.print("Ingrese la CI a eliminar: ");
                int CIaEliminar = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea después del número

                if (CIaEliminar >= 0 && CIaEliminar < listaJugador.size()) {
                    listaJugador.remove(CIaEliminar - 1);
                    mostrarListaJugadores();
                } else {
                    System.out.println("Cedula fuera de rango. \n");
                }
                break;
            case 2:
                System.out.print("Ingrese el nombre a eliminar: ");
                String nombreEliminar = scanner.nextLine();

                Jugador jugadorPorNombre = null;
                for (Jugador jugador : listaJugador) {
                    if (jugador.getNombre().equals(nombreEliminar)) {
                        jugadorPorNombre = jugador;
                        break;
                    }
                }

                if (jugadorPorNombre != null) {
                    listaJugador.remove(jugadorPorNombre);
                    mostrarListaJugadores();
                } else {
                    System.out.println("Nombre no encontrado. \n");
                }
                break;
            case 3:
                System.out.print("Ingrese el apellido a eliminar: ");
                String apellidoEliminar = scanner.nextLine();

                Jugador jugadorPorApellido = null;
                for (Jugador jugador : listaJugador) {
                    if (jugador.getNombre().equals(apellidoEliminar)) {
                        jugadorPorApellido = jugador;
                        break;
                    }
                }

                if (jugadorPorApellido != null) {
                    listaJugador.remove(jugadorPorApellido);
                    mostrarListaJugadores();
                } else {
                    System.out.println("Apellido no encontrado. \n");
                }
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo. \n");
                break;
        }
    }

    static void modificarJugador() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cedula del jugador que desea modificar: ");
        String ciModificar = scanner.nextLine();
        scanner.nextLine(); // Consumir la nueva línea después del número

        Jugador jugadorAModificar = null;
        for (Jugador jugador : listaJugador) {
            if (jugador.getCedula().equals(ciModificar)) {
                jugadorAModificar = jugador;
                break;
            }
        }

        if (jugadorAModificar != null) {
            System.out.println("Datos actuales del jugador: " + jugadorAModificar);
            System.out.println("Ingrese los nuevos datos:");
            System.out.print("Nombre: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Apellido: ");
            String nuevoApellido = scanner.nextLine();
            System.out.print("Posicion: ");
            String nuevaPosicion = scanner.nextLine();
            System.out.print("Equipo: ");
            String nuevoEquipo = scanner.nextLine();
            scanner.nextLine(); // Consumir la nueva línea después del número

            jugadorAModificar.setNombre(nuevoNombre);
            jugadorAModificar.setApellido(nuevoApellido);
            jugadorAModificar.setPosicion(nuevaPosicion);
            jugadorAModificar.setEquipo(nuevoEquipo);
            mostrarListaJugadores();
        } else {
            System.out.println("Cedula no encontrada. \n");
        }
    }
    static void mostrarJugadoresPorPosicion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la posición: ");
        int posicion = scanner.nextInt();

        if (posicion >= 0 && posicion < listaJugador.size()) {
            System.out.println(listaJugador.get(posicion - 1));
        } else {
            System.out.println("Posición fuera de rango. \n");
        }
    }
    static void buscarJugador() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione cómo desea buscar al jugador:");
        System.out.println("1. Por Nombre");
        System.out.println("2. Por cedula");
        System.out.print("Seleccione una opción: ");

        int opcionBuscar = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después del número

        switch (opcionBuscar) {
            case 1:
                System.out.print("Ingrese el nombre a buscar: ");
                String nombreBuscar = scanner.nextLine();

                List<Jugador> jugadoresPorNombre = new ArrayList<>();
                for (Jugador jugador : listaJugador) {
                    if (jugador.getNombre().equals(nombreBuscar)) {
                        jugadoresPorNombre.add(jugador);
                    }
                }

                if (!jugadoresPorNombre.isEmpty()) {
                    System.out.println("Jugadores encontrados:");
                    for (Jugador jugador : jugadoresPorNombre) {
                        System.out.println(jugador);
                    }
                } else {
                    System.out.println("Nombre no encontrado. \n");
                }
                break;
            case 2:
                System.out.print("Ingrese la cedula a buscar: ");
                String ciBuscar = scanner.nextLine();
                scanner.nextLine(); // Consumir la nueva línea después del número

                Jugador jugadorCI = null;
                for (Jugador jugador : listaJugador) {
                    if (jugador.getCedula().equals(ciBuscar)) {
                        jugadorCI = jugador;
                        break;
                    }
                }

                if (jugadorCI != null) {
                    System.out.println(jugadorCI);
                } else {
                    System.out.println("Cedula no encontrado. \n");
                }
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo. \n");
                break;
        }
    }
}

