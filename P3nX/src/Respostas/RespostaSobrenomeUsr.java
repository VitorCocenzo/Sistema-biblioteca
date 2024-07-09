package Respostas;

import java.util.Scanner;

    public class RespostaSobrenomeUsr {

        public static String resposta(){
            int count=0;
            boolean auxResposta = true;

            while(auxResposta){
                try{

                    if(count == 4){
                        break;
                    }

                    count++;
                    System.out.print("Sobrenome do usuario (Nao pode conter numeros nem caracteres especiais): ");
                    
                    Scanner teclado = new Scanner(System.in);
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
                    System.out.println("Sobrenome invalido");
                    System.out.println("Tente novamente: (" + (4-count) + " tentativas)");
                    auxResposta = true;
                }
            }
            return "ERRO";
        }
}
