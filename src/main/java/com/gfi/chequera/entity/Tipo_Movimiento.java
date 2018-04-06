/**
 * 
 */
package com.gfi.chequera.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 */
@Entity
@Table(name="tipo_movimiento")
public class Tipo_Movimiento {
	@Id
	@GeneratedValue
	private int idTipoMovimiento;
	private String tmDescripcion;
	
	
	
	public Tipo_Movimiento() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tipo_Movimiento(int idTipoMovimiento, String tmDescripcion) {
		super();
		this.idTipoMovimiento = idTipoMovimiento;
		this.tmDescripcion = tmDescripcion;
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
}
