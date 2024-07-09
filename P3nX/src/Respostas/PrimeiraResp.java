package Respostas;

import java.util.Scanner;

public class PrimeiraResp {
    private static boolean auxResposta = true;
    
    public static int primeiraResp(){
        int count=0;

        while(auxResposta){
            try{

                if(count == 4){
                    break;
                }

                count++;
                Scanner teclado = new Scanner(System.in);
                int respostaAux = teclado.nextInt();
                teclado.nextLine();
                
                
                if((respostaAux) == 1 || (respostaAux) == 2){
                    auxResposta = false;
                    return (respostaAux);
                }else{
                    throw new IllegalArgumentException();
                }
                
            }catch(Exception e){
                if(count == 4){
                    break;
                }
                System.out.println("Opcao invalida");
                System.out.println("Tente novamente: (" + (4-count) + " tentativas)");
                auxResposta = true;
            }
        }
        return 0;
    }
}
