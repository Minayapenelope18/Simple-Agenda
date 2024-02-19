import java.util.ArrayList;
import java.util.Scanner;

public class SimpleAgenda {
    private static ArrayList<String> contactos = new ArrayList<>();

    public static void agregarContacto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un contacto a agregar:");
        String nombre = scanner.nextLine();
        if (nombre.length() > 4 && nombre.length() < 8) {
            contactos.add(nombre);
            System.out.println("Contacto agregado con éxito");
        } else if (nombre.length() >= 8 && nombre.length() <= 30) {
            contactos.add(nombre);
            System.out.println("Contacto agregado, contiene entre 8-30 caracteres");
        } else {
            System.out.println("Nombre muy largo");
        }
    }

    public static void removerContacto(int posicion) {
        if (posicion >= 1000 && posicion <= 9999) {
            System.out.println("Verificando contacto a eliminar...");
        } else {
            System.out.println("ID inválido.");
        }
    }

    public static void mostrarContactos() {
        System.out.println("Mostrando contactos...");
    }

    public static void main(String[] args) {
        agregarContacto();
        agregarContacto();
        agregarContacto();
        mostrarContactos();
        removerContacto(500); // Cambia este valor para probar diferentes casos
    }
}