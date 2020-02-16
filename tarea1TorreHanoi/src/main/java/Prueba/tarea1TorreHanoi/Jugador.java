package Prueba.tarea1TorreHanoi;

public class Jugador {
	
	private Varilla varilla;
	
	public Jugador () {
	
		varilla = new Varilla("");
		varilla.llenarDiscos(4);
		System.out.println("\n");
		System.out.println(varilla.verUltimoDisco().getNumeroDisco()+"\n");
		
		System.out.println(varilla.obtenerDisco().getNumeroDisco()+"\n");
		System.out.println(varilla.obtenerDisco().getNumeroDisco()+"\n");
		System.out.println(varilla.verUltimoDisco().getNumeroDisco()+"\n");
	}
	
	

}
