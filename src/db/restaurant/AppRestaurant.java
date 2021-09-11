package db.restaurant;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import db.restaurant.menu.MenuCategorias;
import db.restaurant.menu.MenuTickets;
import db.restaurant.menu.MenuPlatos;


public class AppRestaurant {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Connection connection;
		try {
			connection = AdminBD.obtenerConexion("com.mysql.cj.jdbc.Driver");

			int opcion = menu(sc);
			while (opcion != 0) {
				switch (opcion) {
				case 1:
					MenuCategorias.submenuCategorias(sc, connection);
					break;
				case 2:
					MenuPlatos.submenuPlatos(sc, connection);
					break;
				case 3:
					MenuTickets.submenuTickets(sc, connection);
					break;
				}
				opcion = menu(sc);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public static int menu(Scanner sc) {

		System.out.println("Menu opciones");
		System.out.println();
		System.out.println("1. Categorias plato");
		System.out.println("2. Platos");
		System.out.println("3. Generar Ticket");
		System.out.println("0. Salir");
		System.out.println();
		System.out.println("Ingrese opcion: ");

		return sc.nextInt();
	}
	

	


}
