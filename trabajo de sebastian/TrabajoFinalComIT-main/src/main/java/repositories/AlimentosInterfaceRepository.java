package repositories;

import model.Alimento;
import model.AlimentoCongelado;

public interface AlimentosInterfaceRepository {
	void addNewAlimento(Alimento alimento);
	
	void addFrozenAlimento(AlimentoCongelado alimentoC);
	Alimento[] getAll();
	AlimentoCongelado[] getAllAlimentoCongelado();
	//int o double nombre de la funcion () ;
	//tipo de funcion + nombre de la funcion () ;
}
