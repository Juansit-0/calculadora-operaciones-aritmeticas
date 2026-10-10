import java.util.Scanner;

/**
 * Calculadora de consola que recibe dos numeros enteros y calcula
 * suma, resta, multiplicacion y division.
 *
 * Autor: Juan Camilo Lopez
 */
public class OperacionesAritmeticas {

    public static final String MSG_DIVISION_CERO =
            "Division: operacion no valida, el divisor no puede ser cero.";
    public static final String MSG_DESBORDAMIENTO =
            "operacion no valida, el resultado supera el rango de un entero.";

    /** Suma dos enteros. Lanza ArithmeticException si el resultado se desborda. */
    public static int sumar(int a, int b) {
        return Math.addExact(a, b);
    }

    /** Resta b de a. Lanza ArithmeticException si el resultado se desborda. */
    public static int restar(int a, int b) {
        return Math.subtractExact(a, b);
    }

    /** Multiplica dos enteros. Lanza ArithmeticException si el resultado se desborda. */
    public static int multiplicar(int a, int b) {
        return Math.multiplyExact(a, b);
    }

    /**
     * Division entera (trunca hacia cero).
     * Lanza ArithmeticException si b es cero o si el resultado se desborda.
     */
    public static int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException(MSG_DIVISION_CERO);
        }
        if (a == Integer.MIN_VALUE && b == -1) {
            throw new ArithmeticException("Division: " + MSG_DESBORDAMIENTO);
        }
        return a / b;
    }

    /**
     * Lee un numero entero desde la consola. Si el texto no es un entero
     * muestra un mensaje de error y vuelve a pedir el valor.
     */
    public static int leerEntero(Scanner entrada, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (!entrada.hasNextLine()) {
                throw new IllegalStateException("No hay mas datos de entrada.");
            }
            String texto = entrada.nextLine().trim();
            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                System.out.println("Error: \"" + texto + "\" no es un numero entero valido.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("=== Calculadora de numeros enteros ===");
        int a = leerEntero(entrada, "Ingrese el primer numero entero (a): ");
        int b = leerEntero(entrada, "Ingrese el segundo numero entero (b): ");

        try {
            System.out.println(a + " + " + b + " = " + sumar(a, b));
        } catch (ArithmeticException e) {
            System.out.println("Suma: " + MSG_DESBORDAMIENTO);
        }
        try {
            System.out.println(a + " - " + b + " = " + restar(a, b));
        } catch (ArithmeticException e) {
            System.out.println("Resta: " + MSG_DESBORDAMIENTO);
        }
        try {
            System.out.println(a + " * " + b + " = " + multiplicar(a, b));
        } catch (ArithmeticException e) {
            System.out.println("Multiplicacion: " + MSG_DESBORDAMIENTO);
        }
        try {
            System.out.println(a + " / " + b + " = " + dividir(a, b));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
