package model;

public class Alimento {
	private int id;
	private String alimentoName;
	private int cantidad;
	
	
	public Alimento(String alimentoName, int cantidad) {
		super();
		this.alimentoName = alimentoName;
		this.cantidad = cantidad;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	
	public String getAlimentoName() {
		return alimentoName;
	} 
	
	public int getCantidad() {
		return cantidad;
	} 

	
}
