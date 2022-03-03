package repositories;

import java.util.Arrays;

import model.Alimento;

public class AlimentosRepository {

	private static int MAX_ALIMENTOS_COUNT = 1000; 
	
	private Alimento [] AlimentosRepository;//array para manejar internamente
	private int existingAlimentosCount ;   // cuenta alimentos creados
	private int addedAlimentosCount;
	
	
	
	
	public AlimentosRepository() {//constructor
		this.AlimentosRepository = new Alimento[MAX_ALIMENTOS_COUNT]; //EN ESTE ATRIBUTO HAGO REFERENCIA A UN ARREGLO DE 1000 ALIMENTOS
		this.existingAlimentosCount=1;
	}

	public int addNewAlimento(Alimento alimento) {
		this.AlimentosRepository[this.existingAlimentosCount]=alimento; //lugar en el que guardo el alimento
		int indiceUsado = this.existingAlimentosCount; 	 
		this.existingAlimentosCount++;
		return this.existingAlimentosCount-1;
		
		/*alimento.setId(this.addedAlimentosCount);
		return this.addedAlimentosCount++;*/
	
	}

	public Alimento [] getAll() { // metodo para listar objetos
		
		return Arrays.copyOf(this.AlimentosRepository , this.existingAlimentosCount);
				
		
	}
}
