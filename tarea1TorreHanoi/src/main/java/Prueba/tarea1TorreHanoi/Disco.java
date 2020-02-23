package Prueba.tarea1TorreHanoi;

public class Disco {
	
	private int idDisco = 0;
	private int ultimoMovimiento = 0;
	
	public Disco(int numeroDisco) {
		this.idDisco= numeroDisco;
		this.ultimoMovimiento = 0;
	}
	
	public boolean seDebeMover(int movimientoActual) {
		
		if((idDisco == 0) && (ultimoMovimiento + 2 == movimientoActual)) {
			return true;
		}else if((idDisco == 1) && (ultimoMovimiento + 4 == movimientoActual)) {
			return true;
		}else if((idDisco == 2) && (ultimoMovimiento + 8 == movimientoActual)) {
			return true;
		}else if((idDisco == 3) && (ultimoMovimiento + 16 == movimientoActual)) {
			return true;
		}else if((idDisco == 4) && (ultimoMovimiento + 32 == movimientoActual)) {
			return true;
		}	else if((idDisco == 5) && (ultimoMovimiento + 64 == movimientoActual)) {
			return true;
		}
		
		return false;
	}
	
	public int obtenerLargoDelDisco() {
		int base = 50;
		int constanteIncremento = 20;
		if(idDisco == 0) {
			return base;
		} else {
			return base + (idDisco * constanteIncremento);
		}
	}
	
	//Getter y setter

	public int getUltimoMovimiento() {
		return ultimoMovimiento;
	}

	public void setUltimoMovimiento(int ultimoMovimiento) {
		this.ultimoMovimiento = ultimoMovimiento;
	}

	public int getNumeroDisco() {
		return idDisco;
	}

	public void setNumeroDisco(int numeroDisco) {
		this.idDisco = numeroDisco;
	}
	
}
