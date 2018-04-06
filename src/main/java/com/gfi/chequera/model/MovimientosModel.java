/**
 * 
 */
package com.gfi.chequera.model;

import org.joda.time.DateTime;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 04/04/2018
 */
public class MovimientosModel {
	private int idMovimiento;
	private DateTime mFecha;
	private float mMonto;
	private String mStatus;
	private String mConcepto;
	
	private ChequeraModel chequera;
	private Tipo_MovimientosModel tipo_movimiento;
	public MovimientosModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovimientosModel(int idMovimiento, DateTime mFecha, float mMonto, String mStatus, String mConcepto,
			ChequeraModel chequera, Tipo_MovimientosModel tipo_movimiento) {
		super();
		this.idMovimiento = idMovimiento;
		this.mFecha = mFecha;
		this.mMonto = mMonto;
		this.mStatus = mStatus;
		this.mConcepto = mConcepto;
		this.chequera = chequera;
		this.tipo_movimiento = tipo_movimiento;
	}
	public int getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public DateTime getmFecha() {
		return mFecha;
	}
	public void setmFecha(DateTime mFecha) {
		this.mFecha = mFecha;
	}
	public float getmMonto() {
		return mMonto;
	}
	public void setmMonto(float mMonto) {
		this.mMonto = mMonto;
	}
	public String getmStatus() {
		return mStatus;
	}
	public void setmStatus(String mStatus) {
		this.mStatus = mStatus;
	}
	public String getmConcepto() {
		return mConcepto;
	}
	public void setmConcepto(String mConcepto) {
		this.mConcepto = mConcepto;
	}
	public ChequeraModel getChequera() {
		return chequera;
	}
	public void setChequera(ChequeraModel chequera) {
		this.chequera = chequera;
	}
	public Tipo_MovimientosModel getTipo_movimiento() {
		return tipo_movimiento;
	}
	public void setTipo_movimiento(Tipo_MovimientosModel tipo_movimiento) {
		this.tipo_movimiento = tipo_movimiento;
	}
	@Override
	public String toString() {
		return "MovimientosModel [idMovimiento=" + idMovimiento + ", mFecha=" + mFecha + ", mMonto=" + mMonto
				+ ", mStatus=" + mStatus + ", mConcepto=" + mConcepto + ", chequera=" + chequera + ", tipo_movimiento="
				+ tipo_movimiento + "]";
	}
}
