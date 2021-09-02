package db.restaurant.model;

import java.util.Date;

public class Ticket {
	
	private int id;
	private int mesa;
	private Date fecha;
	
	public Ticket(int nomesa, Date fecha) {
		this.mesa = nomesa;
		this.fecha= fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	


}
