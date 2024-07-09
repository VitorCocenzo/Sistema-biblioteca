import java.util.Scanner;

import Respostas.ClearTerminal;

public class PoliticaBiblioteca {

    public static int opcao() {
        System.out.println("\nO que deseja fazer: ");
        System.out.println("1.Definir um numero maximo de dias que o usuario pode permancer com um livro");
        System.out.println("2.Definir uma multa(Padrão e R$0.00)");
        System.out.println("3.Definir maximo de copias que usuario pode ter de uma vez");
        System.out.println("4.Restringir emprestimos quando ha atraso");
        System.out.println("5.Voltar ao menu principal");

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
                int respOpcao = teclado.nextInt();
                teclado.nextLine();

                if((respOpcao) >= 1 && (respOpcao) <= 5){
                    auxResposta = false;
                    ClearTerminal.clear();
                    
                    return (respOpcao);
                }else{
                    throw new IllegalArgumentException();
                }
                
            } catch (Exception e) {

                if(count == 4){
                    break;
                }

                System.out.println("Opcao invalida");
                System.out.println("Tente novamente: (" + (4-count) + " tentativas)");
                auxResposta = true;
                }
        }
        return -1;
    }
}
