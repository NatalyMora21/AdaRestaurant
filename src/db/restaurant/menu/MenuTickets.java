package db.restaurant.menu;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import db.restaurant.dao.PedidoDAO;
import db.restaurant.dao.TicketsDAO;
import db.restaurant.model.Pedido;
import db.restaurant.model.Plato;
import db.restaurant.model.Ticket;

public class MenuTickets {
	
	public static void menuTicket(Scanner sc, Connection connection) throws SQLException {
		//1. Menu Crear Ticket
		generarTicket(sc,connection) ;
		//2. Ver todas las facturas
		//allTickets(sc,connection);
		
		//3. Eliminar Facturas
	}
	
	private static int generarTicket(Scanner sc, Connection connection) throws SQLException {
		//Generar Ticket
		System.out.println("1. Ingrese el número de mesa");
		int noMesa = sc.nextInt();
		int ticket = TicketsDAO.insertarTicket(new Ticket(noMesa), connection);
		System.out.println(ticket);
		//Agregar platos al ticket ir a menu 
		agregarPlatosTicket(sc,connection,ticket);
		return ticket;
	}
	
	private static void agregarPlatosTicket(Scanner sc, Connection connection, int idticket) throws SQLException {
		//Generar Ticket
		System.out.println("--Lista de platos--");
		//Agregar platos al ticket ir a menu 
		MenuPlatos.listadoPlatos(connection);
		
		System.out.println("--Ingrese al número del plato, para terminar, marque 0--");
		int salir= 1;
		int idPlato;
		
		while (salir!= 0) { 
			System.out.println("Plato:");
			idPlato=  sc.nextInt();
			Pedido pedido= new Pedido(idticket,idPlato);
			//Agregar platos a ticket
			PedidoDAO.agregarPlato(pedido, connection);
			System.out.println("--Para terminar, marque 0, para continuar marque 1");
			salir=  sc.nextInt();
		}
		
		//Mostrar Factura
		mostrarticketById(idticket, connection);
		

	}
	
	//Mostar el pedido
	
	private static void mostrarticketById(int ticket,Connection connection ) throws SQLException {
		
		System.out.println("--FACTURA No:" + ticket);
		System.out.println("--PLATOS");
		List <Plato> platos = TicketsDAO.consultarPlatosTicket(ticket, connection);
		for (Plato plato : platos) {
			System.out.println(plato.getDescripcion() + " " + plato.getPrecio());
		}

		System.out.println("--TOTAL");
		//double total = totalFactura()
		//Ticket ticket = new Ticket(ticket,total)
		//agregarTotal(ticket,connection);
		
	}
	
	public static void allTickets(Connection connection) throws SQLException {
		
		List<Ticket> tickets= TicketsDAO.allTickets(connection);
		
		System.out.println("--LISTADO DE TICKETS--");
		for ( Ticket ticket: tickets ) {
			System.out.println("---------------------");
			System.out.println("No Ticket: "+ ticket.getId());
			System.out.println("No Mesa: "+ ticket.getMesa());
			System.out.println("No Fecha: "+ ticket.getFecha());
			System.out.println("Total: "+ ticket.getValorTotal());
			
		}
		
	}

}
