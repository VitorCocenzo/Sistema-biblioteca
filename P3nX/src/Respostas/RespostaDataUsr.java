package Respostas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.util.Scanner;
import lp2g36.biblioteca.ValidaData;

public class RespostaDataUsr {

    public static LocalDate isDataValida() {
        boolean auxResposta = true;
        int count = 0;
        GregorianCalendar dataAtual = new GregorianCalendar();
        
        while(auxResposta){
            if(count == 4){
                break;
                }

            System.out.print("Data de nascimento do usuario no modelo XX/XX/XXXX: ");
            Scanner teclado = new Scanner(System.in);
            String stringData = teclado.nextLine();

            try {
                count++;
                int auxDia = Integer.parseInt(stringData.substring(0, 2));
                int auxMes = Integer.parseInt(stringData.substring(3, 5));
                int auxAno = Integer.parseInt(stringData.substring(6, 10));
                if(!ValidaData.isDataValida(auxDia, auxMes, auxAno)){
                    throw new Exception();
                }

                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                LocalDate data = LocalDate.parse(stringData, dateFormatter);

                if((dataAtual.get(GregorianCalendar.YEAR)-data.getYear())<120){
                    return data;
                }else{
                    throw new Exception();
                }

            } catch (Exception e) {

                if(count == 4){
                    break;
                }

                System.out.println("Data invalida");
                System.out.println("Tente novamente: (" + (4-count) + " tentativas)");
                auxResposta = true;
                }
        }
        return LocalDate.of(1899, 01, 01);
    }
}
