package Prueba.tarea1TorreHanoi;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
	
	private List<Varilla> misVarillas;
	//List<Integer> myCoords = new ArrayList<Integer>();
	private List<Integer> secuenciaVarillaDiscosPares;
	private List<Integer> secuenciaVarillaDiscosImpares;

	public Jugador () {
	
		misVarillas = new ArrayList<Varilla>();
		misVarillas.add(new Varilla(1));
		misVarillas.add(new Varilla(2));
		misVarillas.add(new Varilla(3));
		
		secuenciaVarillaDiscosPares = new ArrayList<Integer>();
		secuenciaVarillaDiscosPares.add(1);
		secuenciaVarillaDiscosPares.add(2);
		secuenciaVarillaDiscosPares.add(3);
		
		secuenciaVarillaDiscosImpares = new ArrayList<Integer>();
		secuenciaVarillaDiscosImpares.add(1);
		secuenciaVarillaDiscosImpares.add(3);
		secuenciaVarillaDiscosImpares.add(2);
		
		misVarillas.get(0).llenarDiscos(4);
		
	}
	public void registroNombreVarilla(int idVarilla) {
		
		Varilla varilla = new Varilla(idVarilla);
		misVarillas.add(varilla);
	}
	
	public Varilla buscarDondeEstaElDisco(Disco disco, int contador) {
		
		Varilla varilla = misVarillas.get(contador);
		if(contador > misVarillas.size()) {
			
			return null;
		}
		else if( (varilla.verUltimoDisco().getNumeroDisco()== disco.getNumeroDisco())||(contador<misVarillas.size()) ){
			
			return varilla;
			
		}else{
			
			return buscarDondeEstaElDisco(disco, contador+1);
		}
		 
	}
	public Disco buscarElDiscoQueSeMueve(int movimientoActual, int contador) {
		
		Disco disco = misVarillas.get(contador).verUltimoDisco();
		if (contador > misVarillas.size()) {
						return null;
		}
		else if((disco.seDebeMover(movimientoActual) == true)) {
			
			return disco;
		}else {
			return buscarElDiscoQueSeMueve(movimientoActual, contador+1);
		}
	}
	public boolean esPar(int numero) {
		if((numero % 2) == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public int siguienteVarilla(int idVarilla, List<Integer> secuenciaVarillaDiscos) {
		
		int pos = secuenciaVarillaDiscos.indexOf(idVarilla);
		if (pos+1 == secuenciaVarillaDiscos.size()) {
			return secuenciaVarillaDiscos.get(0);
			
		}else {
			return secuenciaVarillaDiscos.get(pos+1);
		}
	}
	
	public int aCualVarillaMover(int idDisco, int idVarillaActual) {
		
		if(esPar(idDisco)) {
			return siguienteVarilla(idVarillaActual, secuenciaVarillaDiscosPares);
		}else {
			return siguienteVarilla(idVarillaActual, secuenciaVarillaDiscosImpares);
		}
	}
	
	public void CalculoTorre() {
		if(misVarillas.get(1).getLosDiscos().empty() || misVarillas.get(2).getLosDiscos().empty()) {
			
		}
	}

}
