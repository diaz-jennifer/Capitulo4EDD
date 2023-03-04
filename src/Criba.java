import java.util.Scanner;

/***
 * Clase Criba refactorizada
 * @author Jennifer
 * @version 1.0
 */
public class Criba
{
    /**
     * Clase que genera números primos de 1 a max
     *
     * @param max es el número ingresado por teclado
     * @return <ul>
     *              <li>primos si max es mayor o igual a 2,</li>
     *              <li>max si es menor a 2.</li>
     * </ul>
     */
    public static int[] generarPrimos (int max)
    {
        int i;
        if (max >= 2) {
// Declaraciones
            /**
             * Determina el tamaño del array o vector
             * @param max es el número ingresado por teclado
             * @return tamanyoArray - Tamaño del vector o array.
             */
            int tamanyoArray = max + 1;

            boolean[] esPrimo = new boolean[tamanyoArray];
        /**
         * Función para inicializar el array
         *
         */
            for (i=0; i< tamanyoArray; i++)
                esPrimo[i] = true;
    /**
     * Función para eliminar el 0 y el 1, que no son primos
    *
    */
            esPrimo[0] = esPrimo[1] = false;
/**
 * Función de la criba propiamente
 *
 */
            criba(tamanyoArray, esPrimo);
/**
 * Función que determina cuántos primos hay
 *
 */
            int cuentaPrimos = getCuentaPrimos(tamanyoArray, esPrimo);
/**
 * Función que rellena el vector de números primos
 * @return primos - los números primos
 */
            int[] primos = getPrimos(tamanyoArray, esPrimo, cuentaPrimos);
            return primos;
        } else {
            /**
             * Función que devuelve el vector vacío si max es menor a 2.
             * @return el número introducido.
             */
            return new int[0];

        }
    }

    /**
     * Función que rellena el vector de números primos
     * @param tamanyoArray tamaño del vector o array
     * @param esPrimo vector de primos
     * @param cuentaPrimos cuenta los primos que hay en el vector
     * @return primos - los números primos
     */
    public static int[] getPrimos(int tamanyoArray, boolean[] esPrimo, int cuentaPrimos) {
        int j;
        int i;
        int[] primos = new int[cuentaPrimos];
        for (i=0, j=0; i< tamanyoArray; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
        return primos;
    }

    /**
     * Función que determina cuántos primos hay
     * @param tamanyoArray tamaño del vector o array
     * @param esPrimo vector de primos
     * @return cuentaPrimos - cuántos primos hay
     */
    public static int getCuentaPrimos(int tamanyoArray, boolean[] esPrimo) {
        int i;
        int cuentaPrimos = 0;
        for (i=0; i< tamanyoArray; i++) {
            if (esPrimo[i])
                cuentaPrimos++;
        }
        return cuentaPrimos;
    }

    /**
     * Función de la criba propiamente
     * @param tamanyoArray tamaño del vector o array
     * @param esPrimo vector de primos
     */
    public static void criba(int tamanyoArray, boolean[] esPrimo) {
        int i;
        int j;
        for (i=2; i<Math.sqrt(tamanyoArray)+1; i++) {
            if (esPrimo[i]) {
/**
 * Función para eliminar los múltiplos de i
 * @return <ul>
 *      *       <li>true si es primo</li>
 *      *       <li>false si es múltiplo</li>
 *      * </ul>
 */
                for (j=2*i; j< tamanyoArray; j+=i)
                    esPrimo[j] = false;
            }
        }
    }

    /**
     * Solicita el número a introducir por teclado e imprime los vectores inicial y de primos.
     *
     */
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato=teclado.nextInt();
        int[] vector=new int[dato];
        System.out.println("\nVector inicial hasta : "+dato);
        mostrarVector(vector);
        vector=generarPrimos(dato);
        System.out.println("\nVector de primos hasta: "+dato);
        mostrarVector(vector);
    }


    /**
     * Función que, al imprimir, salta una línea cada 10 números
     * @param i cantidad de números
     */
    public static void saltaLinea(int i) {
        if (i %10==0) System.out.println();
    }

    /**
     * Función para imprimir los números del vector
     * @param vector es el vector o array
     *
     */
    public static void mostrarVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            saltaLinea(i);
            /**
             * Función para imprimir todos los números separados por un espacio desde 1.
             */
            if (vector[0]==0) {
                System.out.print(i+1+"\t");
            }
            /**
             * Función para imprimir solamente los números primos separados por un espacio.
             */
            if (vector[0]!=0) {
                System.out.print(vector[i]+"\t");
            }
        }
    }


}
