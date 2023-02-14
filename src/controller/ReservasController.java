package controller;

import java.sql.Connection;
import java.util.List;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import modelo.Reserva;

public class ReservasController {
 private ReservaDAO reservaDAO;
 
 public ReservasController() {
		Connection connection = new ConnectionFactory().recuperarConexion();
		this.reservaDAO = new ReservaDAO(connection);
	}
 
	public void guardar(Reserva reserva) {
		this.reservaDAO.guardar(reserva);
	}
		
	public List<Reserva> list() {
		return this.reservaDAO.list();
	}

	
	public List<Reserva> listId(String id) {
		return this.reservaDAO.listId(id);
	}
	
	public List<Reserva> buscar() {
		return this.reservaDAO.buscar();
	}
	
	public List<Reserva> buscarId(String id) {
		return this.reservaDAO.buscarId(id);
	}
	
	public void actualizar(Reserva reserva) {
		this.reservaDAO.actualizar(reserva);		
	}
	
	public void Eliminar(Integer id) {
		this.reservaDAO.Eliminar(id);
	}
	
}
