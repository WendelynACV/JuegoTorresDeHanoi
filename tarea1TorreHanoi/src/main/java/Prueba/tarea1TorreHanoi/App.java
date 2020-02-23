package Prueba.tarea1TorreHanoi;

import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class App 
{
	//private static List<Disco> gffffff = new ArrayList<Disco>();
	private static Jugador jugador = new Jugador(); 
	private int cantidadDiscos = 0;
	
	public static void main( String[] args )
    {
		Scanner entrada = new Scanner( System.in);
        System.out.println( "Marque la cantidad de discos:" );
        int cantidadDiscos = (int) Double.parseDouble(entrada.nextLine());

    }
}
