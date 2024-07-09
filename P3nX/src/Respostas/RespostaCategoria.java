package Respostas;

import java.util.Scanner;

public class RespostaCategoria {

    public static String catLivro() {
        boolean auxResposta = true;
        int count = 0;
        
        while(auxResposta){

            try {
                if(count == 4){
                    break;
                }

                count++;

                System.out.print("Categoria do livro: ");
                Scanner teclado = new Scanner(System.in);
                String respCategoria = teclado.next().toUpperCase();

                switch (respCategoria) {
                    case "ROMANCE":
                        return respCategoria = "ROMANCE";
                    case "FICCAO":
                        return respCategoria = "FICCAO";
                    case "AVENTURA":
                        return respCategoria = "AVENTURA";
                    case "NOVELA":
                        return respCategoria = "NOVELA";
                    case "DRAMA":
                        return respCategoria = "DRAMA";
                    case "CONTO":
                        return respCategoria = "CONTO";
                    case "CRONICA":
                        return respCategoria = "CRONICA";
                    case "POESIA":
                        return respCategoria = "POESIA";
                    case "CARTA":
                        return respCategoria = "CARTA";
                    case "BIOGRAFIA":
                        return respCategoria = "BIOGRAFIA";
                    case "HQ":
                        return respCategoria = "HQ";
                    case "LITERATURA":
                        return respCategoria = "LITERATURA";
                    case "TERROR":
                        respCategoria = "TERROR";
                    case "REALISMO":
                        return respCategoria = "REALISMO";
                    case "ARTIGO":
                        return respCategoria = "ARTIGO";
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {

                if(count == 4){
                    break;
                }

                System.out.println("Categoria invalida");
                System.out.println("Tente novamente: (" + (4-count) + " tentativas)");
                auxResposta = true;
                }
        }
        return "ERRO";
    }
}
