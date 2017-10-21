package arg.model;

import java.io.Serializable;

public class Mueble implements Serializable{
	private String codigo;
	private String descripcion;
	private String nombre;
	private int cantidad;
	private String duenio;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getDuenio() {
		return duenio;
	}
	public void setDuenio(String duenio) {
		this.duenio = duenio;
	}
	
	public Mueble(String codigo, String descripcion, String nombre, int cantidad, String duenio) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.duenio = duenio;
	}
	
	@Override
	public String toString() {
		return "Mueble [codigo=" + codigo + ", descripcion=" + descripcion + ", nombre=" + nombre + ", cantidad="
				+ cantidad + ", duenio=" + duenio + "]";
	}
	
	public Mueble() {
		this("","","",0,"");
	}
	
	
	
}
