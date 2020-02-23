package Prueba.tarea1TorreHanoi;

import java.util.Stack;

public class Discos {
	
	private Stack<Disco> losDiscos;
	
	public Discos() {
		
		losDiscos = new Stack<Disco>();
	}
	
	public void registrarDisco(Disco disco) {
		
		losDiscos.push(disco);
	}
	
	public Stack<Disco> verDiscosRegristro() {
		
		for (Disco disco: losDiscos) {
			System.out.println("Disco = "+disco.getNumeroDisco());
		}
		
		return losDiscos;
		
	}
	public Disco obtenerDisco() {
		if (losDiscos.empty()) {
			return null;
		}
		return losDiscos.pop();
	}
	
	public Disco verUltimoDisco() {
		if (losDiscos.empty()) {
			return null;
		}
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
