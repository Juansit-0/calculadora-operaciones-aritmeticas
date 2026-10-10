import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests unitarios de OperacionesAritmeticas.
 * Cada test corresponde a una fila (ID del Test) de docs/pruebas-unitarias.xlsx.
 *
 * Autor: Juan Camilo Lopez
 */
class OperacionesAritmeticasTest {

    private final PrintStream salidaOriginal = System.out;
    private ByteArrayOutputStream salida;

    @BeforeEach
    void capturarSalida() {
        salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
    }

    @AfterEach
    void restaurarSalida() {
        System.setOut(salidaOriginal);
    }

    // ---------- sumar ----------

    @Test
    @DisplayName("QA001 Sumar dos enteros positivos")
    void sumarPositivos() {
        assertEquals(8, OperacionesAritmeticas.sumar(5, 3));
    }

    @Test
    @DisplayName("QA002 Sumar dos enteros negativos")
    void sumarNegativos() {
        assertEquals(-10, OperacionesAritmeticas.sumar(-7, -3));
    }

    @Test
    @DisplayName("QA003 Sumar con cero (elemento neutro)")
    void sumarCero() {
        assertEquals(9, OperacionesAritmeticas.sumar(0, 9));
    }

    @Test
    @DisplayName("QA004 Sumar en el limite del tipo int (desbordamiento)")
    void sumarDesbordamiento() {
        assertThrows(ArithmeticException.class,
                () -> OperacionesAritmeticas.sumar(Integer.MAX_VALUE, 1));
    }

    // ---------- restar ----------

    @Test
    @DisplayName("QA005 Restar dos enteros positivos")
    void restarPositivos() {
        assertEquals(2, OperacionesAritmeticas.restar(5, 3));
    }

    @Test
    @DisplayName("QA006 Restar con resultado negativo")
    void restarResultadoNegativo() {
        assertEquals(-2, OperacionesAritmeticas.restar(3, 5));
    }

    @Test
    @DisplayName("QA007 Restar un numero negativo")
    void restarNegativo() {
        assertEquals(12, OperacionesAritmeticas.restar(8, -4));
    }

    @Test
    @DisplayName("QA008 Restar en el limite del tipo int (desbordamiento)")
    void restarDesbordamiento() {
        assertThrows(ArithmeticException.class,
                () -> OperacionesAritmeticas.restar(Integer.MIN_VALUE, 1));
    }

    // ---------- multiplicar ----------

    @Test
    @DisplayName("QA009 Multiplicar dos enteros positivos")
    void multiplicarPositivos() {
        assertEquals(100, OperacionesAritmeticas.multiplicar(5, 20));
    }

    @Test
    @DisplayName("QA010 Multiplicar por cero")
    void multiplicarPorCero() {
        assertEquals(0, OperacionesAritmeticas.multiplicar(7, 0));
    }

    @Test
    @DisplayName("QA011 Multiplicar enteros de signo distinto")
    void multiplicarSignoDistinto() {
        assertEquals(-24, OperacionesAritmeticas.multiplicar(-4, 6));
    }

    @Test
    @DisplayName("QA012 Multiplicar en el limite del tipo int (desbordamiento)")
    void multiplicarDesbordamiento() {
        assertThrows(ArithmeticException.class,
                () -> OperacionesAritmeticas.multiplicar(100000, 100000));
    }

    // ---------- dividir ----------

    @Test
    @DisplayName("QA013 Division exacta")
    void dividirExacta() {
        assertEquals(2, OperacionesAritmeticas.dividir(6, 3));
    }

    @Test
    @DisplayName("QA014 Division no exacta (resultado entero truncado)")
    void dividirNoExacta() {
        assertEquals(3, OperacionesAritmeticas.dividir(7, 2));
    }

    @Test
    @DisplayName("QA015 Dividir negativo entre positivo")
    void dividirNegativo() {
        assertEquals(-3, OperacionesAritmeticas.dividir(-9, 3));
    }

    @Test
    @DisplayName("QA016 Dividir cero entre un numero")
    void dividirCeroEntreNumero() {
        assertEquals(0, OperacionesAritmeticas.dividir(0, 5));
    }

    @Test
    @DisplayName("QA017 Division por cero")
    void dividirPorCero() {
        ArithmeticException e = assertThrows(ArithmeticException.class,
                () -> OperacionesAritmeticas.dividir(6, 0));
        assertEquals(OperacionesAritmeticas.MSG_DIVISION_CERO, e.getMessage());
    }

    @Test
    @DisplayName("QA018 Division en el limite del tipo int (desbordamiento)")
    void dividirDesbordamiento() {
        assertThrows(ArithmeticException.class,
                () -> OperacionesAritmeticas.dividir(Integer.MIN_VALUE, -1));
    }

    // ---------- leerEntero ----------

    @Test
    @DisplayName("QA019 Rechazar entrada de texto y volver a pedir el numero")
    void leerEnteroRechazaTexto() {
        Scanner entrada = new Scanner("abc\n5\n");
        assertEquals(5, OperacionesAritmeticas.leerEntero(entrada, "a: "));
        assertTrue(salida.toString().contains("Error: \"abc\" no es un numero entero valido."));
    }

    @Test
    @DisplayName("QA020 Rechazar entrada decimal y volver a pedir el numero")
    void leerEnteroRechazaDecimal() {
        Scanner entrada = new Scanner("3.5\n4\n");
        assertEquals(4, OperacionesAritmeticas.leerEntero(entrada, "a: "));
        assertTrue(salida.toString().contains("Error: \"3.5\" no es un numero entero valido."));
    }

    @Test
    @DisplayName("QA021 Aceptar un entero negativo")
    void leerEnteroAceptaNegativo() {
        Scanner entrada = new Scanner("-3\n");
        assertEquals(-3, OperacionesAritmeticas.leerEntero(entrada, "a: "));
    }
}
