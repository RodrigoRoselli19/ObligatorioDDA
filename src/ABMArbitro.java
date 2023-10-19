import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABMArbitro {
    static List<Arbitro> listaArbitro = new ArrayList<>();
    private static final String ARBITROS_FILENAME = "arbitros.txt";
    public static void main(String[] args) {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);
        cargarArbitros();
        while (!salir) {
            System.out.println("\nGestión de Lista de Árbitros\n");
            System.out.println("1. Agregar Árbitro");
            System.out.println("2. Eliminar Árbitro");
            System.out.println("3. Modificar Árbitro");
            System.out.println("4. Mostrar Árbitros");
            System.out.println("5. Buscar Árbitro por Cédula");
            System.out.println("6. Calcular salario de jugador");
            System.out.println("7. Precalentar");
            System.out.println("8. Salir");
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

    static void precalentar()
    {
         Scanner scanner = new Scanner(System.in);
         System.out.print("Ingrese el nombre del árbitro que precalentará: ");
         String nombreArbitro = scanner.nextLine();
         boolean arbitroEncontrado = false;

         for (Arbitro arbitro : listaArbitro) {
             if (arbitro.getNombre().equalsIgnoreCase(nombreArbitro)) {
                 arbitro.precalentar();
                 arbitroEncontrado = true;
                 break;
             }
         }

         if (!arbitroEncontrado) {
             System.out.println("Árbitro no encontrado.");
         }
     }

    static void calcularSalario() {
        System.out.println("Calculando salarios para todos los árbitros:\n");

        if (listaArbitro.isEmpty()) {
            System.out.println("No hay árbitros en la lista.");
        } else {
            for (Arbitro arbitro : listaArbitro) {
                double salario = arbitro.calcularSalario();
                System.out.println(arbitro.getNombre() + " - Salario: $" + salario);
            }
        }
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
        scanner.nextLine();
        System.out.print("Años de Experiencia: ");
        int añosExperiencia = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después del número

        listaArbitro.add(new Arbitro(cedula, nombre, apellido, salario, añosExperiencia));
        System.out.println("Arbitro ingrsado con exito");
        mostrarArbitros();
        guardarArbitros();
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
    // Método para guardar la lista de equipos en un archivo de texto
    private static void guardarArbitros() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARBITROS_FILENAME))) {
            for (Arbitro arbitro : listaArbitro) {
                writer.println(arbitro.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Método para cargar la lista de equipos desde un archivo de texto
    private static void cargarArbitros() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARBITROS_FILENAME))) {
            String cedula;
            String nombre = "";
            String apellido = "";
            double salario = 0;
            int exp = 0;
            while ((cedula = reader.readLine()) != null || (nombre = reader.readLine()) != null || (apellido = reader.readLine()) != null) {
                listaArbitro.add(new Arbitro(cedula, nombre, apellido, salario, exp));
            }
        } catch (IOException e) {
            System.out.println("Aun no se ha creado un Arbitro");// Manejo de excepciones en caso de fallo (puede no haber un archivo al inicio)
        }
    }
}

