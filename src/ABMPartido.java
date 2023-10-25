import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ABMPartido {
    static List<Partido> listaPartidos = new ArrayList<>();
    static List<Arbitro> listaArbitros = new ArrayList<>();
    static List<Equipo> listaEquipos = new ArrayList<>();
    private static final String PARTIDOS_FILENAME = "partidos.txt";

    public static void main(String[] args) {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);
        cargarArbitros();
        cargarEquipos();
        cargarPartidos();
        while (!salir) {
            System.out.println("\nRealización de Partido\n");
            System.out.println("1. Agregar Partido");
            System.out.println("2. Eliminar Partido");
            System.out.println("3. Modificar Partido");
            System.out.println("4. Mostrar Partido por fecha");
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
                System.out.println("Árbitro del partido: " + partido.getArbitro().getNombre());
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la fecha del partido a mostrar: ");
        String fechaMostrar = scanner.nextLine();

        for (Partido partido : listaPartidos) {
            if (partido.getFecha().equalsIgnoreCase(fechaMostrar)) {
                System.out.println("Partido encontrado:\n" + partido);

            }
        }

        System.out.println("No se encontraron partidos con la fecha especificada.");
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
                writer.println(partido.getFecha()+" "+partido.getHora()+" "+partido.getEquipoA()+" "+partido.getEquipoB()+" "+partido.getArbitro());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Método para cargar la lista de equipos desde un archivo de texto
    private static void cargarPartidos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PARTIDOS_FILENAME))) {
            String fecha = "";
            String hora = "";
            Equipo equipoA = null;
            Equipo equipoB = null;
            Arbitro arbitro = null;
            while ((fecha = reader.readLine()) != null || (hora = reader.readLine()) != null) {
                listaPartidos.add(new Partido(fecha, hora, equipoA, equipoB, arbitro));
            }
        } catch (IOException e) {
            System.out.println("No se pueden cargar los partidos"+ e.getMessage());// Manejo de excepciones en caso de fallo (puede no haber un archivo al inicio)
        }
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
        try (BufferedReader reader = new BufferedReader(new FileReader("arbitros.txt"))) {
            String cedula;
            String nombre = "";
            String apellido = "";
            double salario = 0;
            int exp = 0;
            while ((cedula = reader.readLine()) != null || (nombre = reader.readLine()) != null || (apellido = reader.readLine()) != null) {
                listaArbitros.add(new Arbitro(cedula, nombre, apellido, salario, exp));
            }
        } catch (IOException e) {
            System.out.println("Aun no se ha creado un Arbitro"+e.getMessage());// Manejo de excepciones en caso de fallo (puede no haber un archivo al inicio)
        }
    }
}