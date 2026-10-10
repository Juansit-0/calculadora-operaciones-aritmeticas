import java.util.Scanner;

/**
 * Calculadora de consola que recibe dos numeros enteros y calcula
 * suma, resta, multiplicacion, division y potencia.
 *
 * Desarrollador: Juan Camilo Lopez
 */
public class OperacionesAritmeticas {

    public static final String MSG_DIVISION_CERO =
            "Division: operacion no valida, el divisor no puede ser cero.";
    public static final String MSG_DESBORDAMIENTO =
            "operacion no valida, el resultado supera el rango de un entero.";
    public static final String MSG_EXPONENTE_NEGATIVO =
            "Potencia: operacion no valida, el exponente no puede ser negativo.";

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
     * Calcula a elevado a la b con un ciclo for (solicitud de cambio CR-001).
     * Lanza ArithmeticException si b es negativo o si el resultado se desborda.
     */
    public static long potencia(int a, int b) {
        if (b < 0) {
            throw new ArithmeticException(MSG_EXPONENTE_NEGATIVO);
        }
        long resultado = 1;
        for (int i = 0; i < b; i++) {
            try {
                resultado = Math.multiplyExact(resultado, (long) a);
            } catch (ArithmeticException e) {
                throw new ArithmeticException("Potencia: " + MSG_DESBORDAMIENTO);
            }
        }
        return resultado;
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
        try {
            System.out.println(a + " ^ " + b + " = " + potencia(a, b));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
