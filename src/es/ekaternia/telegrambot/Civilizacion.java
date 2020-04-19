package es.ekaternia.telegrambot;

public class Civilizacion {
	private String nombre;
	private String grupo;
	private Integer puntos;
	private Integer numeros;

	public void setGrupo(String grupo) {
		this.grupo=grupo;
	}

	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public void setPuntos(Integer puntos) {
		this.puntos=puntos;
	}
	public void setNumeros(Integer numeros){
		this.numeros=numeros;
	}
	
	public String getGrupo() {
		return this.grupo;
	}
	public String getNombre() {
		return this.nombre;
	}
	public Integer getPuntos() {
		return this.puntos;
	}

	public Integer getNumeros() {
		return this.numeros;
	}

}
