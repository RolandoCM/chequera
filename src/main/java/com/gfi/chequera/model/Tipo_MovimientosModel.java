/**
 * 
 */
package com.gfi.chequera.model;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 04/04/2018
 */
public class Tipo_MovimientosModel {
	private int idTipoMovimiento;
	private String tmDescripcion;
	public Tipo_MovimientosModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tipo_MovimientosModel(int idTipoMovimiento, String tmDescripcion) {
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
	@Override
	public String toString() {
		return "Tipo_MovimientosModel [idTipoMovimiento=" + idTipoMovimiento + ", tmDescripcion=" + tmDescripcion + "]";
	}
}
