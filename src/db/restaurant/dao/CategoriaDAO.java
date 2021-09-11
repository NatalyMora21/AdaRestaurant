package db.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.restaurant.model.Categoria;

public class CategoriaDAO {

	public static void insertar(Categoria categoria, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("INSERT INTO CATEGORIA_PLATO (DESCRIPCION) VALUES(?)");
		stmt.setString(1, categoria.getDescripcion());
		stmt.executeUpdate();
	}

	public static void borrar(int categoria, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM CATEGORIA_PLATO WHERE ID = ?");
		stmt.setInt(1, categoria);
		stmt.executeUpdate();

	}

	public static Categoria findById(int id, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("select *  FROM CATEGORIA_PLATO WHERE ID = ?");
		stmt.setInt(1, id);
		ResultSet res = stmt.executeQuery();
		Categoria categoria = null;
		if (res.next()) {
			categoria = new Categoria();
			categoria.setDescripcion(res.getString("descripcion"));
			categoria.setId(res.getInt("id"));
		}
		return categoria;
	}

	public static void modificar(Categoria categoria, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("UPDATE CATEGORIA_PLATO SET DESCRIPCION = ? WHERE ID = ?");
		stmt.setString(1, categoria.getDescripcion());
		stmt.setInt(2, categoria.getId());
		stmt.executeUpdate();

	}

	public static List<Categoria> findAll(Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("select *  FROM CATEGORIA_PLATO");
		List<Categoria> categorias = new ArrayList<Categoria>();
		ResultSet res = stmt.executeQuery();
		Categoria categoria = null;
		while (res.next()) {
			categoria = new Categoria();
			categoria.setDescripcion(res.getString("descripcion"));
			categoria.setId(res.getInt("id"));
			categorias.add(categoria);
		}
		return categorias;
	}
	

}
