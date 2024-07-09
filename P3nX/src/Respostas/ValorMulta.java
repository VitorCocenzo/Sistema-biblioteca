package Respostas;

import java.util.Scanner;

public class ValorMulta {

    public static float valor() {
        boolean auxResposta = true;
        int count = 0;
        
        while(auxResposta){

            try {
                if(count == 4){
                    break;
                }

                count++;

                System.out.print("Valor da multa que o usuario ira tomar: ");
                Scanner teclado = new Scanner(System.in);
                Float respMulta = teclado.nextFloat();

                if(respMulta<0){
                    throw new IllegalArgumentException();
                }else{
                    return respMulta;
                }
                
            } catch (Exception e) {

                if(count == 4){
                    break;
                }

                System.out.println("Valor de multa invalido");
                System.out.println("Tente novamente: (" + (4-count) + " tentativas)");
                auxResposta = true;
                }
        }
        return -1;
    }
}
