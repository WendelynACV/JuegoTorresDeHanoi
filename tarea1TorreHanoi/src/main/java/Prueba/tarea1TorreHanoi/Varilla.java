package Prueba.tarea1TorreHanoi;

public class Varilla extends Discos{
	
	private int idVarilla = 0;
	
	public Varilla (int idVarilla) {
		this.idVarilla = idVarilla;
	}
	
	public void llenarDiscos(int cantidadDiscos) {
		if (cantidadDiscos >= 0) {
			Disco disco = new Disco(cantidadDiscos);
			this.registrarDisco(disco);
			//El método llenarDiscos aplica recursividad  al llamarse así mismo.
			llenarDiscos(cantidadDiscos -= 1);
		}	
	}
	
	public void verRegistroVarilla() {
		System.out.println("---------------------------------");
		System.out.println("Varilla = "+getIdVarilla());
		this.verDiscosRegristro();
		System.out.println("---------------------------------");
	}
	
	//Getter y setter

	public int getIdVarilla() {
		return idVarilla;
	}

	public void setIdVarilla(int idVarilla) {
		this.idVarilla = idVarilla;
	}
	
}
