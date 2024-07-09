package Respostas;
import lp2g36.biblioteca.ValidaCPF;

import java.util.Scanner;

public class RespostaCPF {

    public static String isCPFValido() {
        boolean auxResposta = true;
        int count = 0;
        
        while(auxResposta){

            try {
                if(count == 4){
                    break;
                    }
                count++;

                System.out.print("CPF do usuario: ");
                Scanner teclado = new Scanner(System.in);
                String stringCPF = teclado.nextLine();

                if(ValidaCPF.isCPF(stringCPF)){
                    return stringCPF;
                }else{
                    throw new Exception();
                }

            } catch (Exception e) {

                if(count == 4){
                    break;
                }

                System.out.println("CPF invalido");
                System.out.println("Tente novamente: (" + (4-count) + " tentativas)");
                auxResposta = true;
                }
        }
        return "12345678910";
    }
}
