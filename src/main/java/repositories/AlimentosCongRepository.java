package repositories;

import java.util.Arrays;

import model.AlimentoCongelado;


public class AlimentosCongRepository {
	private static int MAX_ALIMENTOS_COUNT = 1000; 
	
	private AlimentoCongelado [] AlimentosCongRepository; 
	private int existingAlimentsCongeladosCount;
	private int  addedCongeladosCount;
	
	public AlimentosCongRepository () {
		this.AlimentosCongRepository = new AlimentoCongelado[MAX_ALIMENTOS_COUNT];
		this.existingAlimentsCongeladosCount = 1;
	} 
	
	
	public int addNewCongelado (AlimentoCongelado alimentoCongelado) {
		this.AlimentosCongRepository [this.existingAlimentsCongeladosCount] = alimentoCongelado;
		int indiceUsado = this.existingAlimentsCongeladosCount;
		this.existingAlimentsCongeladosCount++;
		return this.existingAlimentsCongeladosCount-1;
		
	}
	
	public AlimentoCongelado [] getAll(){
		
		return Arrays.copyOf(this.AlimentosCongRepository, this.existingAlimentsCongeladosCount);
	}
	
}
