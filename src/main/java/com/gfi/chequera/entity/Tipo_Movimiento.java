/**
 * 
 */
package com.gfi.chequera.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 */
@Entity
@Table(name="tipoMovimiento")
public class Tipo_Movimiento {
	@Id
	@GeneratedValue
	private int idTipoMovimiento;
	private String tmDescripcion;
	@OneToMany(fetch = FetchType.EAGER, mappedBy="tipoMovimiento")
	private Set<Movimientos> movimientos = new HashSet<>();
	
	public Tipo_Movimiento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tipo_Movimiento(int idTipoMovimiento, String tmDescripcion, Set<Movimientos> movimientos) {
		super();
		this.idTipoMovimiento = idTipoMovimiento;
		this.tmDescripcion = tmDescripcion;
		this.movimientos = movimientos;
	}

	public int getIdTipoMovimiento() {
		return idTipoMovimiento;
	}

	public void setIdTipoMovimiento(int idTipoMovimiento) {
		this.idTipoMovimiento = idTipoMovimiento;
	}

	public String getTmDescripcion() {
		return tmDescripcion;
	}

	public void setTmDescripcion(String tmDescripcion) {
		this.tmDescripcion = tmDescripcion;
	}

	public Set<Movimientos> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(Set<Movimientos> movimientos) {
		this.movimientos = movimientos;
	}
	
}