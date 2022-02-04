
package palindromotest;

import java.util.Scanner;

/**
 *
 * @author mdo
 */
public class PalindromoTest {
    
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        int sistema=0;
        do{            
            System.out.println("Ingrese palabra: ");
            String palabra = teclado.next();

            Test test = new Test(); 

            if(test.consulta(palabra) || test.consulta2(palabra)){
                System.out.println("SIII es Palíndromo");
            }else{
                System.out.println("NO es Palíndromo");
            }
            
            System.out.println("\n\t**Para continuar consultado ingresé 0 \n"
                    + "\t**Para salir 1");
            sistema = teclado.nextInt();
        }while(sistema==0);
    }
    
}
