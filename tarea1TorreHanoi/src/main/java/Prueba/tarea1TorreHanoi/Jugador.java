package Prueba.tarea1TorreHanoi;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
	
	private List<Varilla> misVarillas;
	private List<Integer> secuenciaVarillaDiscosPares;
	private List<Integer> secuenciaVarillaDiscosImpares;
	private Varilla varillaEnMovimiento;
	private int cantidadDeDiscos;
	
	public Jugador (int cantidadDeDiscos) {
	
		misVarillas = new ArrayList<Varilla>();
		misVarillas.add(new Varilla(0));
		misVarillas.add(new Varilla(1));
		misVarillas.add(new Varilla(2));
		
		secuenciaVarillaDiscosPares = new ArrayList<Integer>();
		secuenciaVarillaDiscosPares.add(0);
		secuenciaVarillaDiscosPares.add(1);
		secuenciaVarillaDiscosPares.add(2);
		
		secuenciaVarillaDiscosImpares = new ArrayList<Integer>();
		secuenciaVarillaDiscosImpares.add(0);
		secuenciaVarillaDiscosImpares.add(2);
		secuenciaVarillaDiscosImpares.add(1);
		
		this.cantidadDeDiscos = cantidadDeDiscos;
		misVarillas.get(0).llenarDiscos(cantidadDeDiscos - 1);
		varillaEnMovimiento = null;
	}
	
	public void registroNombreVarilla(int idVarilla) {
		Varilla varilla = new Varilla(idVarilla);
		misVarillas.add(varilla);
	}
	
	public Varilla buscarDondeEstaElDisco(Disco disco, int contador) {
		
		
		if(contador >= misVarillas.size()) {
			return null;
		}
		Varilla varilla = misVarillas.get(contador);
		if(varilla != null && varilla.verUltimoDisco() != null && varilla.verUltimoDisco().getNumeroDisco() == disco.getNumeroDisco() ){
			return varilla;
			
		}else{
			return buscarDondeEstaElDisco(disco, contador += 1);
		}
		
	}
	
	public Disco buscarElDiscoQueSeMueve(int movimientoActual, int contador) {
		
		if (contador >= misVarillas.size()) {
			return null;
		}
		
		Disco disco = misVarillas.get(contador).verUltimoDisco();
		if(disco != null && disco.seDebeMover(movimientoActual) == true) {
			return disco;
		}else {
			return buscarElDiscoQueSeMueve(movimientoActual, contador += 1);
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
		
		if(esPar(idDisco + 1)) {
			return siguienteVarilla(idVarillaActual, secuenciaVarillaDiscosPares);
		}else {
			return siguienteVarilla(idVarillaActual, secuenciaVarillaDiscosImpares);
		}
	}
	
	public void imprimirEstadoDeLasVarrilas(int contador) {
		if (contador < misVarillas.size()) {
			misVarillas.get(contador).verRegistroVarilla();
			imprimirEstadoDeLasVarrilas(contador += 1);
		}
	}
	
	public void calculoTorre(int numeroDeTurnoActual) {
		
		if(misVarillas.get(2).getLosDiscos().size() == cantidadDeDiscos) {
			return;
		} else {
			Disco discoAMover;
			if(misVarillas.get(1).getLosDiscos().empty() || misVarillas.get(2).getLosDiscos().empty()) {
				varillaEnMovimiento = misVarillas.get(0);
			} else {
				discoAMover = this.buscarElDiscoQueSeMueve(numeroDeTurnoActual, 0);
				if (discoAMover != null) {
					varillaEnMovimiento = this.buscarDondeEstaElDisco(discoAMover, 0);
				}
			}
			
			if (varillaEnMovimiento != null) {
				discoAMover = varillaEnMovimiento.obtenerDisco();
				if (discoAMover != null) {
					discoAMover.setUltimoMovimiento(numeroDeTurnoActual);
				}
				
				// A cual varilla se debe mover
				int idVarillaAMover = this.aCualVarillaMover(discoAMover.getNumeroDisco(), varillaEnMovimiento.getIdVarilla());
				misVarillas.get(idVarillaAMover).registrarDisco(discoAMover);	
			}
			System.out.println("Numero de movimiento: "+numeroDeTurnoActual+" ..................");
			imprimirEstadoDeLasVarrilas(0);
			System.out.println("........................................");
			calculoTorre(numeroDeTurnoActual += 1);
		}
	}

}
