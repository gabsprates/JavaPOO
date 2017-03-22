package jogodaforca;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

/**
 * Jogo da Forca
 * @author gabriel
 */
public class JogoDaForca {

    private char letra;
    private String mascara;
    private String palavraChave;
    private String letrasErradas;
    private String letrasCorretas;
    private final int limiteVidas = 7;
    private final Random rand = new Random();
    private final Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        JogoDaForca game = new JogoDaForca();
        
        game.palavraChave = game.sortearPalavra();
        game.letrasErradas = "";
        game.letrasCorretas = "";
        game.mascara = game.criaMascara();
        
        do {
    
            // Exibe texto
            System.out.println("---- Jogo da Forca da Computação ----");
            System.out.println("palavra com " 
                    + game.palavraChave.length()
                    + " letras: "
                    + game.mascara);
            System.out.println("digite uma letra: ");
            
            game.letra = game.input.next().toLowerCase().charAt(0);
            
            if (game.palavraChave.indexOf(game.letra) >= 0) {

                game.letrasCorretas = game.letrasCorretas + game.letra;
                game.mascara = game.criaMascara();

            } else {

                if (game.letrasErradas.indexOf(game.letra) < 0) {
                    game.letrasErradas = game.letrasErradas + game.letra;
                }

            }

            if (game.letrasErradas.length() >= game.limiteVidas) {
                break;
            }
            
        } while (!game.mascara.equals(game.palavraChave));
        
        if (game.letrasErradas.length() >= game.limiteVidas) {
            System.out.println("Você morreu! muahahaha >:D");
        } else {
            System.out.println("Parabéns!!! Você acertou a palavra "
                    + game.palavraChave.toUpperCase());
        }
        
    }

    
    /**
     * Sorteia palavra
     * @return String
     */
    private String sortearPalavra() {

        int indice;
        indice = this.rand.nextInt(Palavras.palavras.length);
        
        return Palavras.palavras[indice];
        
    }

    
    /**
     * Cria máscara de acordo o tamanho da palavra chave
     * @return String
     */
    private String criaMascara() {

        String stringMascara = this.palavraChave;
        String string = (this.letrasCorretas.isEmpty() ? " " : this.letrasCorretas);
        String regex = String.format("[^%s]", string);
        
        stringMascara = stringMascara.replaceAll(regex, "-");
        
        return stringMascara;
        
    }

}
