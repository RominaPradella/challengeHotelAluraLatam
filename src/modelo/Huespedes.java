package modelo;

import java.sql.Date;

public class Huespedes {
	private Integer Id;
	private String Nombre;
	private String Apellido;
	private Date FechaNacimiento;
	private String Nacionalidad;
	private String Telefono;
	private Integer IdReserva;
	
	public Huespedes(String nombre, String apellido,  Date fechaNacimiento, String nacionalidad, String telefono,
			Integer idReserva) {
		super();
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.FechaNacimiento = fechaNacimiento;
		this.Nacionalidad = nacionalidad;
		this.Telefono = telefono;
		this.IdReserva = idReserva;
	}
	
	public Huespedes(Integer id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad,
			String telefono, Integer idReserva) {
		this.Id = id;
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.FechaNacimiento = fechaNacimiento;
		this.Nacionalidad = nacionalidad;
		this.Telefono = telefono;
		this.IdReserva = idReserva;
	}


	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}


	public String getNombre() {
		return Nombre;
	}

	public String getApellido() {
		return Apellido;
	}


	public String getNacionalidad() {
		return Nacionalidad;
	}


	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}


	public String getTelefono() {
		return Telefono;
	}

	public Integer getIdReserva() {
		return IdReserva;
	}

	public void setIdReserva(Integer idReserva) {
		IdReserva = idReserva;
	}
	
}
