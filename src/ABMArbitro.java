import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABMArbitro {
    static List<Arbitro> listaArbitro = new ArrayList<>();

    public static void main(String[] args) {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);

        while (!salir) {
            System.out.println("\nGestión de Lista de Árbitros\n");
            System.out.println("1. Agregar Árbitro");
            System.out.println("2. Eliminar Árbitro");
            System.out.println("3. Modificar Árbitro");
            System.out.println("4. Mostrar Árbitros");
            System.out.println("5. Buscar Árbitro por Cédula");
            System.out.println("6. Salir");
            System.out.print("\nSeleccione una opción: ");

            int opcion;
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea después del número
                switch (opcion) {
                    case 1:
                        agregarArbitro();
                        break;
                    case 2:
                        eliminarArbitro();
                        break;
                    case 3:
                        modificarArbitro();
                        break;
                    case 4:
                        mostrarArbitros();
                        break;
                    case 5:
                        buscarArbitroPorCedula();
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

    static void agregarArbitro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos del árbitro:");

        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Salario: ");
        double salario = scanner.nextInt();

        System.out.print("Años de Experiencia: ");
        int añosExperiencia = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después del número

        listaArbitro.add(new Arbitro(cedula, nombre, apellido, salario, añosExperiencia));
        mostrarArbitros();
    }

    static void mostrarArbitros() {
        System.out.println("Lista de Árbitros:");
        for (Arbitro arbitro : listaArbitro) {
            System.out.println(arbitro);
        }
    }

    static void eliminarArbitro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cédula del árbitro que desea eliminar: ");
        String cedulaEliminar = scanner.nextLine();

        Arbitro arbitroAEliminar = null;
        for (Arbitro arbitro : listaArbitro) {
            if (arbitro.getCedula().equals(cedulaEliminar)) {
                arbitroAEliminar = arbitro;
                break;
            }
        }

        if (arbitroAEliminar != null) {
            listaArbitro.remove(arbitroAEliminar);
            mostrarArbitros();
        } else {
            System.out.println("Cédula no encontrada. \n");
        }
    }

    static void modificarArbitro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cédula del árbitro que desea modificar: ");
        String cedulaModificar = scanner.nextLine();

        Arbitro arbitroAModificar = null;
        for (Arbitro arbitro : listaArbitro) {
            if (arbitro.getCedula().equals(cedulaModificar)) {
                arbitroAModificar = arbitro;
                break;
            }
        }

        if (arbitroAModificar != null) {
            System.out.println("Datos actuales del árbitro: " + arbitroAModificar);
            System.out.println("Ingrese los nuevos datos:");

            System.out.print("Nombre: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Apellido: ");
            String nuevoApellido = scanner.nextLine();
            System.out.print("Salario: ");
            double nuevoSalario = scanner.nextInt();
            System.out.print("Años de Experiencia: ");
            int nuevosAñosExperiencia = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después del número

            arbitroAModificar.setNombre(nuevoNombre);
            arbitroAModificar.setApellido(nuevoApellido);
            arbitroAModificar.setSalario(nuevoSalario);
            arbitroAModificar.setAñosExperiencia(nuevosAñosExperiencia);
            mostrarArbitros();
        } else {
            System.out.println("Cédula no encontrada. \n");
        }
    }

    static void buscarArbitroPorCedula() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cédula del árbitro a buscar: ");
        String cedulaBuscar = scanner.nextLine();

        Arbitro arbitro = null;
        for (Arbitro a : listaArbitro) {
            if (a.getCedula().equals(cedulaBuscar)) {
                arbitro = a;
                break;
            }
        }

        if (arbitro != null) {
            System.out.println("Árbitro encontrado:\n" + arbitro);
        } else {
            System.out.println("Árbitro no encontrado. \n");
        }
    }
}

