package Respostas;

import java.util.Scanner;


public class RespostaCodLivro {

    public static String codLivro() {
        boolean auxResposta = true;
        int count = 0;
        
        while(auxResposta){

            try {
                if(count == 4){
                    break;
                }

                count++;

                System.out.print("Codigo do livro: ");
                Scanner teclado = new Scanner(System.in);
                String Cod = teclado.nextLine();

                if(Integer.parseInt(Cod)>0 && Integer.parseInt(Cod)<1000){
                    return Cod;
                }else{
                    throw new Exception();
                }

            } catch (Exception e) {

                if(count == 4){
                    break;
                }

                System.out.println("Codigo invalido, deve ser entre 1 e 999");
                System.out.println("Tente novamente: (" + (4-count) + " tentativas)");
                auxResposta = true;
                }
        }
        return "1000";
    }
}
