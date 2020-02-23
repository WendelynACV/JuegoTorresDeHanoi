package Prueba.tarea1TorreHanoi;

import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class App 
{
	//private static List<Disco> gffffff = new ArrayList<Disco>();
	private static Jugador jugador; 
	private static int cantidadDiscos = 0;
	
	public static void main( String[] args )
    {
		Scanner entrada = new Scanner( System.in);
        System.out.println( "Marque la cantidad de discos:" );
        cantidadDiscos = (int) Double.parseDouble(entrada.nextLine());
        jugador = new Jugador(cantidadDiscos);
        jugador.calculoTorre(0);
    }
}
