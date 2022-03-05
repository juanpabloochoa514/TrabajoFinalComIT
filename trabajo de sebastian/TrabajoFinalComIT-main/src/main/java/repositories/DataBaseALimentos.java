package repositories;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import DB.ConcreteDBMSHandler;
import DB.DbFacade;
import model.AlimentoCongelado;
import model.Alimento;

public class DataBaseALimentos implements AlimentosInterfaceRepository{
	private DbFacade dbFacade;
	
	public DataBaseALimentos()throws SQLException{
		ConcreteDBMSHandler dbmsHandler = new ConcreteDBMSHandler();
		dbmsHandler.startup();
		this.dbFacade = new DbFacade(dbmsHandler);
	}
	@Override
	public void addNewAlimento(Alimento alimento) {
		int id = 0;	
		try {
			String insertionQuery = "INSERT INTO TABLA 1 (id,price, name,cantidad) VALUES ("+alimento.getId()+",'"+alimento.getAlimentoName()+"',"+alimento.getCantidad()+");";                     
			id = dbFacade.executeInsertionQuery(insertionQuery);
			alimento.setId(id);
		} catch (SQLException e) {
			System.err.println("Error al insertar: " + e.getMessage());
		}
	}
	@Override
	public void addFrozenAlimento(AlimentoCongelado alimentoC) {
		int IdCong = 0;	
		try {
			String insertionQuery = "INSERT INTO TABLA 2 (id,name,cantidad) VALUES ("+alimentoC.getIdCong()+",'"+alimentoC.getAlimentoCongName()+"',"+alimentoC.getCantidadCong()+");";                     
			IdCong = dbFacade.executeInsertionQuery(insertionQuery);
			alimentoC.setIdCong(IdCong);
		} catch (SQLException e) {
			System.err.println("Error al insertar: " + e.getMessage());
		}
	}
	@Override
	public Alimento[] getAll() {
		try {
			List<HashMap<String,Object>> rows = this.dbFacade.executeQueryReturningSet("SELECT * FROM  TABLA 1");
			int rowCount = rows.size();
		    Alimento[] alimentoarray = new Alimento[rowCount];
			for (int i = 0; i < rows.size(); i++) {
				Alimento alimento = toAlimento(rows.get(i));
				alimentoarray[i] = alimento;
				
			}
			return alimentoarray;
		} catch(Exception e) {
			System.err.println("Error al recuperar: " + e.getMessage());
			return new Alimento[0];
		}
	}
	@Override
	public AlimentoCongelado[] getAllAlimentoCongelado() {
		try {
			List<HashMap<String,Object>> rows = this.dbFacade.executeQueryReturningSet("SELECT * FROM  TABLA 2");
			int rowCount = rows.size();
			AlimentoCongelado[] AlimentoCongeladoarray = new AlimentoCongelado[rowCount];
			for (int i = 0; i < rows.size(); i++) {
				AlimentoCongelado alimentoC = toAlimentoC(rows.get(i));
				AlimentoCongeladoarray[i] = alimentoC;
			}
			return AlimentoCongeladoarray;
		} catch(Exception e) {
			System.err.println("Error al recuperar: " + e.getMessage());
			return new AlimentoCongelado[0];
		}
	}
	public Alimento toAlimento(HashMap<String, Object> valueByColumnName) {
		int idStr = (Integer) valueByColumnName.get("id");//id en azul representa la columna de la base de datos
		String nameStr = (String) valueByColumnName.get("name");//name es el  nombre de la columna
		int cantStr=(Integer)valueByColumnName.get("cantidad");//cantidad es la columna de la base de datos
		
		
		Alimento alimento = new Alimento(idStr,nameStr,cantStr);
		return alimento;
	}
	public AlimentoCongelado toAlimentoC(HashMap<String,Object>valueByColumnName ) {
		int IdcongeladoStr = (Integer) valueByColumnName.get("IdConge");
		String AlimentoNameStr = (String) valueByColumnName.get("nombreCOngelado");
		int CantidadStr = (Integer) valueByColumnName.get("CantidadCOngelado");
		
		
		AlimentoCongelado alimentoC =new AlimentoCongelado (IdcongeladoStr,AlimentoNameStr,CantidadStr);
		return alimentoC;
	}
}
