package Respostas;

import java.util.Scanner;

public class RespostaSalvarUsr {
    
    public static String opcao() {
        boolean auxResposta = true;
        int count = 0;
        
        while(auxResposta){

            try {
                if(count == 4){
                    break;
                }

                count++;

                System.out.print("Resposta: ");
                Scanner teclado = new Scanner(System.in);
                String respMulta = teclado.nextLine();
                respMulta=respMulta.toUpperCase();

                if(respMulta.equals("SIM") || (respMulta.equals("NAO"))){
                    return respMulta;
                }else{
                    throw new IllegalArgumentException();
                }
                
            } catch (Exception e) {

                if(count == 4){
                    break;
                }

                System.out.println("Resposta invalida");
                System.out.println("Tente novamente(SIM/NAO): (" + (4-count) + " tentativas)");
                auxResposta = true;
                }
        }
        return "ERRO";
    }
}
