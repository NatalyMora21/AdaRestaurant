package db.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import db.restaurant.model.Plato;

public class PlatoDAO {
	
	public static List<Plato> findAll(Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("select *  FROM PLATO");
		List<Plato> platos = new ArrayList<Plato>();
		ResultSet res = stmt.executeQuery();
		Plato plato = null;
		while (res.next()) {
			plato = new Plato();
			plato.setDescripcion(res.getString("descripcion"));
			plato.setId(res.getInt("id"));
			plato.setPrecio(res.getDouble("precio"));
			platos.add(plato);
		}
		return platos;
	}
	
	public static void insertar(Plato plato, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("INSERT INTO PLATO (DESCRIPCION, PRECIO, ID_CATEGORIA) VALUES(?,?,?)");
		stmt.setString(1, plato.getDescripcion());
		stmt.setDouble(2, plato.getPrecio());
		stmt.setDouble(3, plato.getId_categoria());
		stmt.executeUpdate();
	}

	public static void borrar(int idPlato, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM PLATO WHERE ID = ?");
		stmt.setInt(1, idPlato);
		stmt.executeUpdate();

	}

	public static Plato findById(int id, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("select *  FROM PLATO WHERE ID = ?");
		stmt.setInt(1, id);
		ResultSet res = stmt.executeQuery();
		Plato plato = null;
		if (res.next()) {
			plato = new Plato();
			plato.setDescripcion(res.getString("descripcion"));
			plato.setId(res.getInt("id"));
			plato.setPrecio(res.getDouble("precio"));
		}
		return plato;
	}

	public static void modificar(Plato plato, Connection connection) throws SQLException {
		//Validar si se puede modificar solo uno
		PreparedStatement stmt = connection.prepareStatement("UPDATE CATEGORIA_PLATO SET DESCRIPCION = ? WHERE ID = ?");
		stmt.setString(1, plato.getDescripcion());
		stmt.setInt(2, plato.getId());
		stmt.executeUpdate();

	}


}
