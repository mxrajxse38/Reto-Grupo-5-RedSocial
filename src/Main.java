/**
 * Programa principal: demuestra la actividad solicitada.
 */
public class Main {
    public static void main(String[] args) {
        RedSocial red = new RedSocial();

        // 1. Crear los cuatro usuarios.
        System.out.println("1. CREACIÓN DE USUARIOS");
        red.agregarUsuario("Ana");
        red.agregarUsuario("Beto");
        red.agregarUsuario("Carlos");
        red.agregarUsuario("Dani");

        // 2. Crear amistades y seguimientos iniciales.
        System.out.println("\n2. RELACIONES INICIALES");
        red.agregarAmistad("Ana", "Beto");
        red.agregarAmistad("Ana", "Carlos");
        red.agregarAmistad("Beto", "Dani");
        red.agregarAmistad("Carlos", "Dani");

        red.seguir("Ana", "Dani");
        red.seguir("Beto", "Carlos");
        red.seguir("Carlos", "Ana");
        red.seguir("Dani", "Beto");
        red.mostrarRed();

        // 3. Modificar relaciones según las indicaciones del moderador.
        System.out.println("\n3. MODIFICACIÓN DE RELACIONES");
        red.eliminarAmistad("Ana", "Carlos");
        red.seguir("Beto", "Ana");
        red.dejarDeSeguir("Dani", "Beto");
        red.seguir("Carlos", "Dani");
        red.mostrarRed();

        // 4. Eliminar a Carlos y todas sus conexiones.
        System.out.println("\n4. ELIMINACIÓN DE CARLOS");
        red.eliminarUsuario("Carlos");

        // 5. Mostrar el resultado final.
        System.out.println("\n5. RED SOCIAL FINAL");
        red.mostrarRed();

        // 6. Verificar que Carlos ya no exista.
        System.out.println("\nComprobación: Carlos fue eliminado de la red.");
    }
}
