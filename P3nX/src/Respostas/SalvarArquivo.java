package Respostas;

import java.util.Scanner;

public class SalvarArquivo {

    public static int salvamento(){
        System.out.println("O que deseja fazer: ");
        System.out.println("1.Salvar o cadastro de usuarios");
        System.out.println("2.Salvar o cadastro de livros");
        System.out.println("3.Salvar ambos(Usuarios e livros)");
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
