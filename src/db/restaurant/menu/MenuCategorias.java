package db.restaurant.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import db.restaurant.dao.CategoriaDAO;
import db.restaurant.model.Categoria;

public class MenuCategorias {
	
	public static void submenuCategorias(Scanner sc, Connection connection) throws SQLException {
		int opcion = menuCategoria(sc, connection);
		while (opcion != 0) {
			switch (opcion) {
			case 1:
				altaCategoria(sc, connection);
				break;
			case 2:
				bajaCategoria(sc, connection);
				break;
			case 3:
				modificacionCategoria(sc, connection);
				break;
			case 4:
				listadoCategoria(connection);
				break;
			}

			opcion = menuCategoria(sc, connection);
		}
	}

	private static void listadoCategoria(Connection connection) throws SQLException {
		List<Categoria> categorias = CategoriaDAO.findAll(connection);
		System.out.println("Listado de categorias de platos");
		System.out.println();
		for (Categoria categoria : categorias) {
			System.out.println(categoria.getId() + " " + categoria.getDescripcion());
		}
		System.out.println();

	}

	private static Categoria findByIdCategoria(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Ingrese id categoria del plato: ");
		int id = sc.nextInt();
		return CategoriaDAO.findById(id, connection);

	}

	private static void modificacionCategoria(Scanner sc, Connection connection) throws SQLException {

		Categoria categoria = findByIdCategoria(sc, connection);
		if (categoria == null) {
			System.out.println("Categoria no encontrada");
		} else {

			System.out.println("Ingrese descripcion categoria del plato: ");
			sc.nextLine();
			String categoriaDescripcion = sc.nextLine();
			categoria.setDescripcion(categoriaDescripcion);
			CategoriaDAO.modificar(categoria, connection);

			System.out.println("Modificacion realizada");
			System.out.println();
		}

	}

	private static void bajaCategoria(Scanner sc, Connection connection) throws SQLException {
		Categoria categoria = findByIdCategoria(sc, connection);
		if (categoria != null) {
			CategoriaDAO.borrar(categoria.getId(), connection);
		} else {
			System.out.println("No existe categoria del plato");
		}

		System.out.println("Baja realizada");
		System.out.println();
	}

	private static void altaCategoria(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Ingrese nombre categoria del plato: ");
		String categoria = sc.next();
		CategoriaDAO.insertar(new Categoria(categoria), connection);
		System.out.println("Alta realizada");
		System.out.println();
	}

	private static int menuCategoria(Scanner sc, Connection connection) {
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
