package Respostas;

import java.util.Scanner;

public class Cadastro {

    public static int cadastro(){
        System.out.println("O que deseja fazer: ");
        System.out.println("1.Cadastrar usuarios/livros");
        System.out.println("2.Salvar cadastros em arquivos");
        System.out.println("3.Acessar menu de emprestimos");
        System.out.println("4.Relatorio da biblioteca");
        System.out.println("5.Politica da biblioteca");
        System.out.println("6.Sair(Encerra o programa)");
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
                
                
                if((respostaAux) >= 1 && (respostaAux) <= 6){
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

