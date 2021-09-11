package db.restaurant.model;

public class Plato {
	
	private int id;
	private String descripcion;
	private double precio;
	private int id_categoria;
		
	public Plato (String descripcion,double precio, int id_categoria ) {
		
		this.descripcion= descripcion;
		this.precio= precio;
		this.id_categoria =  id_categoria;
		
		
	}
	
	public Plato () {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	
	

}
