package db.restaurant.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.restaurant.model.Ticket;

public class TicketsDAO {
	
	//Crar nuevo ticket
	public static void insertarTicket(Ticket ticket, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("INSERT INTO TICKET (NUMERO_MESA,  FECHA) VALUES(?,?)");
		stmt.setInt(1, ticket.getMesa());
		stmt.setDate(2, (Date) ticket.getFecha());
		stmt.executeUpdate();
	}
	
	//Modificar ticket, agregar valor total
	public static void modificarTicket(Ticket ticket, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("UPDATE TOTAL SET DESCRIPCION = ? WHERE ID = ?");
		stmt.setDouble(1, ticket.getValorTotal());
		stmt.setInt(2, ticket.getId());
		stmt.executeUpdate();

	}
	
	public static void consultarTicket(Ticket ticket, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TICKET INNER JOIN PEDIDO ON TICKET.ID= PEDIDO.ID INNER JOIN PLATO ON PEDIDO.ID_PLATO= PLATO.ID WHERE TICKET.ID=?");
		stmt.setInt(1, ticket.getId());
		stmt.executeUpdate();
		
	}
	
	

}
