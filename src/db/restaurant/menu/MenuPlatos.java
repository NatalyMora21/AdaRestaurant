package db.restaurant.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import db.restaurant.dao.CategoriaDAO;
import db.restaurant.dao.PlatoDAO;
import db.restaurant.model.Plato;

public class MenuPlatos {


	public static void listadoPlatos(Connection connection) throws SQLException {
		List<Plato> platos = PlatoDAO.findAll(connection);
		System.out.println("Listado de platos");
		System.out.println();
		for (Plato plato : platos) {
			System.out.println(plato.getId() + " " + plato.getDescripcion() + " " + plato.getPrecio());
		}
		System.out.println();

	}
	
	private static Plato findByIdPlato(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Ingrese id del plato: ");
		int id = sc.nextInt();
		return PlatoDAO.findById(id, connection);

	}

	private static void modificacionPlato(Scanner sc, Connection connection) throws SQLException {
		Plato plato = findByIdPlato(sc, connection);
		if (plato == null) {
			System.out.println("Plato no encontrada");
		} else {
			System.out.println("Ingrese la descripcion del plato: ");
			sc.nextLine();
			String categoriaDescripcion = sc.nextLine();
			plato.setDescripcion(categoriaDescripcion);
			PlatoDAO.modificar(plato, connection);
			System.out.println("Modificacion realizada");
			System.out.println();
		}

	}

	private static void bajaPLato(Scanner sc, Connection connection) throws SQLException {
		Plato plato = findByIdPlato(sc, connection);
		if (plato != null) {
			CategoriaDAO.borrar(plato.getId(), connection);
		} else {
			System.out.println("No existe el plato");
		}
		System.out.println("Baja realizada");
		System.out.println();
	}

	private static void altaPlato(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Ingrese nombre del plato: ");
		String plato = sc.next();
		System.out.println("Ingrese nombre el precio: ");
		double precio = sc.nextDouble();
		System.out.println("Ingrese nombre del plato: ");
		int  categoria = sc.nextInt();
		PlatoDAO.insertar(new Plato(plato, precio, categoria), connection);
		System.out.println("Alta realizada");
		System.out.println();
	}
	
	public static void submenuPlatos(Scanner sc, Connection connection) throws SQLException {
		int opcion = menuPlatos(sc, connection);
		while (opcion != 0) {
			switch (opcion) {
			case 1:
				altaPlato(sc, connection);
				break;
			case 2:
				bajaPLato(sc, connection);
				break;
			case 3:
				modificacionPlato(sc, connection);
				break;
			case 4:
				listadoPlatos(connection);
				break;
			}

			opcion = menuPlatos(sc, connection);
		}
	}

	private static int menuPlatos(Scanner sc, Connection connection) {
		System.out.println("Menu Categoria Plato");
		System.out.println();
		System.out.println("1. Alta");
		System.out.println("2. Baja");
		System.out.println("3. Modificacion");
		System.out.println("4. Listado");
		System.out.println("0. Salir");
		System.out.println();
		System.out.println("Ingrese opcion: ");

		return sc.nextInt();

	}



	

}
