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
	
	public void verDiscosRegristro(int contador) {
		if (contador < losDiscos.size() ) {
			System.out.println("Disco = "+losDiscos.get(contador).getNumeroDisco());	
			verDiscosRegristro(contador += 1);
		}
	}
	
	public Stack<Disco> obtenerDiscos(){
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
