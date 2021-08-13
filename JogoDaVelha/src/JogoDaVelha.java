import java.util.Scanner;
import java.lang.String;

public class JogoDaVelha {
    
    public static int linhajogada, colunajogada;
    public static String player1, player2, simb, winner, resposta, conf = "";
    public static Scanner dados = new Scanner(System.in);
    public static String[][] jv = { { "_", "_", "_" }, 
                                    { "_", "_", "_" }, 
                                    { "_", "_", "_" }, };;
    public static void main(String[] args) {
        linhajogada = 0;
        colunajogada = 0;
        
        System.out.println("Jogo da velha!!!");              
        System.out.println("___|____|___");
        System.out.println("___|____|___");
        System.out.println("   |    |   ");
        
        System.out.println("Tabela com a numeração:");
        System.out.println("_00_|_01_|_02_");
        System.out.println("_10_|_11_|_12_");
        System.out.println(" 20 | 21 | 22");
        
        System.out.print("Jogador 1 digite seu nome: ");        
        player1 = dados.nextLine();        
        System.out.print("Jogador 2 digite seu nome: ");
        player2 = dados.nextLine();                           
        System.out.printf("%s irá iniciar\n", player1); 
              
        //Mostrar tabela
        mostrarJogo(jv);                   
        jogadas(5);                
        if(verificaTabela(jv).equals("nada")){
            while(verificaTabela(jv).equals("nada")){                
                jogadas(1);  
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){                        
                        conf += jv[i][j];
                    }
                }
                if(!conf.contains("_")){
                    System.out.println("Empate!");
                        System.exit(0); 
                }
                else 
                    conf = "";                        
            }
            System.out.printf("Parabéns você ganhou %s!!!\n", verificaTabela(jv));
        }    
        else
            System.out.printf("Parabéns você ganhou %s!!!\n", verificaTabela(jv));
    }                
    
    //Realizar as jogadas
    public static void jogadas(int jogadas){        
        for(int i = 0; i < jogadas; i++){                     
            if(jogadas == 5){
               if(i % 2 == 0){                                               
                jogadasP1();
                }
                else{
                jogadasP2();
                }
            }
            else{               
                jogadasP2(); 
                mostrarJogo(jv);
                if(verificaTabela(jv).equals("nada"))
                jogadasP1();
            }
        mostrarJogo(jv);
        }
    }
    
    //Verificar se há algum vencedeor
    public static String verificaTabela(String[][] jv){        
        winner = "";
        String verif;
        //Diagonal principal
        verif = jv[0][0] + jv[1][1] + jv[2][2];
        if(verif.equals("XXX")){
            winner = player1;
            return winner; 
        }
        else if(verif.equals("OOO")){
            winner = player2;  
            return winner;         
        }
        else{
        //Diagonal secundaria
            verif = "";
            verif = jv[0][2] + jv[1][1] + jv[2][0];
            if(verif.equals("XXX")){
                winner = player1; 
                return winner;                                                                        
            }
            else if(verif.equals("OOO")){
                winner = player2;
                return winner; 
            }        
        //Verificação linhas
            else{                
                for(int i = 0; i < 3; i++){
                    verif = "";
                    for(int j = 0; j < 3; j++){
                        verif += jv[i][j];
                    }
                    if(verif.equals("XXX")) {
                        winner = player1; 
                        return winner;                                                
                    }
                    else if(verif.equals("OOO")) {
                        winner = player2;
                        return winner;                                                
                    }                                        
                }    
                for(int j = 0; j < 3; j++){
                    verif = "";
                    for(int i = 0; i < 3; i++) {
                        verif += jv[i][j];
                        }
                    if(verif.equals("XXX")) {
                        winner = player1;
                        return winner; 
                    }
                    else if(verif.equals("OOO")){
                        winner = player2;                        
                        return winner; 
                    }                    
                }    
            }            
        }
        if((!winner.equals(player1)) || !winner.equals(player2))
            winner = "nada";
        return winner;
    }
            
    //Mostrar tabela do jogo e as posições   
    public static void mostrarJogo(String[][] j){
    System.out.println("Tabela do jogo da velha e suas respectivas posições: ");           
        for(int linha = 0; linha < 3; linha++){
            for(int coluna = 0; coluna < 3; coluna++){                    
                System.out.printf("%s ",j[linha] [coluna]);                    
            }
            System.out.print("     ");            
                for(int b = 0; b < 3; b++){
                    System.out.printf("%d%d ", linha, b);
                }                                                        
        System.out.println();
        }    
    }                 
    
    //Jogadas do player1
    public static void jogadasP1() {
        System.out.printf("Em qual posição deseja colocar o X %s?\n", player1);
        System.out.print("Sua jogada:");
        resposta = dados.nextLine();                        
        linhajogada = Character.getNumericValue(resposta.charAt(0));            
        colunajogada = Character.getNumericValue(resposta.charAt(1));            

        while(!"_".equals(jv[linhajogada] [colunajogada])){
            System.out.println("Posição ocupada, escolha outra.");
            mostrarJogo(jv);

            System.out.print("Sua outra escolha:");
            resposta = dados.nextLine();            
            linhajogada = Character.getNumericValue(resposta.charAt(0));            
            colunajogada = Character.getNumericValue(resposta.charAt(1));
        }
        jv[linhajogada] [colunajogada] = "X";
        
    }
    
    //Jogadas do player2
    public static void jogadasP2() {
        System.out.printf("Em qual posição deseja colocar o O %s?\n", player2);
        System.out.print("Sua escolha: ");
        resposta = dados.nextLine();            
        linhajogada = Character.getNumericValue(resposta.charAt(0));            
        colunajogada = Character.getNumericValue(resposta.charAt(1));

        while(!"_".equals(jv[linhajogada] [colunajogada])){
            System.out.println("Posição ocupada, escolha outra.");
            mostrarJogo(jv);

            System.out.print("Sua outra escolha: ");
            resposta = dados.nextLine();            
            linhajogada = Character.getNumericValue(resposta.charAt(0));            
            colunajogada = Character.getNumericValue(resposta.charAt(1));

        }
        jv[linhajogada] [colunajogada] = "O";
    }                   
}
