import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABMTecnico {
    static List<Tecnico> listaTecnicos = new ArrayList<>();

    public static void main(String[] args) {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);

        while (!salir) {
            System.out.println("\nGestión de Técnicos\n");
            System.out.println("1. Agregar Técnico");
            System.out.println("2. Eliminar Técnico");
            System.out.println("3. Modificar Técnico");
            System.out.println("4. Mostrar Técnicos");
            System.out.println("5. Buscar Técnico por Cédula");
            System.out.println("6. Salir");
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
        System.out.print("Equipo: ");
        String equipo = scanner.nextLine();

        int tecnicoPorEquipo = 0;
        for (Tecnico tecnico: listaTecnicos) {
            if (tecnico.getEquipo().equalsIgnoreCase(equipo)){
                tecnicoPorEquipo++;
            }
        }
        if (tecnicoPorEquipo < 7){
            listaTecnicos.add(new Tecnico(cedula, nombre, apellido, salario, equipo));
            mostrarTecnicos();
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

        Tecnico tecnicoAEliminar = null;
        for (Tecnico tecnico : listaTecnicos) {
            if (tecnico.getCedula().equals(cedulaEliminar)) {
                tecnicoAEliminar = tecnico;
                break;
            }
        }

        if (tecnicoAEliminar != null) {
            listaTecnicos.remove(tecnicoAEliminar);
            mostrarTecnicos();
        } else {
            System.out.println("Cédula no encontrada. \n");
        }
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
            System.out.print("Equipo: ");
            String nuevoEquipo = scanner.nextLine();

            tecnicoAModificar.setNombre(nuevoNombre);
            tecnicoAModificar.setApellido(nuevoApellido);
            tecnicoAModificar.setSalario(nuevoSalario);
            tecnicoAModificar.setEquipo(nuevoEquipo);
            mostrarTecnicos();
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
}

