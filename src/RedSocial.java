public class RedSocial {
    public void agregarAmistad(String nombre1, String nombre2) {
    Usuario u1 = buscarUsuario(nombre1);
    Usuario u2 = buscarUsuario(nombre2);

    if (u1 == null || u2 == null) {
        System.out.println("Usuario no encontrado.");
        return;
    }

    if (u1 == u2) {
        System.out.println("No puedes ser amigo de ti mismo.");
        return;
    }

    if (u1.getAmigos().contains(u2)) {
        System.out.println("La amistad ya existe.");
        return;
    }

    u1.getAmigos().add(u2);
    u2.getAmigos().add(u1);

    System.out.println("Amistad agregada correctamente.");
}

public void eliminarAmistad(String nombre1, String nombre2) {
    Usuario u1 = buscarUsuario(nombre1);
    Usuario u2 = buscarUsuario(nombre2);

    if (u1 == null || u2 == null) {
        System.out.println("Usuario no encontrado.");
        return;
    }

    u1.getAmigos().remove(u2);
    u2.getAmigos().remove(u1);

    System.out.println("Amistad eliminada correctamente.");
}
    
}
