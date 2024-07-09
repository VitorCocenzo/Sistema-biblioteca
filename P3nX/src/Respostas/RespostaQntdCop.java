package Respostas;

import java.util.Scanner;

public class RespostaQntdCop {

    public static int qntdCop() {
        boolean auxResposta = true;
        int count = 0;
        
        while(auxResposta){

            try {
                if(count == 4){
                    break;
                }

                count++;

                System.out.print("Quantidade de copias do livro: ");
                Scanner teclado = new Scanner(System.in);
                int Qntd = teclado.nextInt();

                if(Qntd>0 && Qntd<10000){
                    return Qntd;
                }else{
                    throw new Exception();
                }

            } catch (Exception e) {

                if(count == 4){
                    break;
                }

                System.out.println("Quantidade de copias invalidas");
                System.out.println("Tente novamente: (" + (4-count) + " tentativas)");
                auxResposta = true;
                }
        }
        return -1;
    }
}
