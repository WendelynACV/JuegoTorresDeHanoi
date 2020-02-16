package Prueba.tarea1TorreHanoi;

public class Varilla extends Discos{
	
	private String nombreVarilla = "";
	
	
	public Varilla (String nombreVarilla) {
		
		this.nombreVarilla = nombreVarilla;
		
	}
	public void llenarDiscos(int cantidadDiscos) {
		/*int n= cantidadDiscos;
		for (int i=0; i <= cantidadDiscos-1; i ++) {
			
			Disco disco = new Disco(n);
			this.registrarDisco(disco);
			n --;
			
		}*/
		if (cantidadDiscos > 0) {
			Disco disco = new Disco(cantidadDiscos);
			this.registrarDisco(disco);
			//El método llenarDiscos aplica recursividad  al llamarse así mismo.
			llenarDiscos (cantidadDiscos - 1);
			
		}
		
	}
	
	//Getter y setter

	public String getNombreVarilla() {
		return nombreVarilla;
	}

	public void setNombreVarilla(String nombreVarilla) {
		this.nombreVarilla = nombreVarilla;
	}
	

}
