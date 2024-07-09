package Respostas;

import java.util.Scanner;

public class RespostaMulta {

    public static int resposta() {
        boolean auxResposta = true;
        int count = 0;
        
        while(auxResposta){

            try {
                if(count == 4){
                    break;
                }

                count++;

                System.out.print("Numero maximo de dias que o usuario pode ficar com o livro: ");
                Scanner teclado = new Scanner(System.in);
                int respMulta = teclado.nextInt();

                if(respMulta<0){
                    throw new IllegalArgumentException();
                }else{
                    return respMulta;
                }
                
            } catch (Exception e) {

                if(count == 4){
                    break;
                }

                System.out.println("Quantia de dias invalida");
                System.out.println("Tente novamente: (" + (4-count) + " tentativas)");
                auxResposta = true;
                }
        }
        return -1;
    }
}
