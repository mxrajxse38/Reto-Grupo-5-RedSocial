import java.util.HashSet;
import java.util.Set;

/**
 * Representa a un usuario de la red social.
 */
public class Usuario {
    private final String nombre;
    private final Set<String> amigos;
    private final Set<String> siguiendo;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.amigos = new HashSet<>();
        this.siguiendo = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Set<String> getAmigos() {
        return new HashSet<>(amigos);
    }

    public Set<String> getSiguiendo() {
        return new HashSet<>(siguiendo);
    }

    // Métodos de uso interno de RedSocial
    void agregarAmigo(String nombreAmigo) {
        amigos.add(nombreAmigo);
    }

    void eliminarAmigo(String nombreAmigo) {
        amigos.remove(nombreAmigo);
    }

    void seguir(String nombreUsuario) {
        siguiendo.add(nombreUsuario);
    }

    void dejarDeSeguir(String nombreUsuario) {
        siguiendo.remove(nombreUsuario);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
