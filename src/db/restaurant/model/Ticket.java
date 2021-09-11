package db.restaurant.model;

import java.util.Date;

public class Ticket {
	
	private int id;
	private int mesa;
	private Date fecha;
	private double valorTotal;
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}

	public Ticket(int nomesa) {
		this.mesa = nomesa;
		this.fecha= new Date();
	}
	
	public Ticket(int id, double valorTotal) {
		this.id = id;
		this.valorTotal= valorTotal;
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
	
	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	


}
