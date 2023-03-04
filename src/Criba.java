import java.util.Scanner;

/***
 * Criba refactorizado
 */
public class Criba
{
    // Generar números primos de 1 a max
    public static int[] generarPrimos (int max)
    {
        int i;
        if (max >= 2) {
// Declaraciones
            int tamanyoArray = max + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[tamanyoArray];
// Inicializar el array
            for (i=0; i< tamanyoArray; i++)
                esPrimo[i] = true;
// Eliminar el 0 y el 1, que no son primos
            esPrimo[0] = esPrimo[1] = false;
// Criba
            criba(tamanyoArray, esPrimo);
// ¿Cuántos primos hay?
            int cuentaPrimos = getCuentaPrimos(tamanyoArray, esPrimo);
// Rellenar el vector de números primos
            int[] primos = getPrimos(tamanyoArray, esPrimo, cuentaPrimos);
            return primos;
        } else { // max < 2
            return new int[0];
// Vector vacío
        }
    }

    private static int[] getPrimos(int tamanyoArray, boolean[] esPrimo, int cuentaPrimos) {
        int j;
        int i;
        int[] primos = new int[cuentaPrimos];
        for (i=0, j=0; i< tamanyoArray; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
        return primos;
    }

    private static int getCuentaPrimos(int tamanyoArray, boolean[] esPrimo) {
        int i;
        int cuentaPrimos = 0;
        for (i=0; i< tamanyoArray; i++) {
            if (esPrimo[i])
                cuentaPrimos++;
        }
        return cuentaPrimos;
    }

    private static void criba(int tamanyoArray, boolean[] esPrimo) {
        int i;
        int j;
        for (i=2; i<Math.sqrt(tamanyoArray)+1; i++) {
            if (esPrimo[i]) {
// Eliminar los múltiplos de i
                for (j=2*i; j< tamanyoArray; j+=i)
                    esPrimo[j] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato=teclado.nextInt();
        int[] vector=new int[dato];
        System.out.println("\nVector inicial hasta :"+dato);
        mostrarVector(vector);
        vector=generarPrimos(dato);
        System.out.println("\nVector de primos hasta:"+dato);
        mostrarVector(vector);
    }



    private static void saltaLinea(int i) {
        if (i %10==0) System.out.println();
    }
    private static void mostrarVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            saltaLinea(i);
            if (vector[0]==0) {
                System.out.print(i+1+"\t");
            }
            if (vector[0]!=0) {
                System.out.print(vector[i]+"\t");
            }
        }
    }


}
