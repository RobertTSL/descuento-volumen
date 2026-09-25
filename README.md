# Semana 04 · P1 — El build sin IDE (descuento-volumen)

Proyecto Java independiente. No usa contenedores, no usa el proyecto del
semestre y no requiere IDE: todo se ejecuta desde la terminal.

**Las instrucciones completas, las preguntas de predicción y el formato de
entrega están en el documento `S04_P1_Practica.docx` que viene en este
mismo ZIP.** Este README es sólo el mapa del proyecto.

## Requisitos

- JDK 21 (`java -version` debe reportar 21)
- Apache Maven 3.9 o superior (`mvn -v`)
- La terminal abierta en la carpeta que contiene `pom.xml`

## Mapa del proyecto

```
descuento-volumen/
|-- pom.xml                 identidad, dependencias y plugins
|-- .gitignore              target/ nunca se versiona
`-- src/
    |-- main/java/mx/itson/devops/descuento/
    |   |-- Descuento.java
    |   `-- DescuentoSmokeTest.java   <-- algo no está en su lugar
    `-- test/java/mx/itson/devops/descuento/
        `-- (vacío por ahora)
```

## Comandos de la práctica

```bash
mvn -B clean compile
mvn -B test
mvn -B package
mvn -B verify
mvn -B dependency:tree
```

## Entrega

Repositorio Git (público o compartido con el profesor) + el .docx llenado.
Fecha límite: **sábado 26 de septiembre, 5:00 a.m.**

## Plan B sin Internet

Maven descarga plugins y dependencias la primera vez. Con el repositorio local
ya poblado se puede trabajar sin conexión:

```bash
mvn -o -B clean verify
```
