package Respostas;

import java.util.Scanner;

public class CdastroLU {

    public static int opcao(){
        System.out.println("\nO que deseja fazer: ");
        System.out.println("1.Cadastrar usuarios");
        System.out.println("2.Cadastrar livros");
        System.out.println("3.Voltar ao menu principal");
        System.out.print("Resposta: ");

        int count=0;
        boolean auxResposta = true;

        while(auxResposta){
            try{

                if(count == 4){
                    break;
                }

                count++;
                Scanner teclado = new Scanner(System.in);
                int respostaAux = teclado.nextInt();
                teclado.nextLine();
                
                
                if((respostaAux) >= 1 && (respostaAux) <= 3){
                    auxResposta = false;
                    ClearTerminal.clear();
                    return (respostaAux);
                }else{
                    throw new Exception();
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

