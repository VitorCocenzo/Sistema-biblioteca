package Respostas;

import java.util.Scanner;

public class MenuEmprestimo {

    public static int opcoes(){
        System.out.println("\nO que deseja fazer: ");
        System.out.println("1.Exibir acervo de livros");
        System.out.println("2.Fazer o emprestimo de um livro");
        System.out.println("3.Devolver um livro");
        System.out.println("4.Voltar ao menu principal");
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
                
                
                if((respostaAux) == 1 || (respostaAux) ==2 || (respostaAux)==3|| (respostaAux)==4){
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
