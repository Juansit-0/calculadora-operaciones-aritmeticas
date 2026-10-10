# Calculadora de operaciones aritmeticas (Java)

Aplicacion de consola en Java que recibe dos numeros enteros y calcula
suma, resta, multiplicacion y division.

Desarrollador: **Juan Camilo Lopez**

## Ejecutar

```bash
javac -d out src/main/java/*.java
java -cp out OperacionesAritmeticas
```

## Tests unitarios

```bash
./run-tests.sh
```

El script descarga JUnit 5 (console standalone), compila y ejecuta
`src/test/java/OperacionesAritmeticasTest.java`. Los resultados quedan
registrados en `docs/pruebas-unitarias.xlsx`.

## Documentacion

- [Documento de requisitos](docs/requisitos.md)
- Diagramas, calidad ISO/IEC 25010 y gestion del cambio: ver la Wiki del repositorio.
