
import java.util.ArrayList;

public class SimpleAgenda {
    private static ArrayList<String> contactos = new ArrayList<>();

        public static void agregarContacto(String nombre) {
            contactos.add(nombre);
            System.out.println("Contacto agregado: " + nombre);
        }

        public static void removerContacto(int posicion) {
            if (posicion >= 0 && posicion < contactos.size()) {
                String contactoRemovido = contactos.remove(posicion);
                System.out.println("Contacto removido: " + contactoRemovido);
            } else {
                System.out.println("Posición inválida. No se pudo remover el contacto.");
            }
        }

        public static String actualizarContacto(int posicion) {
            if (posicion >= 0 && posicion < contactos.size()) {
                contactos.set(posicion, "N/A");
                return "Contacto actualizado en la posición " + posicion;
            } else {
                return "Posición inválida. No se pudo actualizar el contacto.";
            }
        }

        public static void mostrarContactos() {
            System.out.println("Lista de contactos:");
            for (int i = 0; i < contactos.size(); i++) {
                System.out.println("Posición " + i + ": " + contactos.get(i));
            }
        }
        public static void main(String[] args) {
            agregarContacto("Sebastian");
            agregarContacto("Penelope");
            mostrarContactos();

            removerContacto(1);
            mostrarContactos();

            System.out.println(actualizarContacto(0));
            mostrarContactos();
        }
    }

