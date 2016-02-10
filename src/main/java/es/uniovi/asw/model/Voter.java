package es.uniovi.asw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Naucé López
 *
 */
@Entity
@Table(name = "CensoElectoral")
public class Voter {

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String email;
	@Column(unique = true, nullable = false)
	private String NIF;
	private int codColegioElectoral;
	private String password;
	
	protected Voter() {}

	public Voter(String nombre, String email, String NIF, int codColegioElectoral) {
		this.nombre = nombre;
		this.email = email;
		this.NIF = NIF;
		this.codColegioElectoral = codColegioElectoral;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	public String getNIF() {
		return NIF;
	}

	public int getCodColegioElectoral() {
		return codColegioElectoral;
	}
	
	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "Voter [nombre=" + nombre + ", email=" + email + ", NIF=" + NIF + ", codColegioElectoral="
				+ codColegioElectoral + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((NIF == null) ? 0 : NIF.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voter other = (Voter) obj;
		if (NIF == null) {
			if (other.NIF != null)
				return false;
		} else if (!NIF.equals(other.NIF))
			return false;
		return true;
	}
	
}
