package controller;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import dao.HuespedesDAO;
import factory.ConnectionFactory;
import modelo.Huespedes;



public class HuespedesController {
	 private HuespedesDAO huespedDAO;
	 
	 public HuespedesController() {
			Connection connection = new ConnectionFactory().recuperarConexion();
			this.huespedDAO = new HuespedesDAO(connection);
		}
	 
		public void guardar(Huespedes huespedes) {
			this.huespedDAO.guardar(huespedes);
		}
		
		public List<Huespedes> list() {
			return this.huespedDAO.list();
		}

		
		public List<Huespedes> listId(String id) {
			return this.huespedDAO.listId(id);
		}
		
		public List<Huespedes> buscar() {
			return this.huespedDAO.buscar();
		}
		
		public List<Huespedes> buscarId(String id) {
			return this.huespedDAO.buscarId(id);
		}
		
		public void actualizar(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono, Integer idReserva, Integer id) {
			this.huespedDAO.actualizar(nombre, apellido, fechaNacimiento, nacionalidad, telefono, idReserva, id);
		}
		
		public void Eliminar(Integer id) {
			this.huespedDAO.Eliminar(id);
		}
}
