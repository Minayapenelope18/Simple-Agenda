import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SimpleAgenda {
    private static String[] contactos = new String[10];

    public static void agregarContacto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un contacto a agregar: ");
        String nombre = scanner.nextLine();

        boolean existe = false;
        for (String contacto : contactos) {
            if (nombre.equals(contacto)) {
                existe = true;
                break;
            }
        }

        if (existe) {
            System.out.println("Ya se ha agregado anteriormente");
        } else {
            for (int i = 0; i < contactos.length; i++) {
                if (contactos[i] == null) {
                    contactos[i] = nombre;
                    System.out.println("Agregado satisfactoriamente");
                    break;
                }
            }
        }
    }

    public static void removerContacto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el contacto a remover:");
        String nombre = scanner.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < contactos.length; i++) {
            if (nombre.equals(contactos[i])) {
                System.out.println("El contacto " + nombre + " fue removido exitosamente!");
                contactos[i] = null;
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No existe tal contacto");
        }
    }

    public static void mostrarContacto() {
        try {
            File file = new File("contactos.txt");
            Scanner scanner = new Scanner(file);

            System.out.println("Ingrese nombre a consultar:");
            String nombre = scanner.nextLine();

            boolean encontrado = false;
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                if (linea.contains(nombre)) {
                    System.out.println("El contacto " + nombre + " existe en la agenda");
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("No existen registros de este contacto");
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void mostrarContactos() {
        try {
            File file = new File ("contactos.txt");
            Scanner scanner = new Scanner(file);

            System.out.println("Mostrando contactos...");
            scanner.nextLine(); // Ignorar la primera línea (encabezado)
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                System.out.println(linea);
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void generarArchivo() {
        try {
            File file = new File("contactos.txt");
            if (file.createNewFile()) {
                FileWriter writer = new FileWriter(file);
                writer.write("contacto,telefono\n" +
                        "Adan,8098551212\n" +
                        "Enmanuel,8294118787\n" +
                        "Raider,8097410032\n" +
                        "Roger,8095554141\n");
                writer.close();
                System.out.println("Archivo generado exitosamente.");
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al generar el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        agregarContacto();
        agregarContacto();
        agregarContacto();
        mostrarContactos();
        removerContacto();
        mostrarContactos();
        mostrarContacto();
        generarArchivo();
    }
}