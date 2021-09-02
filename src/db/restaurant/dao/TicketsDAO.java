package db.restaurant.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import db.restaurant.model.Ticket;

public class TicketsDAO {
	public static void insertarTicket(Ticket ticket, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("INSERT INTO TICKET (NUMERO_MESA,  FECHA) VALUES(?,?)");
		stmt.setInt(1, ticket.getMesa());
		stmt.setDate(2, (Date) ticket.getFecha());
		stmt.executeUpdate();
	}

}
