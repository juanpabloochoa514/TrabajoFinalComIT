package model;

public class Alimento {
	private int id;
	private String alimentoName;
	private int cantidad;
	
	
	public Alimento(int id , String alimentoName, int cantidad) {
		
		this.id=id;
		this.alimentoName = alimentoName;
		this.cantidad = cantidad;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setAlimentoName(String alimentoName) {
		this.alimentoName=alimentoName;
	}
	
	public String getAlimentoName() {
		return alimentoName;
	} 
	public void setCantidad(int cantidad) {
		this.cantidad=cantidad;
	}
	
	public int getCantidad() {
		return cantidad;
	} 

	
}
