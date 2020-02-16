package Prueba.tarea1TorreHanoi;

public class Disco {
	
	private int idDisco = 0;
	
	public Disco(int numeroDisco) {
		
		this.idDisco= numeroDisco;
		System.out.println(numeroDisco);
	}
	//Getter y setter

	public int getNumeroDisco() {
		return idDisco;
	}

	public void setNumeroDisco(int numeroDisco) {
		this.idDisco = numeroDisco;
	}
	
	

}
