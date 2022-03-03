package model;

public class AlimentoCongelado {
	
	private int IdCong;
	private String alimentoCongName;
	private int cantidadCong;

	public AlimentoCongelado(String alimentoCongName, int cantidadCong) {
		super();
		this.alimentoCongName= alimentoCongName;
		this.cantidadCong=cantidadCong;
	}
	
	
	public void setIdCong(int idCong) {
		this.IdCong = idCong;
	}
	
	public int getIdCong() {
		return IdCong;
	}
	
	public void setAlimentoCongName (String alimentoCongName) {
		this.alimentoCongName = alimentoCongName;
	}
	
	public String getAlimentoCongName() {
		return alimentoCongName;
	}
	
	public void setCantidadCong(int cantidadCong) {
		this.cantidadCong = cantidadCong;
	}

	public int getCantidadCong() {
		return cantidadCong;
	}

}
