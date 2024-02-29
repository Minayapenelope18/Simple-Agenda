import java.util.Scanner;

public class SimpleAgenda {
    public static String[] contactos = new String[10];


    public static void agregarContacto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un contacto a agregar:");
        String nombre = scanner.nextLine();
        boolean encontrado = false;
        for (String contacto : contactos) {
            if (nombre.equals(contacto)) {
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.println("Ya se ha agregado anteriormente.");
        } else {
            for (int i = 0; i < contactos.length; i++) {
                if (contactos[i] == null) {
                    contactos[i] = nombre;
                    System.out.println("Agregado satisfactoriamente.");
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
                encontrado = true;
                contactos[i] = null;
                System.out.println("El contacto " + nombre + " fue removido exitosamente!");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No existe tal contacto.");
        }
    }

    public static void mostrarContacto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el contacto a mostrar:");
        String nombre = scanner.nextLine();

        boolean encontrado = false;
        for (String contacto : contactos) {
            if (nombre.equals(contacto)) {
                encontrado = true;
                System.out.println("El contacto " + nombre + ".");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No existen registros de este contacto.");
        }
    }

    public static void mostrarContactos() {
        System.out.println("Mostrando contactos…");
        for (String contacto : contactos) {
            if (contacto != null) {
                System.out.println(contacto);
            }
        }
    }

    public static void main(String[] args) {
        agregarContacto();
        agregarContacto();
        mostrarContactos();

        removerContacto();
        mostrarContactos();

        mostrarContacto();
    }
}