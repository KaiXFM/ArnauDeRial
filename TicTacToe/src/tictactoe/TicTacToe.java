package tictactoe;

import java.util.Random;
import java.util.Scanner;

/**
 * Aquesta aplicació implementa el joc Tic-Tac-Toe (tres en ratlla) en mode consola.
 * El joc es juga en un tauler de 3x3, on dos jugadors, el jugador i el contrincant (màquina),
 * alternativament col·loquen les seves fitxes en caselles buides. L'objectiu és tenir tres fitxes en línia
 * en qualsevol direcció (horitzontal, vertical o diagonal) per guanyar el joc.
 *
 * El joc mostra el tauler a la consola i permet que el jugador realitzi un moviment
 * introduint les coordenades de la casella on desitja col·locar la seva fitxa. El contrincant (màquina)
 * realitza el seu moviment de forma aleatòria, escollint una casella buida del tauler.
 *
 * El tauler es representa com una matriu de 3x3 on cada casella pot tenir un dels següents valors:
 * - "-3" si la casella és buida
 * - "0" si la casella té la fitxa del contrincant
 * - "1" si la casella té la fitxa del jugador
 *
 * El joc continua fins que un jugador guanya o el tauler està completament ple. Un jugador guanya
 * quan té tres fitxes en línia i el contrincant guanya quan la suma dels valors d'una fila, columna o diagonal
 * és igual a 0.
 *
 * Aquesta classe conté els mètodes necessaris per a inicialitzar el joc, mostrar el tauler, realitzar
 * els moviments del jugador i del contrincant, i determinar el guanyador del joc.
 */
public class TicTacToe {
    
    /**
     * Mètode principal que s'executa en iniciar l'aplicació.
     * @param args els arguments de la línia de comandes (no s'utilitzen en aquesta aplicació)
     */
    public static void main(String[] args) {
        // Inicialització del tauler
        int[][] tauler = new int[3][3];
        imprimirTauler(tauler);
        iniciJoc(tauler);
        System.out.println("");
        System.out.println("");
        imprimirTauler(tauler);
        
        // Joc principal
        while (true) {
            tirJugador(tauler);
            imprimirTauler(tauler);
            tirContrincant(tauler);
            imprimirTauler(tauler);
        }
    }
    
    /**
     * Inicialitza el tauler de joc marcant totes les caselles com a buides.
     * @param taulerJoc la matriu que representa el tauler de joc
     */
    public static void iniciJoc(int[][] taulerJoc) {
        for (int i = 0; i < taulerJoc.length; i++) {
            for (int j = 0; j < taulerJoc.length; j++) {
                taulerJoc[i][j] = -3;
            }
        }
    }
    
    /**
     * Mostra el tauler de joc actual a la consola.
     * @param taulerJoc la matriu que representa el tauler de joc
     */
    public static void imprimirTauler(int[][] taulerJoc) {
        System.out.println("  1 2 3 ");
        for (int i = 0; i < taulerJoc.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < taulerJoc.length; j++) {
                System.out.print(crossOrCircle(taulerJoc[i][j]) + " ");
            }
            System.out.print("| " + (i + 1));
            System.out.println("");
        }
    }
    
    /**
     * Converteix el valor d'una casella en el símbol de la fitxa corresponent.
     * @param i el valor de la casella
     * @return el símbol de la fitxa ('_', 'O' o 'X')
     */
    public static char crossOrCircle(int i) {
        if (i == -3) {
            return '_';
        }
        return (i == 0) ? 'O' : 'X';
    }
    
    /**
     * Converteix les coordenades (x, y) en una posició unidimensional de la matriu.
     * @param x la coordenada x de la casella
     * @param y la coordenada y de la casella
     * @return la posició unidimensional de la casella
     */
    private static int bidimensionalToUnidimensional(int x, int y) {
        return (y - 1) * 3 + x;
    }
    
    /**
     * Realitza el moviment del contrincant (màquina) en una casella buida del tauler de joc.
     * El moviment es realitza de forma aleatòria.
     * @param taulerJoc la matriu que representa el tauler de joc
     */
    public static void tirContrincant(int[][] taulerJoc) {
        System.out.println("");
        System.out.println("TIR CONTRINCANT");

        int random_x;
        int random_y;

        Random rand = new Random();

        do {
            random_x = rand.nextInt(3);
            random_y = rand.nextInt(3);
        } while (taulerJoc[random_x][random_y] != -3);

        taulerJoc[random_x][random_y] = 0; // 0 = 'O', és a dir, la màquina
    }
    
    /**
     * Permet que el jugador realitzi un moviment introduint les coordenades de la casella
     * on vol col·locar la seva fitxa.
     * @param taulerJoc la matriu que representa el tauler de joc
     */
    public static void tirJugador(int[][] taulerJoc) {
        System.out.println("");
        System.out.println("TIR JUGADOR");

        Scanner sc = new Scanner(System.in);
        System.out.print("[X] Entra la columna (1-3): ");
        int x = sc.nextInt();
        System.out.print("[Y] Entra la fila (1-3): ");
        int y = sc.nextInt();

        taulerJoc[y - 1][x - 1] = 1; // 1 = 'X', és a dir, el jugador 
    }
    
    /**
     * Determina el guanyador del joc revisant totes les files, columnes i diagonals del tauler de joc.
     * @param taulerJoc la matriu que representa el tauler de joc
     * @return "-1" si no guanya ningú, "0" si guanya el contrincant i "1" si guanya el jugador
     */
    public static int determinarGuanyador(int[][] taulerJoc) {
        // TODO
        throw new UnsupportedOperationException();
    }
}