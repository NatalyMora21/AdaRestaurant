package db.restaurant.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.restaurant.model.Plato;
import db.restaurant.model.Ticket;

public class TicketsDAO {
	
	//Crar nuevo ticket
	public static int insertarTicket(Ticket ticket, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("INSERT INTO TICKET (NUMERO_MESA) VALUES(?)");
		stmt.setInt(1, ticket.getMesa());
		//stmt.setDate(2, (Date) ticket.getFecha());
		stmt.executeUpdate();
		
		PreparedStatement query = connection.prepareStatement("SELECT ID FROM TICKET ORDER BY ID DESC");
		ResultSet res = query.executeQuery();
		
		int id = 0;
		if (res.next()) {
			id = res.getInt("id");
		}
		return id;
	}

	
	//Consultar ticket
	public static List<Plato> consultarPlatosTicket(int id, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM PEDIDO INNER JOIN PLATO ON PEDIDO.ID_NO_PLATO= PLATO.ID WHERE PEDIDO.ID_NO_TICKET=?");
		stmt.setInt(1, id);
		
		List <Plato> platos = new ArrayList<Plato>();
		ResultSet res = stmt.executeQuery();
		
		Plato plato = new Plato();
		while (res.next()) {
			
			System.out.print(res.getString("descripcion"));
			plato = new Plato();
			plato.setDescripcion(res.getString("descripcion"));
			plato.setId(res.getInt("id"));
			plato.setPrecio(res.getInt("precio"));
			platos.add(plato);
			
		}
		return platos;
	
	}
	
	public static List<Ticket> allTickets(Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("select *  FROM TICKETS");
		List<Ticket> tickets = new ArrayList<Ticket>();
		ResultSet res = stmt.executeQuery();
		Ticket ticket = null;
		while (res.next()) {
			ticket = new Ticket();
			ticket.setId(res.getInt("id"));
			ticket.setMesa(res.getInt("mesa"));
			ticket.setValorTotal(res.getDouble("total"));
			tickets.add(ticket);
		}
		return tickets;
	}
	
	/*public static double totalFactura() {
	
	
	}*/
	
	public static void agregarTotal(Ticket ticket,Connection connection) throws SQLException {
		
		PreparedStatement stmt = connection.prepareStatement("UPDATE TICKET SET TOTAL = ? WHERE ID = ?");
		stmt.setDouble(1, ticket.getValorTotal());
		stmt.setDouble(2, ticket.getId());
		stmt.executeUpdate();
		
	}
	

	
	
	
	
	


}
