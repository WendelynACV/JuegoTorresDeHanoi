package Prueba.tarea1TorreHanoi;

import java.util.List;
import java.util.Stack;

public class Discos {
	
	private Stack<Disco> losDiscos;
	
	public Discos() {
		
		losDiscos = new Stack<Disco>();
	}
	
	/*public void registrarNumeroDisco() {
		
		Disco disco= new Disco(numeroDisco);
		losDiscos.add(disco);
	}*/
	public void registrarDisco(Disco disco) {
		
		losDiscos.push(disco);
	}
	
	public Stack<Disco> verDiscosRegristro() {
		
		for (Disco disco: losDiscos) {
			System.out.print(disco.getNumeroDisco()+"\n");
		}
		return losDiscos;
		
	}
	public Disco obtenerDisco() {
		
		return losDiscos.pop();
		
	}
	public Disco verUltimoDisco() {
		
		return losDiscos.peek();
	}
	//Getter y setter

	public Stack<Disco> getLosDiscos() {
		return losDiscos;
	}

	public void setLosDiscos(Stack<Disco> losDiscos) {
		this.losDiscos = losDiscos;
	}
	

}
