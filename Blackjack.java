import java.util.Scanner;

import java.awt.Font;

enum Carta{
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

        Carta[] mazo = {
            Carta.DIAMANTE_AS, Carta.TREBOL_AS, Carta.CORAZON_AS, Carta.PICAS_AS,
            Carta.DIAMANTE_2, Carta.TREBOL_2, Carta.CORAZON_2, Carta.PICAS_2,
            Carta.DIAMANTE_3, Carta.TREBOL_3, Carta.CORAZON_3, Carta.PICAS_3,
            Carta.DIAMANTE_4, Carta.TREBOL_4, Carta.CORAZON_4, Carta.PICAS_4,
            Carta.DIAMANTE_5, Carta.TREBOL_5, Carta.CORAZON_5, Carta.PICAS_5,
            Carta.DIAMANTE_6, Carta.TREBOL_6, Carta.CORAZON_6, Carta.PICAS_6,
            Carta.DIAMANTE_7, Carta.TREBOL_7, Carta.CORAZON_7, Carta.PICAS_7,
            Carta.DIAMANTE_8, Carta.TREBOL_8, Carta.CORAZON_8, Carta.PICAS_8,
            Carta.DIAMANTE_9, Carta.TREBOL_9, Carta.CORAZON_9, Carta.PICAS_9,
            Carta.DIAMANTE_10, Carta.TREBOL_10, Carta.CORAZON_10, Carta.PICAS_10,
            Carta.DIAMANTE_J, Carta.TREBOL_J, Carta.CORAZON_J, Carta.PICAS_J,
            Carta.DIAMANTE_Q, Carta.TREBOL_Q, Carta.CORAZON_Q, Carta.PICAS_Q,
            Carta.DIAMANTE_K, Carta.TREBOL_K, Carta.CORAZON_K, Carta.PICAS_K,
            Carta.DIAMANTE_JOKER, Carta.TREBOL_JOKER, Carta.CORAZON_JOKER, Carta.PICAS_JOKER
            };
        
        int[] numeroCartas;
        numeroCartas = new int[]{
            1, 1, 1, 1, 2, 2 ,2 ,2, 3, 3, 3, 3, 4, 4, 4, 4,
            5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8,
            9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
            10, 10, 10, 10, 11, 11, 11, 11
        };

        int creditos = 100;
        int apuestaMinima = 10;
        int juegos = 0;
        int juegosMaximos = 10;
        boolean continuarJuego = true;

        System.out.println("Bienvenido a Blackjack!");
        System.out.println("Por favor ingrese su nombre: ");
        Scanner leer = new Scanner (System.in);
        String jugador = leer.nextLine();
        System.out.println("Hola " + jugador + ".");

        while (juegos < juegosMaximos && creditos >= apuestaMinima && continuarJuego){
            System.out.println("Tienes " + creditos + " créditos.");
            int apuesta = perdirApuesta(creditos);
            creditos = creditos - apuesta;

            Carta[] manoJugador = new Carta[21];
            int manoValorJugador = 0;
            Carta[] manoCrupier = new Carta[21];
            int manoValorCrupier = 0;

            System.out.println("Usted aposto: " + apuesta + " y ahora posee una cantida de " + creditos + " créditos.");

            // Repartir cartas y obtener el válor de las cartas del jugador.
            manoJugador = repartirCartasIniciales(mazo);
            manoValorJugador = valorCartas(manoJugador, numeroCartas, 2);
            // Mostrar cartas del jugador y su valor.
            System.out.println(jugador + ", estas son tus cartas y el valor de ellas: ");
            System.out.println(manoJugador[0] + " y " + manoJugador[1]);
            System.out.println("Valor: " + manoValorJugador);
            // Repartir cartas y obtneer el válor de las cartasd del crupier.
            manoCrupier = repartirCartasIniciales(mazo);
            manoValorCrupier = valorCartas(manoCrupier, numeroCartas, 1);
            // Mostrar la primera carta del crupier y su valor.
            System.out.println("La primera carta del crupier es: ");
            System.out.println(manoCrupier[0]);
            System.out.println("Y su valor es: " + manoValorCrupier);

            MaquinaDeTrazados mt = new MaquinaDeTrazados(1400, 700, "JUEGO", Colores.DARK_GRAY);
            dibujarCartasJugador(mt, manoJugador, 2);
            dibujarCartasCrupier(mt, manoCrupier, 2);
            mt.mostrar();
            
            leer.nextLine();
            continuarJuego = false;
        }
        leer.close();
        
    }
    // Método para repartir cartas iniciales.
    public static Carta[] repartirCartasIniciales(Carta[] mazo){
        Carta[] mano = new Carta[21];
        int cartasIniciales = 2;
        int i = 0;         
        int cartasMazo = mazo.length;
        while ( i < cartasIniciales ){
            int carta = (int) (Math.random() * cartasMazo);
            mano[i] = mazo[carta];
            i++;
        }
        return mano;
    }

    // Método para determinar si la apuesta es valida.
    public static int perdirApuesta(int creditos){ 
        int i = 0;
        Scanner leer = new Scanner(System.in);
        System.out.println("Introduza la cantidad de créditos que desea apostar(la cantidad mínima de créditos que se pueden apostar es 10):");
        int apuesta = leer.nextInt();
        // Loop para asegurar que la apuesta es válida.
        while ((apuesta < 10 && i < 10) || apuesta > creditos){
            System.out.println("Apuesta inválida, por favor ingresé una apuesta mayor o igual a 10 créditos:");
            apuesta = leer.nextInt();
            i++;
        }
        // Si la cantidad de intentos es mas de 10, entonces se le asignara una apuesta de 10 créditos al jugador.
        if (i >= 10){
            apuesta = 10;
            System.out.println("Cantidad de intentos excedida, su apuesta fue asignada a 10 créditos.");
        }
        // Cerrar escaner.
        leer.close(); 
        return apuesta;

    }
    // Método para calculagr el valor de la mano.
    //@ requires mano != null;
	//@ requires numeroCartas.length > 0;
	//@ ensures \result >= 0 || \result < 0;
    public static int valorCartas(Carta[] mano, int[] numeroCartas, int cantidaDeCartas){
        int valor = 0;
        int i = 0;
    
        //@ maintaining 0 <= i <= cantidaDeCartas;
    	//@ decreases cantidaDeCartas - i;
        while (i < cantidaDeCartas){
            valor = valor + numeroCartas[mano[i].ordinal()];
            i++;
        }
        return valor;
    }
    // Método para dibujar las cartas del jugador.
    public static void dibujarCartasJugador(MaquinaDeTrazados mt, Carta[] mano, int cantidaDeCartas){
        String[] simbolo;
        simbolo = new String[]{
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "JOKER", "JOKER", "JOKER", "JOKER"
            };

        String[] caracterEsquina;
        caracterEsquina = new String[]{
            "A", "A", "A", "A",
            "2", "2", "2", "2",
            "3", "3", "3", "3",
            "4", "4", "4", "4",
            "5", "5", "5", "5",
            "6", "6", "6", "6",
            "7", "7", "7", "7",
            "8", "8", "8", "8",
            "9", "9", "9", "9",
            "10", "10", "10", "10",
            "10", "10", "10", "10",
            "10", "10", "10", "10",
            "10", "10", "10", "10",
            "JOKER", "JOKER", "JOKER", "JOKER"
        };
        mt.configurarFuente("Monospaced", Font.PLAIN, 24);
        int x = mt.XMAX;
        int y = mt.YMAX;
        int centroX = x/2 - x/6 - x/36;
        int centroY = y/2 + y/8;
        int i = 0;
        int separador = 0;
        while (i < cantidaDeCartas){
            mt.dibujarRectanguloLleno(x/2 - x/6 - x/36 + separador, y/2 + y/8, 150, 200, Colores.WHITE);
            mt.dibujarRectangulo(x/2 - x/6 - x/36 + separador, y/2 + y/8, 150, 200, Colores.RED);
            if (simbolo[mano[i].ordinal()] == "DIAMANTE"){
                dibujarDiamante(mt, i, separador, caracterEsquina, mano, centroX, centroY);
            }

            else if (simbolo[mano[i].ordinal()] == "CORAZON"){
                dibujarCorazon(mt, i, separador, caracterEsquina, mano, centroX, centroY);
            }
            
            else if (simbolo[mano[i].ordinal()] == "TREBOL"){
                dibujarTrebol(mt, i, separador, caracterEsquina, mano, centroX, centroY);
            }

            else if (simbolo[mano[i].ordinal()] == "PICAS"){
                dibujarPicas(mt, i, separador, caracterEsquina, mano, centroX, centroY);
            }

            else{
                dibujarJoker(mt, i, separador, caracterEsquina, mano, centroX, centroY);
            }
            separador = separador + 200;
            i++;
        }
    }
    // Método para dibujar las cartas del crupier.
    public static void dibujarCartasCrupier(MaquinaDeTrazados mt, Carta[] mano, int cantidaDeCartas){
        String[] simbolo;
        simbolo = new String[]{
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "DIAMANTE", "TREBOL", "CORAZON", "PICAS",
            "JOKER", "JOKER", "JOKER", "JOKER"
            };

        String[] caracterEsquina;
        caracterEsquina = new String[]{
            "A", "A", "A", "A",
            "2", "2", "2", "2",
            "3", "3", "3", "3",
            "4", "4", "4", "4",
            "5", "5", "5", "5",
            "6", "6", "6", "6",
            "7", "7", "7", "7",
            "8", "8", "8", "8",
            "9", "9", "9", "9",
            "10", "10", "10", "10",
            "10", "10", "10", "10",
            "10", "10", "10", "10",
            "10", "10", "10", "10",
            "JOKER", "JOKER", "JOKER", "JOKER"
        };
        mt.configurarFuente("Monospaced", Font.PLAIN, 24);
        int x = mt.XMAX;
        int y = mt.YMAX;
        int centroX = x/2 - x/6 - x/36;
        int centroY = y/17;
        int i = 0;
        int separador = 0;
        while (i < 1){
            mt.dibujarRectanguloLleno(centroX + separador, centroY, 150, 200, Colores.WHITE);
            mt.dibujarRectangulo(centroX + separador, centroY, 150, 200, Colores.RED);
            if (simbolo[mano[i].ordinal()] == "DIAMANTE"){
                dibujarDiamante(mt, i, separador, caracterEsquina, mano, centroX, centroY);
            }

            else if (simbolo[mano[i].ordinal()] == "CORAZON"){
                dibujarCorazon(mt, i, separador, caracterEsquina, mano, centroX, centroY);
            }
            
            else if (simbolo[mano[i].ordinal()] == "TREBOL"){
                dibujarTrebol(mt, i, separador, caracterEsquina, mano, centroX, centroY);
            }

            else if (simbolo[mano[i].ordinal()] == "PICAS"){
                dibujarPicas(mt, i, separador, caracterEsquina, mano, centroX, centroY);
            }

            else{
                dibujarJoker(mt, i, separador, caracterEsquina, mano, centroX, centroY);
            }
            separador = separador + 200;
            i++;
        }
        
        while (i < cantidaDeCartas){
            mt.dibujarRectanguloLleno(centroX + separador, centroY, 150, 200, Colores.RED);
            mt.dibujarRectangulo(centroX + separador, centroY, 150, 200, Colores.WHITE);
            separador = separador + 200;
            i++;
        }
    }

    public static void dibujarDiamante(MaquinaDeTrazados mt, int i, int separador, String[] caracterEsquina, Carta[] mano, int centroX, int centroY){
        int x = mt.XMAX;
        int y = mt.YMAX;

        int[] enX = {centroX + x/25 - 30 + separador, centroX + x/13 - 30 + separador, centroX + x/9 - 30 + separador, centroX + x/13 - 30 + separador};
		int[] enY = {centroY + y/7 , centroY + y/5 , centroY + y/7, centroY + y/13};
		mt.dibujarPoligonoLleno(enX, enY, 4, Colores.RED);

        mt.dibujarString(caracterEsquina[mano[i].ordinal()], centroX + separador, centroY + 20, Colores.RED);
		mt.dibujarString(caracterEsquina[mano[i].ordinal()], centroX + 125 + separador, centroY + y/3 - 40, Colores.RED);
    }

    public static void dibujarCorazon(MaquinaDeTrazados mt, int i, int separador, String[] caracterEsquina, Carta[] mano, int centroX, int centroY){
        int x = mt.XMAX;
        int y = mt.YMAX;
        

        int[] enX = {centroX + x/24 - 40 + separador, centroX + x/12 - 40 + separador, centroX + x/12 + x/24 - 40 + separador, centroX + x/12 + x/24 - 40 + separador, centroX + x/12 + x/48 - 40 + separador, centroX + x/12 - 40 + separador, centroX + x/24 + x/48 - 40 + separador, centroX + x/24 - 40 + separador};
		int[] enY = {centroY + y/6 - 30, centroY + y/6 + y/12 - 30, centroY + y/6 - 30, centroY + y/12 + y/18 - 30, centroY + y/12 + y/36 - 30, centroY + y/12 + y/18 - 30, centroY + y/12 + y/36 - 30, centroY + y/12 + y/18 - 30};
		mt.dibujarPoligonoLleno(enX, enY, 8, Colores.RED);

        mt.dibujarString(caracterEsquina[mano[i].ordinal()], centroX + separador, centroY + 20, Colores.RED);
		mt.dibujarString(caracterEsquina[mano[i].ordinal()], centroX + 125 + separador, centroY + y/3 - 40, Colores.RED);
    }

    public static void dibujarTrebol(MaquinaDeTrazados mt, int i, int separador, String[] caracterEsquina, Carta[] mano, int centroX, int centroY){
        int x = mt.XMAX;
        int y = mt.YMAX;

        mt.dibujarOvaloLleno(centroX + x/24 + x/48 - 40 + separador, centroY + y/12 - 30, x/24, y/12, Colores.BLACK);
		mt.dibujarOvaloLleno(centroX + x/24 - 40 + separador, centroY + y/6 - 30, x/24, y/12, Colores.BLACK);
		mt.dibujarOvaloLleno(centroX + x/12 - 40 + separador, centroY + y/6 - 30, x/24, y/12, Colores.BLACK);

        mt.dibujarString(caracterEsquina[mano[i].ordinal()], centroX + separador, centroY + 20, Colores.BLACK);
		mt.dibujarString(caracterEsquina[mano[i].ordinal()], centroX + 125 + separador, centroY + y/3 - 40, Colores.BLACK);
    }

    public static void dibujarPicas(MaquinaDeTrazados mt, int i, int separador, String[] caracterEsquina, Carta[] mano, int centroX, int centroY){
        int x = mt.XMAX;
        int y = mt.YMAX;

        int[] enX = {centroX + x/24 - 40 + separador, centroX + x/24 + x/48 - 40 + separador, centroX + x/12 + x/48 - 40 + separador, centroX + x/12 + x/24 - 40 + separador, centroX + x/12 + x/24 - 40 + separador, centroX + x/12 - 40 + separador, centroX + x/24 - 40 + separador};
		int[] enY = {centroY + y/6 + y/24 - 30, centroY + y/6 + y/12 - 30, centroY + y/6 + y/12 - 30, centroY + y/6 + y/24 - 30, centroY + y/12 + y/18 - 30, centroY + y/12 - 30, centroX + y/12 + y/18 - 30};
		int[] enelX = {centroX + x/24 + x/48 - 40 + separador, centroX + x/12 + x/48 - 40 + separador, centroX + x/12 - 40 + separador};
		int[] enelY = {centroY + y/6 + y/12 + y/36 - 30, centroY + y/6 + y/12 + y/36 - 30, centroY + y/6 + y/12 - 30};
		mt.dibujarPoligonoLleno(enX, enY, 7);
		mt.dibujarPoligonoLleno(enelX, enelY, 3);

        mt.dibujarString(caracterEsquina[mano[i].ordinal()], centroX + separador, centroY + 20, Colores.BLACK);
		mt.dibujarString(caracterEsquina[mano[i].ordinal()], centroX + 125 + separador, centroY + y/3 - 40, Colores.BLACK);
    }

    public static void dibujarJoker(MaquinaDeTrazados mt, int i, int separador, String[] caracterEsquina, Carta[] mano, int centroX, int centroY){
        int x = mt.XMAX;
        int y = mt.YMAX;

        int[] enX = {centroX + x/36 - 40 + separador, centroX + x/24 + x/72 - 40 + separador, centroX + x/24 - 40 + separador, centroX + x/12 - 40 + separador,  centroX + x/24 + x/12 - 40 + separador, centroX + x/12 + x/36 - 40 + separador, centroX + x/12 + x/24 + x/72 - 40 + separador, centroX + x/12 + x/72 - 40 + separador, centroX + x/12 - 40 + separador, centroX + x/24 + x/36 - 40 + separador};
        int[] enY = {centroY + y/6 - 30, centroY + y/6 + y/36 - 30, centroY + y/6 + y/12 - 30, centroY + y/6 + y/24 - 30, centroY + y/6 + y/12 - 30, centroY + y/6 + y/36 - 30, centroY + y/6 - 30, centroY + y/6 - 30, centroY + y/12 + y/36 - 30, centroY + y/6 - 30};
        mt.dibujarPoligonoLleno(enX, enY,  10, Colores.GREEN);

        mt.dibujarString(caracterEsquina[mano[i].ordinal()], centroX + separador, centroY + 20, Colores.BLACK);
        
    }
}
