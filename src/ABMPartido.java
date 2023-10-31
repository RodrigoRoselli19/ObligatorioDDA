import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ABMPartido {
    static List<Partido> listaPartidos = new ArrayList<>();
    static List<Arbitro> listaArbitro = new ArrayList<>();
    static List<Equipo> listaEquipos = new ArrayList<>();
    private static final String PARTIDOS_FILENAME = "partidos.txt";
    private static final String ARBITROS_FILENAME = "arbitros.txt";

    public static void main(String[] args) {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);
        cargarPartidos();
        while (!salir) {
            System.out.println("\nRealización de Partido\n");
            System.out.println("1. Agregar Partido");
            System.out.println("2. Eliminar Partido");
            System.out.println("3. Modificar Partido");
            System.out.println("4. Mostrar Partidos");
            System.out.println("5. Buscar Partido por fecha");
            System.out.println("6. Mostrar arbitro del partido");
            System.out.println("7. Salir");
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
                        mostrarArbitroDelPartido();
                        break;
                    case 7:
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

     static void mostrarArbitroDelPartido() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la fecha del partido: ");
        String fechaPartido = scanner.nextLine();
        boolean partidoEncontrado = false;

        for (Partido partido : listaPartidos) {
            if (partido.getFecha().equalsIgnoreCase(fechaPartido)) {
                System.out.println("Árbitro del partido: " + partido.getArbitro());
                partidoEncontrado = true;
                break;
            }
        }

        if (!partidoEncontrado) {
            System.out.println("Partido no encontrado.");
        }
    }



    static void agregarPartido() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos del partido:");

        System.out.print("Fecha: ");
        String fecha = scanner.nextLine();

        System.out.print("hora: ");
        String hora = scanner.nextLine();

        System.out.println("Equipos disponibles:");
        for (Equipo equipo : listaEquipos) {
            System.out.println(equipo.getNombreE());
        }

        System.out.print("Seleccione el primer equipo por su nombre: ");
        String nombreEquipoA = scanner.nextLine();
        Equipo equipoSeleccionadoA = buscarEquipoPorNombre(nombreEquipoA);

        listaEquipos.removeIf(equipo -> equipo.equals(equipoSeleccionadoA));

        System.out.println("Equipos disponibles:");
        for (Equipo equipo : listaEquipos) {
            System.out.println(equipo.getNombreE());
        }

        System.out.print("Seleccione el segundo equipo por su nombre: ");
        String nombreEquipoB = scanner.nextLine();
        Equipo equipoSeleccionadoB = buscarEquipoPorNombre(nombreEquipoB);

        System.out.println("Árbitros disponibles:");
        for (Arbitro arbitro : listaArbitro) {
            System.out.println(arbitro.getNombre());
        }
        System.out.print("Seleccione un árbitro por su nombre: ");
        String nombreArbitro = scanner.nextLine();

        Arbitro arbitroSeleccionado = buscarArbitroPorNombre(nombreArbitro);

        if (arbitroSeleccionado != null || equipoSeleccionadoA != null || equipoSeleccionadoB != null) {
            listaPartidos.add(new Partido(fecha, hora, equipoSeleccionadoA, equipoSeleccionadoB, arbitroSeleccionado));
            System.out.println("Partido agregado con éxito.");
            mostrarPartidos();
            guardarPartidos();
        } else {
            System.out.println("Árbitro no encontrado. El partido no se ha creado.");
        }
    }

    static void mostrarPartidos(){
        System.out.println("Lista de Partidos:");
        for (Partido partido : listaPartidos) {
            System.out.println(partido);
        }
    }
    static void buscarPartidoPorFecha() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la fecha del partido a buscar: ");
        String fechaBuscar = scanner.nextLine();

        for (Partido partido : listaPartidos) {
            if (partido.getFecha().equalsIgnoreCase(fechaBuscar)) {
                System.out.println("Partido encontrado:\n" + partido);
                return;
            }
        }

        System.out.println("No se encontró un partido con la fecha especificada.");
    }

    static void mostrarPartidoPorFecha() {
        System.out.print("Lista de Partidos: ");
        for (Partido partido : listaPartidos) {
            System.out.println(partido.toString());
        }
    }

    static void modificarPartido() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la fecha del partido que desea modificar: ");
        String fechaModificar = scanner.nextLine();

        for (Partido partido : listaPartidos) {
            if (partido.getFecha().equalsIgnoreCase(fechaModificar)) {
                System.out.println("Datos actuales del partido:\n" + partido);
                System.out.println("Ingrese los nuevos datos:");

                System.out.print("Nueva fecha: ");
                String nuevaFecha = scanner.nextLine();

                System.out.print("Nueva hora: ");
                String nuevaHora = scanner.nextLine();

                System.out.println("Equipos disponibles:");
                for (Equipo equipo : listaEquipos) {
                    System.out.println(equipo.getNombreE());
                }
                System.out.print("Seleccione un equipo por su nombre: ");
                String nombreEquipoA = scanner.nextLine();

                Equipo equipoSeleccionadoB = null;
                for (Equipo equipo : listaEquipos) {
                    if (equipo.getNombreE().equalsIgnoreCase(nombreEquipoA)) {
                        equipoSeleccionadoB = equipo;
                        break;
                    }
                }

                System.out.println("Equipos disponibles:");
                for (Equipo equipo : listaEquipos) {
                    System.out.println(equipo.getNombreE());
                }
                System.out.print("Seleccione un equipo por su nombre: ");
                String nombreEquipoB = scanner.nextLine();

                Equipo equipoSeleccionadoA = null;
                for (Equipo equipo : listaEquipos) {
                    if (equipo.getNombreE().equalsIgnoreCase(nombreEquipoB)) {
                        equipoSeleccionadoA = equipo;
                        break;
                    }
                }

                System.out.println("Árbitros disponibles:");
                for (Arbitro arbitro : listaArbitro) {
                    System.out.println(arbitro.getNombre());
                }
                System.out.print("Seleccione un árbitro por su nombre: ");
                String nombreArbitro = scanner.nextLine();

                Arbitro arbitroSeleccionado = null;
                for (Arbitro arbitro : listaArbitro) {
                    if (arbitro.getNombre().equalsIgnoreCase(nombreArbitro)) {
                        arbitroSeleccionado = arbitro;
                        break;
                    }
                }

                if (arbitroSeleccionado != null) {
                    partido.setFecha(nuevaFecha);
                    partido.setHora(nuevaHora);
                    partido.setEquipoA(equipoSeleccionadoA);
                    partido.setEquipoB(equipoSeleccionadoB);
                    partido.setArbitro(arbitroSeleccionado);
                    guardarPartidos();
                    System.out.println("Partido modificado con éxito.");
                } else {
                    System.out.println("Árbitro no encontrado. El partido no se ha modificado.");
                }

                return;
            }
        }

        System.out.println("No se encontró un partido con la fecha especificada.");
    }

    static void eliminarPartido() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la fecha del partido que desea eliminar: ");
        String fechaEliminar = scanner.nextLine();

        for (Partido partido : listaPartidos) {
            if (partido.getFecha().equalsIgnoreCase(fechaEliminar)) {
                listaPartidos.remove(partido);
                guardarPartidos();
                System.out.println("Partido eliminado con éxito.");
                return;
            }
        }
        System.out.println("No se encontró un partido con la fecha especificada.");
    }
    // Método para guardar la lista de equipos en un archivo de texto
    private static void guardarPartidos() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(PARTIDOS_FILENAME))) {
            for (Partido partido : listaPartidos) {
                writer.println(partido.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Método para cargar la lista de equipos desde un archivo de texto
    private static void cargarPartidos() {
        cargarArbitros();
        cargarEquipos();
        try (BufferedReader reader = new BufferedReader(new FileReader(PARTIDOS_FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null){
                String[] parts = line.split("'");
                String fecha = parts[1];
                String hora = parts[3];
                String nombreA = parts[5];
                Equipo equipoA = null;
                for (Equipo A : listaEquipos) {
                    if (A.getNombreE().equals(nombreA)) {
                        equipoA = A;
                        break;
                    }
                }
                Equipo equipoB = null;
                String nombreB = parts[8];
                for (Equipo B : listaEquipos) {
                    if (B.getNombreE().equals(nombreB)) {
                        equipoB = B;
                        break;
                    }
                }
                String nombreArbitro = parts[10];
                Arbitro arbitro = buscarArbitroPorNombre(nombreArbitro);
                listaPartidos.add(new Partido(fecha, hora, equipoA, equipoB, arbitro));
            }
        } catch (IOException e) {
            System.out.println("No se pueden cargar los partidos"+ e.getMessage());// Manejo de excepciones en caso de fallo (puede no haber un archivo al inicio)
        }
    }
    private static Arbitro buscarArbitroPorNombre(String nombreArbitro) {
        for (Arbitro a : listaArbitro) {
            if (a.getNombre().equalsIgnoreCase(nombreArbitro)) {
                return a;
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
            System.out.println("No se pueden cargar los equipos"+ e.getMessage());// Manejo de excepciones en caso de fallo (puede no haber un archivo al inicio)
        }
    }
    private static void cargarArbitros() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARBITROS_FILENAME))) {
            String cedula;
            String nombre;
            String apellido;
            double salario;
            int exp;

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("'"); // Separa los valores basados en la coma y espacio
                cedula = parts[1];
                nombre = parts[3];
                apellido = parts[5];
                salario = Double.parseDouble(parts[7]);
                exp = Integer.parseInt(parts[11]);

                listaArbitro.add(new Arbitro(cedula, nombre, apellido, salario, exp));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los datos de los árbitros.");
        }
    }
    private static Equipo buscarEquipoPorNombre(String nombreEquipo) {
        for (Equipo equipo : listaEquipos) {
            if (equipo.getNombreE().equalsIgnoreCase(nombreEquipo)) {
                return equipo;
            }
        }
        return null; // Si el equipo no se encuentra, se devuelve null
    }
}