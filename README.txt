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

RESULTADO FINAL ESPERADO
------------------------
Usuarios activos: Ana, Beto y Dani.

Amistades:
- Ana <-> Beto
- Beto <-> Dani

Seguimientos:
- Ana -> Dani
- Beto -> Ana

Carlos se elimina junto con todas sus conexiones.

REGLAS IMPLEMENTADAS
--------------------
- No se permite crear amistad consigo mismo.
- Las amistades se registran en ambos usuarios.
- Los seguimientos tienen una sola dirección.
- Al eliminar un usuario, se eliminan todas las relaciones que lo mencionan.
