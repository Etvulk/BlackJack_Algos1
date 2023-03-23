import java.util.Scanner;

enum Mazo{
    DIAMANTE_AS, TREBOL_AS, CORAZON_AS, PICAS_AS,
    DIAMANTE_2, TREBOL_2, CORAZON_2, PICAS_2,
    DIAMANTE_3, TREBOL_3, CORAZON_3, PICAS_3,
    DIAMANTE_4, TREBOL_4, CORAZON_4, PICAS_4,
    DIAMANTE_5, TREBOL_5, CORAZON_5, PICAS_5,
    DIAMANTE_6, TREBOL_6, CORAZON_6, PICAS_6,
    DIAMANTE_7, TREBOL_7, CORAZON_7, PICAS_7,
    DIAMANTE_8, TREBOL_8, CORAZON_8, PICAS_8,
    DIAMANTE_9, TREBOL_9, CORAZON_9, PICAS_9,
    DIAMANTE_10, TREBOL_10, CORAZON_10, PICAS_10,
    DIAMANTE_J, TREBOL_J, CORAZON_J, PICAS_J,
    DIAMANTE_Q, TREBOL_Q, CORAZON_Q, PICAS_Q,
    DIAMANTE_K, TREBOL_K, CORAZON_K, PICAS_K,
    DIAMANTE_JOKER, TREBOL_JOKER, CORAZON_JOKER, PICAS_JOKER;
}
public class Blackjack{
    public static void main(String[] args){

    }
    public static Mazo[] repartirCartasIniciales(){
        perdirApuesta(0, 0);
        
    }

    //Método para determinar si la apuesta es valida.
    public static int perdirApuesta(int apuesta, int creditos){ 
        int i = 0;
        while (apuesta < 10 && apuesta > creditos && i < 10){
            System.out.println("Apuesta invalida, por favor ingresé una apuesta mayor o igual a 10 créditos.");
            i++;
        }
        if (i >= 10){
            apuesta = 10;
        }
        return apuesta;
    }
}