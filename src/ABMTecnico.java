import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
public class ABMTecnico {
    static List<Tecnico> listaTecnicos = new ArrayList<>();
    static List<Equipo> listaEquipos = new ArrayList<>();
    private static final String TECNICOS_FILENAME = "tecnicos.txt";

    public static void main(String[] args) {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);
        cargarTecnicos();
        cargarEquipos();
        while (!salir) {
            System.out.println("\nGestión de Técnicos\n");
            System.out.println("1. Agregar Técnico");
            System.out.println("2. Eliminar Técnico");
            System.out.println("3. Modificar Técnico");
            System.out.println("4. Mostrar Técnicos");
            System.out.println("5. Buscar Técnico por Cédula");
            System.out.println("6. Calcular salario de jugador");
            System.out.println("7. Salir");
            System.out.print("\nSeleccione una opción: ");

            int opcion;
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea después del número
                switch (opcion) {
                    case 1:
                        agregarTecnico();
                        break;
                    case 2:
                        eliminarTecnico();
                        break;
                    case 3:
                        modificarTecnico();
                        break;
                    case 4:
                        mostrarTecnicos();
                        break;
                    case 5:
                        buscarTecnicoPorCedula();
                        break;
                    case 6:
                        calcularSalario();
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

     static void calcularSalario() {
        System.out.println("Calculando salarios para todos los técnicos:\n");
        if (listaTecnicos.isEmpty()) {
            System.out.println("No hay técnicos en la lista.");
        } else {
            for (Tecnico tecnico : listaTecnicos) {
                double salario = tecnico.calcularSalario();
                System.out.println(tecnico.getNombre() + " - Salario: $" + salario);
            }
        }
    }


    static void agregarTecnico() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos del técnico:");

        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Salario: ");
        double salario = scanner.nextInt();
        scanner.nextLine();
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

        int tecnicoPorEquipo = 0;
        for (Tecnico tecnico: listaTecnicos) {
            if (tecnico.getEquipo().equals(equipoSeleccionado)){
                tecnicoPorEquipo++;
            }
        }
        if (tecnicoPorEquipo <= 1){
            listaTecnicos.add(new Tecnico(cedula, nombre, apellido, salario, equipoSeleccionado));
            mostrarTecnicos();
            guardarTecnicos();
        } else {
            System.out.println("Ya tiene tecnico este equipo");
        }

    }

    static void mostrarTecnicos() {
        System.out.println("Lista de Técnicos:");
        for (Tecnico tecnico : listaTecnicos) {
            System.out.println(tecnico);
        }
    }

    static void eliminarTecnico() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cédula del técnico que desea eliminar: ");
        String cedulaEliminar = scanner.nextLine();
        Tecnico[] arrayTecnicos = listaTecnicos.toArray(new Tecnico[0]);
        for (int i = 0; i < arrayTecnicos.length; i++) {
            Tecnico tecnico = arrayTecnicos[i];
            if (tecnico.getCedula().equals(cedulaEliminar)) {
                listaTecnicos.remove(tecnico);
                mostrarTecnicos();
                guardarTecnicos();
                return;
            }
        }
            System.out.println("Cédula no encontrada. \n");
    }

    static void modificarTecnico() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cédula del técnico que desea modificar: ");
        String cedulaModificar = scanner.nextLine();

        Tecnico tecnicoAModificar = null;
        for (Tecnico tecnico : listaTecnicos) {
            if (tecnico.getCedula().equals(cedulaModificar)) {
                tecnicoAModificar = tecnico;
                break;
            }
        }

        if (tecnicoAModificar != null) {
            System.out.println("Datos actuales del técnico: " + tecnicoAModificar);
            System.out.println("Ingrese los nuevos datos:");

            System.out.print("Nombre: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Apellido: ");
            String nuevoApellido = scanner.nextLine();
            System.out.print("Salario: ");
            double nuevoSalario = scanner.nextInt();
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

            tecnicoAModificar.setNombre(nuevoNombre);
            tecnicoAModificar.setApellido(nuevoApellido);
            tecnicoAModificar.setSalario(nuevoSalario);
            tecnicoAModificar.setEquipo(equipoSeleccionado);
            mostrarTecnicos();
            guardarTecnicos();
        } else {
            System.out.println("Cédula no encontrada. \n");
        }
    }

    static void buscarTecnicoPorCedula() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cédula del técnico a buscar: ");
        String cedulaBuscar = scanner.nextLine();

        Tecnico tecnico = null;
        for (Tecnico t : listaTecnicos) {
            if (t.getCedula().equals(cedulaBuscar)) {
                tecnico = t;
                break;
            }
        }

        if (tecnico != null) {
            System.out.println("Técnico encontrado:\n" + tecnico);
        } else {
            System.out.println("Técnico no encontrado. \n");
        }
    }
    // Método para guardar la lista de equipos en un archivo de texto
    private static void guardarTecnicos() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(TECNICOS_FILENAME))) {
            for (Tecnico tecnico : listaTecnicos) {
                writer.println(tecnico.getCedula()+" " +tecnico.getNombre()+" " +tecnico.getApellido()+" " +tecnico.getSalario()+" " +tecnico.getEquipo());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Método para cargar la lista de equipos desde un archivo de texto
    private static void cargarTecnicos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(TECNICOS_FILENAME))) {
            String cedula = "";
            String nombre = "";
            String apellido = "";
            double salario = 0;
            Equipo equipo = null;
            while ((cedula = reader.readLine()) != null || (nombre = reader.readLine()) != null || (apellido = reader.readLine()) != null) {
                listaTecnicos.add(new Tecnico(cedula, nombre, apellido, salario, equipo));
            }
        } catch (IOException e) {
            // Manejo de excepciones en caso de fallo (puede no haber un archivo al inicio)
        }
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

