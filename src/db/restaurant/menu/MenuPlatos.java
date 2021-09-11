package db.restaurant.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import db.restaurant.dao.PlatoDAO;
import db.restaurant.model.Plato;

public class MenuPlatos {


	public static void listadoPlatos(Connection connection) throws SQLException {
		
		List<Plato> platos = PlatoDAO.findAll(connection);
	
		System.out.println("Listado de categorias de platos");
		System.out.println();
		for (Plato plato : platos) {
			System.out.println(plato.getId() + " " + plato.getDescripcion() + " " + plato.getPrecio());
		}
		System.out.println();

	}



	

}
