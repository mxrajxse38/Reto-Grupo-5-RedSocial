import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Administra usuarios, amistades bidireccionales y seguimientos dirigidos.
 */
public class RedSocial {
    private final Map<String, Usuario> usuarios = new LinkedHashMap<>();

    public void agregarUsuario(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }

        nombre = normalizar(nombre);
        if (usuarios.containsKey(nombre)) {
            System.out.println("El usuario " + nombre + " ya existe.");
            return;
        }

        usuarios.put(nombre, new Usuario(nombre));
        System.out.println("Usuario agregado: " + nombre);
    }

    // La amistad se guarda en los dos usuarios.
    public void agregarAmistad(String nombre1, String nombre2) {
        Usuario u1 = buscarUsuario(nombre1);
        Usuario u2 = buscarUsuario(nombre2);

        if (u1 == null || u2 == null) {
            System.out.println("No se puede crear la amistad: usuario inexistente.");
            return;
        }
        if (u1 == u2) {
            System.out.println("Una persona no puede ser amiga de sí misma.");
            return;
        }

        u1.agregarAmigo(u2.getNombre());
        u2.agregarAmigo(u1.getNombre());
        System.out.println("Amistad creada: " + u1 + " <-> " + u2);
    }

    public void eliminarAmistad(String nombre1, String nombre2) {
        Usuario u1 = buscarUsuario(nombre1);
        Usuario u2 = buscarUsuario(nombre2);

        if (u1 == null || u2 == null) {
            System.out.println("No se puede eliminar: usuario inexistente.");
            return;
        }

        u1.eliminarAmigo(u2.getNombre());
        u2.eliminarAmigo(u1.getNombre());
        System.out.println("Amistad eliminada entre " + u1 + " y " + u2);
    }

    // El seguimiento tiene una sola dirección: origen -> destino.
    public void seguir(String origen, String destino) {
        Usuario u1 = buscarUsuario(origen);
        Usuario u2 = buscarUsuario(destino);

        if (u1 == null || u2 == null) {
            System.out.println("No se puede crear el seguimiento: usuario inexistente.");
            return;
        }
        if (u1 == u2) {
            System.out.println("Un usuario no puede seguirse a sí mismo.");
            return;
        }

        u1.seguir(u2.getNombre());
        System.out.println(origen + " ahora sigue a " + destino);
    }

    public void dejarDeSeguir(String origen, String destino) {
        Usuario u1 = buscarUsuario(origen);
        Usuario u2 = buscarUsuario(destino);

        if (u1 == null || u2 == null) {
            System.out.println("No se puede eliminar el seguimiento: usuario inexistente.");
            return;
        }

        u1.dejarDeSeguir(u2.getNombre());
        System.out.println(origen + " dejó de seguir a " + destino);
    }

    // Al borrar un usuario, se eliminan amistades y seguimientos relacionados.
    public void eliminarUsuario(String nombre) {
        Usuario eliminado = buscarUsuario(nombre);

        if (eliminado == null) {
            System.out.println("El usuario no existe: " + nombre);
            return;
        }

        for (Usuario usuario : usuarios.values()) {
            usuario.eliminarAmigo(eliminado.getNombre());
            usuario.dejarDeSeguir(eliminado.getNombre());
        }

        usuarios.remove(eliminado.getNombre());
        System.out.println("Usuario y todas sus conexiones eliminados: " + nombre);
    }

    public void mostrarRed() {
        System.out.println("\n========== RED SOCIAL ==========");
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        for (Usuario usuario : usuarios.values()) {
            System.out.println("\nUsuario: " + usuario.getNombre());
            System.out.println("  Amigos: " + usuario.getAmigos());
            System.out.println("  Sigue a: " + usuario.getSiguiendo());
        }
        System.out.println("\n================================");
    }

    public Collection<Usuario> getUsuarios() {
        return usuarios.values();
    }

    private Usuario buscarUsuario(String nombre) {
        if (nombre == null) {
            return null;
        }
        return usuarios.get(normalizar(nombre));
    }

    private String normalizar(String nombre) {
        return nombre.trim();
    }
}
