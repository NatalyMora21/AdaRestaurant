package db.restaurant.model;

import java.util.Date;

public class Pedido {
	
	
	private int id;
	private int no_ticket;
	private int no_plato;


	public Pedido(int id,int no_ticket , int no_plato) {
		
		this.id= id;
		this.no_ticket= no_ticket;
		this.no_plato= no_plato;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNo_ticket() {
		return no_ticket;
	}


	public void setNo_ticket(int no_ticket) {
		this.no_ticket = no_ticket;
	}


	public int getNo_plato() {
		return no_plato;
	}


	public void setNo_plato(int no_plato) {
		this.no_plato = no_plato;
	}

}
