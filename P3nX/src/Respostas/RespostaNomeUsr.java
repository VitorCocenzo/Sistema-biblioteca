package Respostas;

import java.util.Scanner;

public class RespostaNomeUsr{

    public static String respostaNome(){
        int count=0;
        boolean auxResposta = true;

        while(auxResposta){
            try{

                if(count == 4){
                    break;
                }

                count++;
                Scanner teclado = new Scanner(System.in);

                System.out.print("Nome do usuario (Nao pode conter numeros nem caracteres especiais): ");
                String nome = teclado.next();                
                
                if(nome.matches("[A-Za-z]+(\\s+[A-Za-z]+)?")){
                    auxResposta=false;
                    return nome;
                }else{
                    throw new Exception();
                }
                
            }catch(Exception e){
                if(count == 4){
                    break;
                }
                System.out.println("Nome invalido");
                System.out.println("Tente novamente: (" + (4-count) + " tentativas)");
                auxResposta = true;
            }
        }
        return "ERRO";
    }
}
