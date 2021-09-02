package db.restaurant.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.restaurant.model.Pedido;


public class PedidoDAO {
	
	//Crear pedido
	public static void insertarPedido(Pedido pedido, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("INSERT INTO TICKET (ID_NO_TICKET,  ID_NO_PLATO) VALUES(?,?)");
		stmt.setInt(1, pedido.getNo_ticket());
		stmt.setInt(2, pedido.getNo_plato());
		stmt.executeUpdate();
	}


}
