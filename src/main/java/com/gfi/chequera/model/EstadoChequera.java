/**
 * 
 */
package com.gfi.chequera.model;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 11/04/2018
 */
public class EstadoChequera {
	private String concepto;
	private String fecha;
	private String tipoMovimiento;
	
	public EstadoChequera() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EstadoChequera(String concepto, String fecha, String tipoMovimiento) {
		super();
		this.concepto = concepto;
		this.fecha = fecha;
		this.tipoMovimiento = tipoMovimiento;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	@Override
	public String toString() {
		return "EstadoChequera [concepto=" + concepto + ", fecha=" + fecha + ", tipoMovimiento=" + tipoMovimiento + "]";
	}
	
}
