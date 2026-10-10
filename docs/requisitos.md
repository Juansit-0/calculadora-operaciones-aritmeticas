# Documento de requisitos - Calculadora de enteros

| Campo | Valor |
|---|---|
| Version | 1.0 |
| Estado | Aprobado por el cliente |
| Desarrollador | Juan Camilo Lopez |
| Fecha | 2026-10-09 |

## Requisitos funcionales

| ID | Requisito |
|---|---|
| RF-01 | La aplicacion recibe dos valores enteros (a y b) leidos desde la consola. |
| RF-02 | Calcula la suma a + b en un metodo propio (`sumar`). |
| RF-03 | Calcula la resta a - b en un metodo propio (`restar`). |
| RF-04 | Calcula la multiplicacion a * b en un metodo propio (`multiplicar`). |
| RF-05 | Calcula la division entera a / b en un metodo propio (`dividir`). |
| RF-06 | Solo acepta numeros enteros. Si se escribe texto o un decimal, muestra un mensaje de error y vuelve a pedir el valor. |
| RF-07 | Si b es cero, la division muestra el mensaje "Division: operacion no valida, el divisor no puede ser cero." y el programa no se detiene. |
| RF-08 | Los resultados se escriben en la consola. |

## Requisitos no funcionales

| ID | Requisito |
|---|---|
| RNF-01 | Lenguaje Java 17 o superior, aplicacion de consola. |
| RNF-02 | Cada metodo de calculo tiene tests unitarios (JUnit 5). |
| RNF-03 | Si un resultado supera el rango de `int`, se muestra un mensaje de error en lugar de un valor incorrecto. |
