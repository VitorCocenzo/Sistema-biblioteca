import java.io.FileNotFoundException;
import java.io.InvalidClassException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import lp2g36.biblioteca.*;
import Respostas.*;

public class P3nX {
    public static void main(String[] args) throws Exception {

        Biblioteca bl = new Biblioteca();
        
        Livro l1 = new Livro(555, "A espera de um milagre", "Romance", 27);
        Livro l2 = new Livro(13, "Fisica 1", "Literatura", 30);
        Livro l3 = new Livro(274, "Vitor Cocenzo: O guerreiro", "Conto", 1);
        Livro l4 = new Livro(999, "Romeu e Julieta", "Romance", 15);
        Livro l5 = new Livro(1, "Rick and Morty", "Ficcao", 53);

        Usuario u1 = new Usuario("Vitor", "Cocenzo", 26, 11, 2004, 19526908708l, "Rua Alfredo Ceschiatti, 55");
        Usuario u2 = new Usuario("Pablo", "Escobar", 21, 2, 2010, 95834877087l, "Estrada Pau da Fome, 2715");
        Usuario u3 = new Usuario("Amanda", "Silva", 2, 5, 2001, 51807156010l, "Avenida Cesar Morani, 765");
        Usuario u4 = new Usuario("Patricia", "Escobar", 1, 1, 1986, 34039438019l, "Rua Amilcar Machado, 327");
        Usuario u5 = new Usuario("Fernanda", "Calixto", 9, 11, 1995, 25868336003l, "Avenida Abelardo Bueno, 7094");
        
        bl.cadastraLivro(l5);
        bl.cadastraLivro(l4);
        bl.cadastraLivro(l3);
        bl.cadastraLivro(l2);
        bl.cadastraLivro(l1);

        bl.cadastraUsuario(u5);
        bl.cadastraUsuario(u4);
        bl.cadastraUsuario(u3);
        bl.cadastraUsuario(u2);
        bl.cadastraUsuario(u1);

        bl.salvaArquivo("usuario", "u.dat");
        bl.salvaArquivo("livro", "l.dat");
        /*ClearTerminal.clear();
        LocalDateTime dateTime = LocalDateTime.now();
        LocalTime time = dateTime.toLocalTime();

        if (time.isBefore(LocalTime.NOON)) {
            System.out.println("---------Ola, bom dia---------");
        } else if (time.isBefore(LocalTime.of(18, 0))) {
            System.out.println("---------Ola, boa tarde---------");
        } else {
            System.out.println("---------Ola, boa noite---------");
        }  
        
        //BLOCO DE CODIGO PARA QUANDO SE CRIA UMA BIBLIOTECA
        System.out.println("1.Criar biblioteca nova");
        System.out.println("2.Carregar banco de dados da biblioteca");
        System.out.print("Resposta: ");

        try{
            int resposta = PrimeiraResp.primeiraResp();

            if(resposta == 0){
                throw new IllegalArgumentException("Tentativas maximas de resposta alcacada(Programa encerrado)");
            }

            if(resposta==1){
                Biblioteca bl = new Biblioteca();
                ClearTerminal.clear();

                System.out.println("Biblioteca gerada com sucesso!\n");
                Scanner respostas = new Scanner(System.in);

                try{
                    int resposta2 = Cadastro.cadastro();

                    while(resposta2!=6){

                        if(resposta2 == 0){
                            throw new IllegalArgumentException("Tentativas maximas de resposta alcacada(Programa encerrado)");
                        }

                        if(resposta2==1){
                            ClearTerminal.clear();

                            int resposta4 = CdastroLU.opcao();

                            if(resposta4==1){

                                String nome = RespostaNomeUsr.respostaNome();
                                if(nome.equals("ERRO")){
                                    throw new IllegalArgumentException("Tentativas maximas para nome alcancadas");
                                }
        
                                String sobrenome = RespostaSobrenomeUsr.resposta();
                                if(sobrenome.equals("ERRO")){
                                    throw new IllegalArgumentException("Tentativas maximas para sobrenome alcancadas");
                                }
                                    
                                LocalDate respData = RespostaDataUsr.isDataValida();
                                if(respData.isEqual(LocalDate.of(1899, 1, 1))){
                                    throw new IllegalArgumentException("Tentativas maximas para data alcancadas");
                                }
                                
                                System.out.print("Endereco do usuario: ");
                                String auxEndereco = respostas.nextLine();
    
                                boolean auxRespCPF2=true;
                                int count=0;
    
                                while(auxRespCPF2){
                             
                                    String auxRespCPF = RespostaCPF.isCPFValido();
    
                                    if(auxRespCPF.equals("12345678910")){   
                                        throw new IllegalArgumentException("Tentativas maximas para CPF alcancadas");
                                    }else if(bl.getCadastroUsuarios().containsKey(auxRespCPF)){
    
                                        if(count==3){
                                            throw new IllegalArgumentException("Tentativas maximas para definir o CPF alcancadas");
                                        }
    
                                        System.out.println("Ja ha um usuario com esse CPF cadastrado, tente novamente");
                                        System.out.println("voce tem "+(3-count)+" tentativas");
                                        count++;
                                        auxRespCPF2=true;
                                    }else{
                                        Usuario usuario = new Usuario(nome, sobrenome, respData.getDayOfMonth(), 
                                        respData.getMonthValue(), respData.getYear(),ValidaCPF.toLong(auxRespCPF), auxEndereco );
                                        bl.cadastraUsuario(usuario);
                                        break;
                                    }
                                }
        
                                System.out.println("Usuario cadastrado com sucesso!\n");
                                System.out.println("Voce ja deseja salvar esse usuario no banco de dados? (Ele podera ser salvo futuramente)");
    
                                String respostaSaveUsr = RespostaSalvarUsr.opcao();
    
                                if(respostaSaveUsr.equals("ERRO")){
                                    throw new IllegalArgumentException("Tentativas maximas para definir se salvaria o usuario alcancadas");
    
                                }else if(respostaSaveUsr.equals("SIM")){
                                    System.out.println("Qual o nome do arquivo que o usuario sera salvo?");
                                    System.out.print("Resposta: ");
                                    String respSalvaArq = respostas.nextLine();
                                    bl.salvaArquivo("usuario", respSalvaArq);
                                    ClearTerminal.clear();
                                    System.out.println("Usuario salvo no arquivo "+ respSalvaArq +"\n");
    
                                }else{
                                    ClearTerminal.clear();
                                }
                            }

                            if(resposta4==2){

                                ClearTerminal.clear();
        
                                System.out.print("Titulo do livro: ");
                                String tituloLivro = respostas.nextLine();
        
                                String catLivro = RespostaCategoria.catLivro().toUpperCase();
                                if(catLivro.equals("ERRO")){
                                    throw new IllegalArgumentException("Tentativas maximas para o categoria do livro alcancadas");
                                }
        
                                int auxQntd = RespostaQntdCop.qntdCop();
                                if(auxQntd==-1){
                                    throw new IllegalArgumentException("Tentativas maximas para quantidade de copias alcancadas");
                                }
        
                                boolean auxRespCodLivro=true;
                                int count =0;
        
                                while(auxRespCodLivro){
        
                                    String codLivro = RespostaCodLivro.codLivro();
        
                                    if(codLivro.equals(1000)){
                                        throw new IllegalArgumentException("Tentativas maximas para o definir codigo do livro alcancadas");
                                    }else if(bl.getCadastroLivros().containsKey(codLivro)){
                                        if(count==3){
                                            throw new IllegalArgumentException("Tentativas maximas para definir o codigo do livro alcancadas");
                                        }
                                        System.out.println("Ja ha um livro com esse codigo cadastrado, tente novamente");
                                        System.out.println("voce tem "+(3-count)+" tentativas");
                                        count++;
                                        auxRespCodLivro=true;
                                    }else{
                                        Livro livro = new Livro(Integer.parseInt(codLivro), tituloLivro, catLivro, auxQntd);
                    
                                        bl.cadastraLivro(livro);
                                        break;
                                    }
                                }
        
                                ClearTerminal.clear();
                                System.out.println("\nLivro cadastrado com sucesso\n");System.out.println("Voce ja deseja salvar esse livro no banco de dados? (Ele podera ser salvo futuramente)");
        
                                String respostaSaveUsr = RespostaSalvarUsr.opcao();
        
                                if(respostaSaveUsr.equals("ERRO")){
                                    throw new IllegalArgumentException("Tentativas maximas para definir se salvaria o livro alcancadas");
        
                                }else if(respostaSaveUsr.equals("SIM")){
                                    System.out.println("Qual o nome do arquivo que o livro sera salvo?");
                                    System.out.print("Resposta: ");
                                    String respSalvaArq = respostas.nextLine();
                                    bl.salvaArquivo("livro", respSalvaArq);
                                    ClearTerminal.clear();
                                    System.out.println("Livro salvo no arquivo "+ respSalvaArq +"\n");
        
                                }else{
                                    ClearTerminal.clear();
                                }
                            }
                        }

                        if(resposta2 == 2){
                            ClearTerminal.clear();

                            int resposta3 = SalvarArquivo.salvamento();

                            if(resposta3==0){
                                throw new IllegalArgumentException("Tentativas maximas para salvar arquivo alcancadas");
                            }

                            if(resposta3==1){
                                System.out.print("Nome do arquivo em que o banco de dados de usuarios sera salvo: ");
                                String nomeArquivo = respostas.nextLine();
                                bl.salvaArquivo("usuario", nomeArquivo);
                                ClearTerminal.clear();
                                System.out.println("Acervo de usuarios salvo com sucesso em " + nomeArquivo+"\n");
                            }
                            if(resposta3==2){
                                System.out.print("Nome do arquivo em que o banco de dados de livros sera salvo: ");
                                String nomeArquivo = respostas.nextLine();
                                bl.salvaArquivo("livros", nomeArquivo);
                                ClearTerminal.clear();
                                System.out.println("Acervo de livros salvo com sucesso em " + nomeArquivo+"\n");
                            }

                            if(resposta3==3){
                                System.out.print("Nome do arquivo em que o banco de dados de usuarios sera salvo: ");
                                String nomeArquivo1 = respostas.nextLine();
                                bl.salvaArquivo("usuario", nomeArquivo1);

                                System.out.print("Nome do arquivo em que o banco de dados de livros sera salvo: ");
                                String nomeArquivo2 = respostas.nextLine();
                                bl.salvaArquivo("livros", nomeArquivo2);

                                ClearTerminal.clear();
                                System.out.println("Acervo de livros salo com sucesso em " + nomeArquivo1 + " e de usuarios salvo em "+nomeArquivo2+"\n");
                            }

                        }

                        if(resposta2 == 3){
                            ClearTerminal.clear();

                            int auxOpcoes = MenuEmprestimo.opcoes();
                            if(auxOpcoes==0){
                                throw new IllegalArgumentException("Tentativas maximas no menu de emprestimo alcancadas");
                            }

                            if(auxOpcoes==1){
                                System.out.println(bl.imprimeLivros());
                            }

                            if(auxOpcoes==2){
                                int contadorRespEmrprestimo=0;
                                
                                while(contadorRespEmrprestimo<4){
                                    try{
                                        contadorRespEmrprestimo++;
                                        System.out.print("Insira o codigo do livro que deseja emprestar: ");

                                        int auxCodLivro = respostas.nextInt();
                                        respostas.nextLine();
                                        Livro livro = bl.getLivro(auxCodLivro);
        
                                        System.out.print("Insira o CPF do usuario que deseja emprestar tal livro: ");
        
                                        String auxCodUsr = respostas.nextLine();
                                        long auxLong = ValidaCPF.toLong(auxCodUsr);
                                        auxCodUsr = String.valueOf(auxLong);

                                        Usuario usr = bl.getUsuario(auxCodUsr);
        
                                        ClearTerminal.clear();
                                        
                                        try{
                                            bl.emprestaLivro(usr, livro);
                                        }catch(IllegalArgumentException iae){
                                            System.out.println(iae.getMessage());
                                            break;
                                        }
                                        
                                        System.out.println("\nEmprestimo do livro "+ auxCodLivro+ " realizado com sucesso!\n");
                                        System.out.println(" [" + usr.getNumCPF() + "="+usr.toString());
                                        System.out.println(" [" + livro.getCodigoLivro()+"="+livro.toString());
                                        break;

                                    }catch(LivroNaoCadastradoEX lnc){

                                        if(contadorRespEmrprestimo==4){
                                            throw new IllegalArgumentException("Nao ha nenhum livro com este codigo cadastrado");
                                            }

                                        System.out.println("Livro invalido");
                                        System.out.println("Tente novamente: (" + (4-contadorRespEmrprestimo) + " tentativas)");
                                        
                                    }catch(UsuarioNaoCadastradoEX unc){

                                        if(contadorRespEmrprestimo==4){
                                            throw new IllegalArgumentException("Nao ha nenhum usuario com esse CPF cadastrado");
                                            }

                                        System.out.println("Usuario invalido");
                                        System.out.println("Tente novamente: (" + (4-contadorRespEmrprestimo) + " tentativas)");

                                    }catch(InputMismatchException ime){
                                        respostas.nextLine();

                                        if(contadorRespEmrprestimo==4){
                                            throw new IllegalArgumentException("Tentativas maximas alcancadas de emprestar um livro a um usuario");
                                            }

                                        System.out.println("Valor invalido");
                                        System.out.println("Tente novamente: (" + (4-contadorRespEmrprestimo) + " tentativas)");

                                    }catch(CopiaNaoDisponivelEX cnd){
                                        if(contadorRespEmrprestimo==4){
                                            throw new IllegalArgumentException("Tentativas maximas alcancadas de emprestar um livro a um usuario");
                                        }

                                        System.out.println("Nenhuma copia desse livro disponivel");
                                        System.out.println("Tente novamente, com outro livro: (" + (4-contadorRespEmrprestimo) + " tentativas)");
                                    }
                                }
                            }

                            if(auxOpcoes==3){
                                int contadorRespEmrprestimo=0;
                                
                                while(contadorRespEmrprestimo<4){
                                    try{
                                        contadorRespEmrprestimo++;
                                        System.out.print("Insira o codigo do livro que deseja devolver: ");

                                        int auxCodLivro = respostas.nextInt();
                                        respostas.nextLine();
                                        Livro livro = bl.getLivro(auxCodLivro);
        
                                        System.out.print("Insira o CPF do usuario que deseja devolver tal livro: ");
        
                                        String auxCodUsr = respostas.nextLine();
                                        long auxLong = ValidaCPF.toLong(auxCodUsr);
                                                    auxCodUsr = String.valueOf(auxLong);
                                        Usuario usr = bl.getUsuario(auxCodUsr);
        
                                        bl.devolveLivro(usr, livro);
                                        System.out.println("\nDevolucao do livro "+ auxCodLivro+ " realizada com sucesso!\n");
                                        System.out.println(" [" + usr.getNumCPF() + "="+usr.toString());
                                        System.out.println(" [" + livro.getCodigoLivro()+"="+livro.toString());
                                        break;

                                    }catch(LivroNaoCadastradoEX lnc){

                                        if(contadorRespEmrprestimo==4){
                                            throw new LivroNaoCadastradoEX();
                                            }

                                        System.out.println("Livro invalido");
                                        System.out.println("Tente novamente: (" + (4-contadorRespEmrprestimo) + " tentativas)");
                                        
                                    }catch(UsuarioNaoCadastradoEX unc){

                                        if(contadorRespEmrprestimo==4){
                                            throw new UsuarioNaoCadastradoEX();
                                            }

                                        System.out.println("Usuario invalido");
                                        System.out.println("Tente novamente: (" + (4-contadorRespEmrprestimo) + " tentativas)");

                                    }catch(InputMismatchException ime){
                                        respostas.nextLine();

                                        if(contadorRespEmrprestimo==4){
                                            throw new IllegalArgumentException("Tentativas maximas alcancadas de devolver um livro a um usuario");
                                            }

                                        System.out.println("Valor invalido");
                                        System.out.println("Tente novamente: (" + (4-contadorRespEmrprestimo) + " tentativas)");

                                    }catch(NenhumaCopiaEmprestadaEX cnd){
                                        if(contadorRespEmrprestimo==4){
                                            throw new IllegalArgumentException("Tentativas maximas alcancadas de devolver um livro a um usuario");
                                        }

                                        System.out.println("Nenhuma copia desse livro emprestada");
                                        System.out.println("Tente novamente, com outro livro: (" + (4-contadorRespEmrprestimo) + " tentativas)");
                                    }
                                }
                            }
                        }

                        if(resposta2 == 4){
                            ClearTerminal.clear();

                            int respRelatorio = Relatorio.opcao();
                            if(respRelatorio ==0){
                                throw new IllegalArgumentException("Tentativas maximas alcancadas de verificar o relatorio da biblioteca");
                            }

                            if(respRelatorio==1){
                                System.out.println(bl.imprimeLivros());
                            }

                            if(respRelatorio==2){
                                System.out.println(bl.imprimeUsuarios());
                            }

                            if(respRelatorio==3){
                                int countadorRelatorioUsr=0;

                                while(countadorRelatorioUsr<4){
                                    try{
                                        countadorRelatorioUsr++;
                                        System.out.print("Insira o CPF do usuario que deseja verificar: ");

                                        String auxCodUsr = respostas.nextLine();
                                        Usuario usr = bl.getUsuario(auxCodUsr);
                                        System.out.println(" [" + usr.getNumCPF() + "=" + usr.toString());
                                    }catch(UsuarioNaoCadastradoEX unc){

                                        if(countadorRelatorioUsr==4){
                                            throw new UsuarioNaoCadastradoEX("Tentativas maximas de verificar o usuario alcancadas");
                                            }

                                        System.out.println("Usuario invalido");
                                        System.out.println("Tente novamente: (" + (4-countadorRelatorioUsr) + " tentativas)");

                                    }
                                }
                            }

                            if(respRelatorio==4){
                                int countadorRelatorio=0;

                                while(countadorRelatorio<4){
                                    try{
                                        countadorRelatorio++;
                                        System.out.print("Insira o codigo do livro que deseja verificar: ");

                                        int auxCodLivro = respostas.nextInt();
                                        respostas.nextLine();
                                        Livro livro = bl.getLivro(auxCodLivro);
                                        System.out.println(" [" + livro.getCodigoLivro() + "=" + livro.toString());
                                    }catch(LivroNaoCadastradoEX unc){

                                        if(countadorRelatorio==4){
                                            throw new LivroNaoCadastradoEX("Tentativas maximas de verificar o livro alcancadas");
                                            }

                                        System.out.println("Livro invalido");
                                        System.out.println("Tente novamente: (" + (4-countadorRelatorio) + " tentativas)");

                                    }
                                }
                            }

                        }if(resposta2 == 5){
                            ClearTerminal.clear();

                            int auxPoliticaBiblioteca = PoliticaBiblioteca.opcao();

                            if(auxPoliticaBiblioteca==-1){
                                throw new IllegalArgumentException("Tentativas maximas de definir uma politica atingido");
                            }

                            if(auxPoliticaBiblioteca==1){
                                int auxRespMulta = RespostaMulta.resposta();

                                if(auxRespMulta==-1){
                                    throw new IllegalArgumentException("Tentativas de definir um tempo maximo com o livro toleravel esgotadas");
                                }else{
                                    ClearTerminal.clear();

                                    bl.setMaximoDiasComLivro(auxRespMulta);
                                    System.out.println("Numero maximo de dias que o usuario pode permanceer com o livro definido em: "+auxRespMulta);
                                }
                            }

                            if(auxPoliticaBiblioteca==2){
                                float auxValorMulta = ValorMulta.valor();
                                if(auxValorMulta==-1){
                                    throw new IllegalArgumentException("Tentativas de definir uma multa esgotadas");
                                }else{
                                    ClearTerminal.clear();

                                    bl.setValorMulta(auxValorMulta);
                                    System.out.println("Valor da multa definido em: R$"+auxValorMulta);
                                }
                            }

                            if(auxPoliticaBiblioteca==3){
                                int auxMaxNumCop = MaximoNumCop.valorMax();
                                if(auxMaxNumCop==0){
                                    throw new IllegalArgumentException("Tentativas maximas de definir um numero de copias maximo foi alcancado");
                                }else{
                                    ClearTerminal.clear();
                                    System.out.println("Numero maximo de livros que o usuairo pode ter simultanemante foi definido para "+auxMaxNumCop);
                                    bl.setMaximoNumCop(auxMaxNumCop);
                                }
                            }
                            
                            if(auxPoliticaBiblioteca==4){
                                System.out.println("Deseja restringir o usuario que possuir um atraso?");
                                String auxresp = RespostaSalvarUsr.opcao();
                                if(auxresp.equals("ERRO")){
                                    throw new IllegalArgumentException("Tentativas maximas para definir se haveria restricao alcancadas");
    
                                }else if(auxresp.equals("SIM")){
                                    bl.setRestringirAraso(true);
                                    ClearTerminal.clear();
                                    System.out.println("Restricao ao usuario definida como verdadeira\n");
                                }else{
                                    ClearTerminal.clear();
                                }
                            }
                        }

                    resposta2 = Cadastro.cadastro();

                    //fim while
                    }
                        
                }catch(IllegalArgumentException iae){
                    throw new IllegalArgumentException("Erro na gestao da manutencao devido a: " + iae.getMessage());
                }catch(LivroNaoCadastradoEX lnc){
                    System.out.println("Erro na gestao da manutencao devido a: " + lnc.getMessage());
                }catch(UsuarioNaoCadastradoEX unc){
                    System.out.println("Erro na gestao da manutencao devido a: " + unc.getMessage());
                }
            }

            //BLOCO DE CODIGO PARA QUANDO SE CARREGA UMA BIBLIOTECA
            if(resposta==2){
                    boolean auxResposta = true;
                    int count=0;

                    while(auxResposta){
                        try{

                            if(count == 4){
                                throw new IllegalArgumentException("Tentativas maximas de carregamento de arquivo alcancadas(Programa encerrado)");
                            }

                            count++;

                            Scanner teclado = new Scanner(System.in);
                            System.out.print("Nome do arquivo de banco de dados de usuarios: ");
                            String arquivoUsr = teclado.nextLine();
                    
                            System.out.print("Nome do arquivo de banco de dados de livros: ");
                            String arquivoLivros = teclado.nextLine();
                    
                            Biblioteca bl = new Biblioteca(arquivoUsr, arquivoLivros);
                            ClearTerminal.clear();;
                            System.out.println("Biblioteca carregada com sucesso!\n");
                            auxResposta = false;

                            Scanner respostas = new Scanner(System.in);

                            try{
                                int resposta2 = Cadastro.cadastro();
            
                                while(resposta2!=6){
            
                                    if(resposta2 == 0){
                                        throw new IllegalArgumentException("Tentativas maximas de resposta alcacada(Programa encerrado)");
                                    }
            
                                    if(resposta2==1){
                                        ClearTerminal.clear();
            
                                        int resposta4 = CdastroLU.opcao();

                                        if(resposta4==1){

                                            String nome = RespostaNomeUsr.respostaNome();
                                            if(nome.equals("ERRO")){
                                                throw new IllegalArgumentException("Tentativas maximas para nome alcancadas");
                                            }
                    
                                            String sobrenome = RespostaSobrenomeUsr.resposta();
                                            if(sobrenome.equals("ERRO")){
                                                throw new IllegalArgumentException("Tentativas maximas para sobrenome alcancadas");
                                            }
                                                
                                            LocalDate respData = RespostaDataUsr.isDataValida();
                                            if(respData.isEqual(LocalDate.of(1899, 1, 1))){
                                                throw new IllegalArgumentException("Tentativas maximas para data alcancadas");
                                            }
                                            
                                            System.out.print("Endereco do usuario: ");
                                            String auxEndereco = respostas.nextLine();
                
                                            boolean auxRespCPF2=true;
                                            int count2=0;
                
                                            while(auxRespCPF2){
                                        
                                                String auxRespCPF = RespostaCPF.isCPFValido();
                
                                                if(auxRespCPF.equals("12345678910")){   
                                                    throw new IllegalArgumentException("Tentativas maximas para CPF alcancadas");
                                                }else if(bl.getCadastroUsuarios().containsKey(auxRespCPF)){
                
                                                    if(count2==3){
                                                        throw new IllegalArgumentException("Tentativas maximas para definir o CPF alcancadas");
                                                    }
                
                                                    System.out.println("Ja ha um usuario com esse CPF cadastrado, tente novamente");
                                                    System.out.println("voce tem "+(3-count2)+" tentativas");
                                                    count2++;
                                                    auxRespCPF2=true;
                                                }else{
                                                    Usuario usuario = new Usuario(nome, sobrenome, respData.getDayOfMonth(), 
                                                    respData.getMonthValue(), respData.getYear(),ValidaCPF.toLong(auxRespCPF), auxEndereco );
                                                    bl.cadastraUsuario(usuario);
                                                    break;
                                                }
                                            }
                    
                                            System.out.println("Usuario cadastrado com sucesso!\n");
                                            System.out.println("Voce ja deseja salvar esse usuario no banco de dados? (Ele podera ser salvo futuramente)");
                
                                            String respostaSaveUsr = RespostaSalvarUsr.opcao();
                
                                            if(respostaSaveUsr.equals("ERRO")){
                                                throw new IllegalArgumentException("Tentativas maximas para definir se salvaria o usuario alcancadas");
                
                                            }else if(respostaSaveUsr.equals("SIM")){
                                                System.out.println("Qual o nome do arquivo que o usuario sera salvo?");
                                                System.out.print("Resposta: ");
                                                String respSalvaArq = respostas.nextLine();
                                                bl.salvaArquivo("usuario", respSalvaArq);
                                                ClearTerminal.clear();
                                                System.out.println("Usuario salvo no arquivo "+ respSalvaArq +"\n");
                
                                            }else{
                                                ClearTerminal.clear();
                                            }
                                        }

                                        if(resposta4==2){

                                            ClearTerminal.clear();
                    
                                            System.out.print("Titulo do livro: ");
                                            String tituloLivro = respostas.nextLine();
                    
                                            String catLivro = RespostaCategoria.catLivro().toUpperCase();
                                            if(catLivro.equals("ERRO")){
                                                throw new IllegalArgumentException("Tentativas maximas para o categoria do livro alcancadas");
                                            }
                    
                                            int auxQntd = RespostaQntdCop.qntdCop();
                                            if(auxQntd==-1){
                                                throw new IllegalArgumentException("Tentativas maximas para quantidade de copias alcancadas");
                                            }
                    
                                            boolean auxRespCodLivro=true;
                                            int count3 =0;
                    
                                            while(auxRespCodLivro){
                    
                                                String codLivro = RespostaCodLivro.codLivro();
                    
                                                if(codLivro.equals(1000)){
                                                    throw new IllegalArgumentException("Tentativas maximas para o definir codigo do livro alcancadas");
                                                }else if(bl.getCadastroLivros().containsKey(codLivro)){
                                                    if(count3==3){
                                                        throw new IllegalArgumentException("Tentativas maximas para definir o codigo do livro alcancadas");
                                                    }
                                                    System.out.println("Ja ha um livro com esse codigo cadastrado, tente novamente");
                                                    System.out.println("voce tem "+(3-count3)+" tentativas");
                                                    count3++;
                                                    auxRespCodLivro=true;
                                                }else{
                                                    Livro livro = new Livro(Integer.parseInt(codLivro), tituloLivro, catLivro, auxQntd);
                                
                                                    bl.cadastraLivro(livro);
                                                    break;
                                                }
                                            }
                    
                                            ClearTerminal.clear();
                                            System.out.println("\nLivro cadastrado com sucesso\n");System.out.println("Voce ja deseja salvar esse livro no banco de dados? (Ele podera ser salvo futuramente)");
                    
                                            String respostaSaveUsr = RespostaSalvarUsr.opcao();
                    
                                            if(respostaSaveUsr.equals("ERRO")){
                                                throw new IllegalArgumentException("Tentativas maximas para definir se salvaria o livro alcancadas");
                    
                                            }else if(respostaSaveUsr.equals("SIM")){
                                                System.out.println("Qual o nome do arquivo que o livro sera salvo?");
                                                System.out.print("Resposta: ");
                                                String respSalvaArq = respostas.nextLine();
                                                bl.salvaArquivo("livro", respSalvaArq);
                                                ClearTerminal.clear();
                                                System.out.println("Livro salvo no arquivo "+ respSalvaArq +"\n");
                    
                                            }else{
                                                ClearTerminal.clear();
                                            }
                                        }
                                    }
            
                                    if(resposta2 == 2){
                                        ClearTerminal.clear();
            
                                        int resposta3 = SalvarArquivo.salvamento();
            
                                        if(resposta3==0){
                                            throw new IllegalArgumentException("Tentativas maximas para salvar arquivo alcancadas");
                                        }
            
                                        if(resposta3==1){
                                            System.out.print("Nome do arquivo em que o banco de dados de usuarios sera salvo: ");
                                            String nomeArquivo = respostas.nextLine();
                                            bl.salvaArquivo("usuario", nomeArquivo);
                                            ClearTerminal.clear();
                                            System.out.println("Acervo de usuarios salvo com sucesso em " + nomeArquivo+"\n");
                                        }
                                        if(resposta3==2){
                                            System.out.print("Nome do arquivo em que o banco de dados de livros sera salvo: ");
                                            String nomeArquivo = respostas.nextLine();
                                            bl.salvaArquivo("livros", nomeArquivo);
                                            ClearTerminal.clear();
                                            System.out.println("Acervo de livros salvo com sucesso em " + nomeArquivo+"\n");
                                        }
            
                                        if(resposta3==3){
                                            System.out.print("Nome do arquivo em que o banco de dados de usuarios sera salvo: ");
                                            String nomeArquivo1 = respostas.nextLine();
                                            bl.salvaArquivo("usuario", nomeArquivo1);
            
                                            System.out.print("Nome do arquivo em que o banco de dados de livros sera salvo: ");
                                            String nomeArquivo2 = respostas.nextLine();
                                            bl.salvaArquivo("livros", nomeArquivo2);
            
                                            ClearTerminal.clear();
                                            System.out.println("Acervo de livros salo com sucesso em " + nomeArquivo1 + " e de usuarios salvo em "+nomeArquivo2+"\n");
                                        }
            
                                    }
            
                                    if(resposta2 == 3){
                                        ClearTerminal.clear();
            
                                        int auxOpcoes = MenuEmprestimo.opcoes();
                                        if(auxOpcoes==0){
                                            throw new IllegalArgumentException("Tentativas maximas no menu de emprestimo alcancadas");
                                        }
            
                                        if(auxOpcoes==1){
                                            System.out.println(bl.imprimeLivros());
                                        }
            
                                        if(auxOpcoes==2){
                                            int contadorRespEmrprestimo=0;
                                            
                                            while(contadorRespEmrprestimo<4){
                                                try{
                                                    contadorRespEmrprestimo++;
                                                    System.out.print("Insira o codigo do livro que deseja emprestar: ");
            
                                                    int auxCodLivro = respostas.nextInt();
                                                    respostas.nextLine();
                                                    Livro livro = bl.getLivro(auxCodLivro);
                    
                                                    System.out.print("Insira o CPF do usuario que deseja emprestar tal livro: ");
                    
                                                    String auxCodUsr = respostas.nextLine();
                                                    long auxLong = ValidaCPF.toLong(auxCodUsr);
                                                    auxCodUsr = String.valueOf(auxLong);

                                                    Usuario usr = bl.getUsuario(auxCodUsr);

                                                    ClearTerminal.clear();
                                                    try{
                                                        bl.emprestaLivro(usr, livro);
                                                    }catch(IllegalArgumentException iae){
                                                        System.out.println(iae.getMessage());
                                                        break;
                                                    }

                                                    System.out.println("\nEmprestimo do livro "+ auxCodLivro+ " realizado com sucesso!\n");
                                                    System.out.println(" [" + usr.getNumCPF() + "="+usr.toString());
                                                    System.out.println(" [" + livro.getCodigoLivro()+"="+livro.toString());
                                                    break;
            
                                                }catch(LivroNaoCadastradoEX lnc){
            
                                                    if(contadorRespEmrprestimo==4){
                                                        throw new LivroNaoCadastradoEX("Nao ha nenhum livro com este codigo cadastrado");
                                                        }
            
                                                    System.out.println("Livro invalido");
                                                    System.out.println("Tente novamente: (" + (4-contadorRespEmrprestimo) + " tentativas)");
                                                    
                                                }catch(UsuarioNaoCadastradoEX unc){
            
                                                    if(contadorRespEmrprestimo==4){
                                                        throw new UsuarioNaoCadastradoEX("Nao ha nenhum usuario com esse CPF cadastrado");
                                                        }
            
                                                    System.out.println("Usuario invalido");
                                                    System.out.println("Tente novamente: (" + (4-contadorRespEmrprestimo) + " tentativas)");
            
                                                }catch(InputMismatchException ime){
                                                    respostas.nextLine();
            
                                                    if(contadorRespEmrprestimo==4){
                                                        throw new IllegalArgumentException("Tentativas maximas alcancadas de emprestar um livro a um usuario");
                                                        }
            
                                                    System.out.println("Valor invalido");
                                                    System.out.println("Tente novamente: (" + (4-contadorRespEmrprestimo) + " tentativas)");
            
                                                }catch(CopiaNaoDisponivelEX cnd){
                                                    if(contadorRespEmrprestimo==4){
                                                        throw new IllegalArgumentException("Tentativas maximas alcancadas de emprestar um livro a um usuario");
                                                    }
            
                                                    System.out.println("Nenhuma copia desse livro disponivel");
                                                    System.out.println("Tente novamente, com outro livro: (" + (4-contadorRespEmrprestimo) + " tentativas)");
                                                }
                                            }
                                        }
            
                                        if(auxOpcoes==3){
                                            int contadorRespEmrprestimo=0;
                                            
                                            while(contadorRespEmrprestimo<4){
                                                try{
                                                    contadorRespEmrprestimo++;
                                                    System.out.print("Insira o codigo do livro que deseja devolver: ");
            
                                                    int auxCodLivro = respostas.nextInt();
                                                    respostas.nextLine();
                                                    Livro livro = bl.getLivro(auxCodLivro);
                    
                                                    System.out.print("Insira o CPF do usuario que deseja devolver tal livro: ");
                                                    
                                                    String auxCodUsr = respostas.nextLine();
                                                    long auxLong = ValidaCPF.toLong(auxCodUsr);
                                                    auxCodUsr = String.valueOf(auxLong);
                                                    Usuario usr = bl.getUsuario(auxCodUsr);
                                                    
                                                    ClearTerminal.clear();
                                                    bl.devolveLivro(usr, livro);
                                                    System.out.println("\nDevolucao do livro " + auxCodLivro+ " realizada com sucesso!\n");
                                                    System.out.println(" [" + usr.getNumCPF() + "="+usr.toString());
                                                    System.out.println(" [" + livro.getCodigoLivro()+"="+livro.toString());
                                                    break;
            
                                                }catch(LivroNaoCadastradoEX lnc){
            
                                                    if(contadorRespEmrprestimo==4){
                                                        throw new LivroNaoCadastradoEX();
                                                        }
            
                                                    System.out.println("Livro invalido");
                                                    System.out.println("Tente novamente: (" + (4-contadorRespEmrprestimo) + " tentativas)");
                                                    
                                                }catch(UsuarioNaoCadastradoEX unc){
            
                                                    if(contadorRespEmrprestimo==4){
                                                        throw new UsuarioNaoCadastradoEX();
                                                        }
            
                                                    System.out.println("Usuario invalido");
                                                    System.out.println("Tente novamente: (" + (4-contadorRespEmrprestimo) + " tentativas)");
            
                                                }catch(InputMismatchException ime){
                                                    respostas.nextLine();
            
                                                    if(contadorRespEmrprestimo==4){
                                                        throw new IllegalArgumentException("Tentativas maximas alcancadas de devolver um livro a um usuario");
                                                        }
            
                                                    System.out.println("Valor invalido");
                                                    System.out.println("Tente novamente: (" + (4-contadorRespEmrprestimo) + " tentativas)");
            
                                                }catch(NenhumaCopiaEmprestadaEX cnd){
                                                    if(contadorRespEmrprestimo==4){
                                                        throw new IllegalArgumentException("Tentativas maximas alcancadas de devolver um livro a um usuario");
                                                    }
            
                                                    System.out.println("Nenhuma copia desse livro emprestada");
                                                    System.out.println("Tente novamente, com outro livro: (" + (4-contadorRespEmrprestimo) + " tentativas)");
                                                }
                                            }
                                        }
                                    }
            
                                    if(resposta2 == 4){
                                        ClearTerminal.clear();
            
                                        int respRelatorio = Relatorio.opcao();
                                        if(respRelatorio ==0){
                                            throw new IllegalArgumentException("Tentativas maximas alcancadas de verificar o relatorio da biblioteca");
                                        }
            
                                        if(respRelatorio==1){
                                            System.out.println(bl.imprimeLivros());
                                        }
            
                                        if(respRelatorio==2){
                                            System.out.println(bl.imprimeUsuarios());
                                        }
            
                                        if(respRelatorio==3){
                                            int countadorRelatorioUsr=0;
            
                                            while(countadorRelatorioUsr<4){
                                                try{
                                                    countadorRelatorioUsr++;
                                                    System.out.print("Insira o CPF do usuario que deseja verificar: ");
            
                                                    String auxCodUsr = respostas.nextLine();
                                                    Usuario usr = bl.getUsuario(auxCodUsr);
                                                    System.out.println(" [" + usr.getNumCPF() + "=" + usr.toString());
                                                }catch(UsuarioNaoCadastradoEX unc){
            
                                                    if(countadorRelatorioUsr==4){
                                                        throw new UsuarioNaoCadastradoEX("Tentativas maximas de verificar o usuario alcancadas");
                                                        }
            
                                                    System.out.println("Usuario invalido");
                                                    System.out.println("Tente novamente: (" + (4-countadorRelatorioUsr) + " tentativas)");
            
                                                }
                                            }
                                        }
            
                                        if(respRelatorio==4){
                                            int countadorRelatorio=0;
            
                                            while(countadorRelatorio<4){
                                                try{
                                                    countadorRelatorio++;
                                                    System.out.print("Insira o codigo do livro que deseja verificar: ");
            
                                                    int auxCodLivro = respostas.nextInt();
                                                    respostas.nextLine();
                                                    Livro livro = bl.getLivro(auxCodLivro);
                                                    System.out.println(" [" + livro.getCodigoLivro() + "=" + livro.toString());
                                                }catch(LivroNaoCadastradoEX unc){
            
                                                    if(countadorRelatorio==4){
                                                        throw new LivroNaoCadastradoEX("Tentativas maximas de verificar o livro alcancadas");
                                                        }
            
                                                    System.out.println("Livro invalido");
                                                    System.out.println("Tente novamente: (" + (4-countadorRelatorio) + " tentativas)");
            
                                                }
                                            }
                                        }
            
                                    }if(resposta2 == 5){
                                        ClearTerminal.clear();
            
                                        int auxPoliticaBiblioteca = PoliticaBiblioteca.opcao();
            
                                        if(auxPoliticaBiblioteca==-1){
                                            throw new IllegalArgumentException("Tentativas maximas de definir uma politica atingido");
                                        }
            
                                        if(auxPoliticaBiblioteca==1){
                                            int auxRespMulta = RespostaMulta.resposta();
            
                                            if(auxRespMulta==-1){
                                                throw new IllegalArgumentException("Tentativas de definir um tempo maximo com o livro toleravel esgotadas");
                                            }else{
                                                ClearTerminal.clear();
            
                                                bl.setMaximoDiasComLivro(auxRespMulta);
                                                System.out.println("Numero maximo de dias que o usuario pode permanceer com o livro definido em: "+auxRespMulta);
                                            }
                                        }
            
                                        if(auxPoliticaBiblioteca==2){
                                            float auxValorMulta = ValorMulta.valor();
                                            if(auxValorMulta==-1){
                                                throw new IllegalArgumentException("Tentativas de definir uma multa esgotadas");
                                            }else{
                                                ClearTerminal.clear();
            
                                                bl.setValorMulta(auxValorMulta);
                                                System.out.println("Valor da multa definido em: R$"+auxValorMulta);
                                            }
                                        }
            
                                        if(auxPoliticaBiblioteca==3){
                                            int auxMaxNumCop = MaximoNumCop.valorMax();
                                            if(auxMaxNumCop==0){
                                                throw new IllegalArgumentException("Tentativas maximas de definir um numero de copias maximo foi alcancado");
                                            }else{
                                                ClearTerminal.clear();
                                                System.out.println("Numero maximo de livros que o usuairo pode ter simultanemante foi definido para "+auxMaxNumCop);
                                                bl.setMaximoNumCop(auxMaxNumCop);
                                            }
                                        }
                                        
                                        if(auxPoliticaBiblioteca==4){
                                            System.out.println("Deseja restringir o usuario que possuir um atraso?");
                                            String auxresp = RespostaSalvarUsr.opcao();
                                            if(auxresp.equals("ERRO")){
                                                throw new IllegalArgumentException("Tentativas maximas para definir se haveria restricao alcancadas");
                
                                            }else if(auxresp.equals("SIM")){
                                                bl.setRestringirAraso(true);
                                                ClearTerminal.clear();
                                                System.out.println("Restricao ao usuario definida como verdadeira\n");
                                            }else{
                                                ClearTerminal.clear();
                                            }
                                        }
                                    }
            
                                resposta2 = Cadastro.cadastro();
            
                                //fim while
                                }
                                    
                            }catch(IllegalArgumentException iae){
                                throw new IllegalArgumentException("Erro na gestao da manutencao devido a: " + iae.getMessage());
                            }catch(LivroNaoCadastradoEX lnc){
                                System.out.println("Erro na gestao da manutencao devido a: " + lnc.getMessage());
                            }catch(UsuarioNaoCadastradoEX unc){
                                System.out.println("Erro na gestao da manutencao devido a: " + unc.getMessage());
                            }

                        }catch(FileNotFoundException cnf){
                            if(count == 4){
                                throw new IllegalArgumentException("Tentativas maximas de carregamento de arquivo alcancadas(Programa encerrado)");
                                }

                            System.out.println("Arquivos nao encontrados");
                            System.out.println("Tente novamente: (" + (4-count) + " tentativas)");
                            auxResposta = true;
                        }
                    }
            }
        }catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }catch(InvalidClassException ice){
            System.out.println(ice +"versoes de programas diferentes");
        }*/
    }
}
