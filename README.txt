PROYECTO: RED SOCIAL - JAVA

CONTENIDO
---------
src/Usuario.java
    Representa a cada usuario. Guarda sus amistades y los usuarios a los que sigue.

src/RedSocial.java
    Administra usuarios, amistades bidireccionales, seguimientos unidireccionales
    y la eliminación de usuarios con todas sus conexiones.

src/Main.java
    Ejecuta toda la actividad solicitada y muestra el resultado en consola.

REQUISITOS
----------
- Java JDK 8 o superior.
- No necesita librerías externas.

CÓMO EJECUTAR
-------------
1. Abra la carpeta RedSocialJava en Visual Studio Code, NetBeans o IntelliJ.
2. Compile los archivos desde la carpeta del proyecto:

   javac -d out src/*.java

3. Ejecute el programa:

   java -cp out Main


## Diagrama de la Red Social Final

Después de crear los usuarios, modificar las relaciones
y eliminar a Carlos, la red social queda así:

```mermaid
flowchart TD
    A((Ana))
    B((Beto))
    D((Dani))

    A ---|Amistad| B
    B ---|Amistad| D

    A -.->|Sigue| D
    B -.->|Sigue| A

    style A fill:#2563eb,color:#fff,stroke:#1d4ed8
    style B fill:#2563eb,color:#fff,stroke:#1d4ed8
    style D fill:#2563eb,color:#fff,stroke:#1d4ed8
```

### Explicación

**Usuarios activos:** Ana, Beto y Dani.

**Amistades bidireccionales:**
- Ana ↔ Beto
- Beto ↔ Dani

**Seguimientos unidireccionales:**
- Ana → Dani
- Beto → Ana

**Usuario eliminado:** Carlos.

Al eliminar a Carlos, desaparecen todas sus
amistades y seguimientos asociados.

### Reglas implementadas

- No se permiten amistades consigo mismo.
- Las amistades funcionan en ambos sentidos.
- Los seguimientos funcionan en una sola dirección.
- Al eliminar un usuario se eliminan todas sus conexiones.

**Resultado:** La red social queda actualizada
con tres usuarios y sin conexiones hacia Carlos.

