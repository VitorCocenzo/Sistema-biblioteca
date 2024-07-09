package Respostas;

import java.util.Scanner;

public class Relatorio {

    public static int opcao(){
        System.out.println("\nO que deseja fazer: ");
        System.out.println("1.Listar acervo de livros");
        System.out.println("2.Listar acervo de usuarios");
        System.out.println("3.Verificar informacoes de um usuario especifico");
        System.out.println("4.Verificar informacoes de um livro especifico");
        System.out.println("5.Voltar ao menu principal");
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
                
                
                if((respostaAux) >= 1 && (respostaAux) <= 5){
                    auxResposta = false;
                    ClearTerminal.clear();
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
