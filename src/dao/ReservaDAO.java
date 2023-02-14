package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Reserva;

public class ReservaDAO {
	
	private Connection connection;
	
	public ReservaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void guardar(Reserva reserva) {
		try {
			String sql = "INSERT INTO reservas (FechaEntrada, FechaSalida, Valor, FormaPago) VALUES (?, ?, ?, ?)";

			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				pstm.setDate(1, reserva.getfechaE());
				pstm.setDate(2, reserva.getfechaS());
				pstm.setString(3, reserva.getvalor());
				pstm.setString(4, reserva.getformaPago());

				pstm.executeUpdate();

				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						reserva.setId(rst.getInt(1));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
    private void ResultSetToReserva(List<Reserva> reservas, PreparedStatement statement) throws SQLException {

    	try (ResultSet rst = statement.getResultSet()) {
			while (rst.next()) {
				Reserva produto = new Reserva(rst.getInt(1), rst.getDate(2), rst.getDate(3), rst.getString(4), rst.getString(5));

				reservas.add(produto);
			}
		}
	}
	
	 public List<Reserva> list() {

	    	List<Reserva> reservas = new ArrayList<Reserva>();

			try {

				final PreparedStatement statement = connection.prepareStatement("SELECT IdReserva, FechaEntrada, FechaSalida, Valor, FormaPago FROM reservas");
				
				try(statement) {
			    	statement.execute();
					ResultSetToReserva(reservas, statement);
					
				}
				return reservas;

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
		}
	
	
	public List<Reserva> buscar() {
		List<Reserva> reservas = new ArrayList<Reserva>();
		try {
			String sql = "SELECT * FROM reservas";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				transformarResultSetEnReserva(reservas, pstm);
			}
			return reservas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Reserva> buscarId(String id) {
		List<Reserva> reservas = new ArrayList<Reserva>();
		try {

			String sql = "SELECT * FROM reservas WHERE IdReserva = ?";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setString(1, id );
				pstm.execute();

				transformarResultSetEnReserva(reservas, pstm);
			}
			return reservas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void Eliminar(Integer id) {
		try (PreparedStatement stm = connection.prepareStatement("DELETE FROM reservas WHERE IdReserva = ?")) {
			stm.setInt(1, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Reserva> listId(String id) {

		List<Reserva> reservas = new ArrayList<Reserva>();

		try {

			final PreparedStatement statement = connection.prepareStatement("SELECT IdReserva, FechaEntrada, FechaSalida, Valor, FormaPago FROM reservas "
					+ "WHERE IdReserva= ?");
			
			try(statement) {

				statement.setString(1, id);

				statement.execute();
				ResultSetToReserva(reservas, statement);
				
			}
			return reservas;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void actualizar(Reserva reserva) {

		try {

			final PreparedStatement statement = connection.prepareStatement("UPDATE reservas SET FechaEntrada = ?, FechaSalida = ?, "
					+ "Valor = ?, FormaPago = ?  WHERE IdReserva = ?");
			try(statement) {
				statement.setDate(1, (java.sql.Date) reserva.getfechaE());
				statement.setDate(2, (java.sql.Date) reserva.getfechaS());
				statement.setString(3, reserva.getvalor());
				statement.setString(4, reserva.getformaPago());
				statement.setInt(5, reserva.getId());
				statement.executeUpdate();
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
						
	private void transformarResultSetEnReserva(List<Reserva> reservas, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				Reserva produto = new Reserva(rst.getInt(1), rst.getDate(2), rst.getDate(3), rst.getString(4), rst.getString(5));

				reservas.add(produto);
			}
		}
	}
}
