import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ABMJugador {
    static List<Jugador> listaJugador = new ArrayList<>();
    static List<Equipo> listaEquipos = new ArrayList<>();
    private static final String JUGADORES_FILENAME = "jugadores.txt";
    public static void main(String[] args) {
            boolean salir = false;
            Scanner scanner = new Scanner(System.in);
            cargarJugadores();
            cargarEquipos();
            mostrarListaJugadores();
            while (!salir) {
                System.out.println("\nGestión de Lista de Jugador\n");
                System.out.println("1. Agregar Jugador");
                System.out.println("2. Eliminar Jugador");
                System.out.println("3. Modificar Jugador");
                System.out.println("4. Mostrar Jugadores por posicion");
                System.out.println("5. Buscar Jugador por Nombre o ID");
                System.out.println("6. Calcular salario de jugador");
                System.out.println("7. Precalentar");
                System.out.println("8. Salir");
                System.out.print("\nSeleccione una opción: \n");
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
                            calcularSalario();
                            break;
                        case 7:
                            precalentar();
                            break;
                        case 8:
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

     static void precalentar() {
         Scanner scanner = new Scanner(System.in);
         System.out.print("Ingrese el nombre del jugador que precalentará: ");
         String nombreJugador = scanner.nextLine();
         boolean jugadorEncontrado = false;

         for (Jugador jugador : listaJugador) {
             if (jugador.getNombre().equalsIgnoreCase(nombreJugador)) {
                 jugador.precalentar();
                 jugadorEncontrado = true;
                 break;
             }
         }

         if (!jugadorEncontrado) {
             System.out.println("Jugador no encontrado.");
         }
     }

    static void calcularSalario() {
        System.out.println("Calculando salarios para todos los jugadores:\n");

        if (listaJugador.isEmpty()) {
            System.out.println("No hay jugadores en la lista.");
        } else {
            for (Jugador jugador : listaJugador) {
                double salario = jugador.calcularSalario();
                System.out.println(jugador.getNombre() + " - Salario: $" + salario);
            }
        }
    }


    static void agregarJugador() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Ingrese los datos del jugador:");

                System.out.print("Cédula: ");
                String cedula = scanner.nextLine();

                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();

                System.out.print("Apellido: ");
                String apellido = scanner.nextLine();

                System.out.print("Salario: ");
                double salario = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Posicion: ");
                String posicion = scanner.nextLine();

                System.out.println("Equipos disponibles:");
                for (Equipo equipo : listaEquipos) {
                    System.out.println(equipo.getNombreE());
                 }
                System.out.print("Seleccione un equipo por su nombre: ");
                String nombreEquipo = scanner.nextLine();

                Equipo equipoSeleccionado = null;
                for (Equipo equipo : listaEquipos) {
                if (equipo.getNombreE().equalsIgnoreCase(nombreEquipo)) {
                equipoSeleccionado = equipo;
                break;
                    }
                }
        if (equipoSeleccionado != null) {
            // Asegurarte de que el equipo seleccionado sea válido antes de agregar el jugador
            int jugadoresPorEquipo = 0;

            for (Jugador jugador : listaJugador) {
                if (jugador.getEquipo() != null && jugador.getEquipo().equals(equipoSeleccionado)) {
                    jugadoresPorEquipo++;
                }
            }

            if (jugadoresPorEquipo < 7) {
                Jugador nuevoJugador = new Jugador(cedula, nombre, apellido, salario, posicion, equipoSeleccionado);
                listaJugador.add(nuevoJugador);
                System.out.println("Jugador agregado: " + nuevoJugador);
                mostrarListaJugadores();
                guardarJugadores();
            } else {
                System.out.println("Ya ha superado el máximo de jugadores (7) para este equipo.");
            }
        } else {
            System.out.println("Equipo no encontrado. No se pudo agregar el jugador.");
            }
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
                String CIaEliminar = scanner.nextLine();
                scanner.nextLine(); // Consumir la nueva línea después del número
                Jugador[] arrayJugador = listaJugador.toArray(new Jugador[0]);
                if (arrayJugador[0].equals(CIaEliminar)) {
                    listaJugador.remove(arrayJugador[0]);
                    mostrarListaJugadores();
                    guardarJugadores();
                } else {
                    System.out.println("Cedula fuera de rango. \n");
                }
                break;
            case 2:
                System.out.print("Ingrese el nombre a eliminar: ");
                String nombreEliminar = scanner.nextLine();
                Jugador[] arrayJugadorN = listaJugador.toArray(new Jugador[1]);
                for (Jugador jugador : listaJugador) {
                    if (arrayJugadorN[1].equals(nombreEliminar)) {
                        arrayJugadorN[1] = jugador;
                        break;
                    }
                }

                if (arrayJugadorN[1] != null) {
                    listaJugador.remove(arrayJugadorN[1]);
                    mostrarListaJugadores();
                    guardarJugadores();
                } else {
                    System.out.println("Nombre no encontrado. \n");
                }
                break;
            case 3:
                System.out.print("Ingrese el apellido a eliminar: ");
                String apellidoEliminar = scanner.nextLine();
                Jugador[] arrayJugadorA = listaJugador.toArray(new Jugador[2]);
                for (Jugador jugador : listaJugador) {
                    if (arrayJugadorA[2].equals(apellidoEliminar)) {
                        arrayJugadorA[2] = jugador;
                        break;
                    }
                }

                if (arrayJugadorA[2] != null) {
                    listaJugador.remove(arrayJugadorA[2]);
                    mostrarListaJugadores();
                    guardarJugadores();
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
                guardarJugadores();
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
            System.out.print("Salario: ");
            double nuevoSalario = scanner.nextInt();
            System.out.print("Posicion: ");
            String nuevaPosicion = scanner.nextLine();
            System.out.println("Equipos disponibles:");
            for (Equipo equipo : listaEquipos) {
                System.out.println(equipo.getNombreE());
            }
            System.out.print("Seleccione un equipo por su nombre: ");
            String nombreEquipo = scanner.nextLine();

            Equipo equipoSeleccionado = null;
            for (Equipo equipo : listaEquipos) {
                if (equipo.getNombreE().equalsIgnoreCase(nombreEquipo)) {
                    equipoSeleccionado = equipo;
                    break;
                }
            }
            scanner.nextLine(); // Consumir la nueva línea después del número

            jugadorAModificar.setNombre(nuevoNombre);
            jugadorAModificar.setApellido(nuevoApellido);
            jugadorAModificar.setSalario(nuevoSalario);
            jugadorAModificar.setPosicion(nuevaPosicion);
            jugadorAModificar.setEquipo(equipoSeleccionado);
            mostrarListaJugadores();
        } else {
            System.out.println("Cedula no encontrada. \n");
        }
    }
    static void mostrarJugadoresPorPosicion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la posición: ");
        String posicion = scanner.nextLine();
        for (Jugador jugador : listaJugador)
            if (jugador.getPosicion().equals(posicion)) {
            System.out.println(jugador);
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
    // Método para guardar la lista de equipos en un archivo de texto
    private static void guardarJugadores() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(JUGADORES_FILENAME))) {
            for (Jugador jugador : listaJugador) {
                writer.println(jugador.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Método para cargar la lista de equipos desde un archivo de texto
    private static void cargarJugadores() {
        cargarEquipos();
        try (BufferedReader reader = new BufferedReader(new FileReader(JUGADORES_FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("'");
                String cedula = parts[2];
                String nombre = parts[4];
                String apellido = parts[6];
                double salario = Double.parseDouble(parts[8]);
                String posicion = parts[10];
                String nombreE = parts[12];
                Equipo equipo = buscarEquipoPorNombre(nombreE);

                listaJugador.add(new Jugador(cedula, nombre, apellido, salario, posicion, equipo));
            }
        } catch (IOException e) {
            // Manejo de excepciones en caso de fallo (puede no haber un archivo al inicio)
        }
    }
    private static Equipo buscarEquipoPorNombre(String nombreE) {
        for (Equipo e : listaEquipos) {
            if (e.getNombreE().equalsIgnoreCase(nombreE)) {
                return e;
            }
        }
        return null;
    }
    private static void cargarEquipos() {
        try (BufferedReader reader = new BufferedReader(new FileReader("equipos.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                listaEquipos.add(new Equipo(line));
            }
        } catch (IOException e) {
            // Manejo de excepciones en caso de fallo (puede no haber un archivo al inicio)
        }
    }
}

