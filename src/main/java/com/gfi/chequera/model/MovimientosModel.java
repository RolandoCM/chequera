/**
 * 
 */
package com.gfi.chequera.model;

import java.time.LocalDateTime;


/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 04/04/2018
 */
public class MovimientosModel {
	private int idMovimiento;
	private String mFecha;
	private float mMonto;
	private String mStatus;
	private String mConcepto;
	private int idChequera;
	
	private ChequeraModel chequera;
	private Tipo_MovimientosModel tipoMovimiento;
	public MovimientosModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovimientosModel(int idMovimiento, String mFecha, float mMonto, String mStatus, String mConcepto,
			ChequeraModel chequera, Tipo_MovimientosModel tipoMovimiento) {
		super();
		this.idMovimiento = idMovimiento;
		this.mFecha = mFecha;
		this.mMonto = mMonto;
		this.mStatus = mStatus;
		this.mConcepto = mConcepto;
		this.chequera = chequera;
		this.tipoMovimiento = tipoMovimiento;
	}
	public int getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public String getmFecha() {
		return mFecha;
	}
	public void setmFecha(String mFecha) {
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
	
	public Tipo_MovimientosModel getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(Tipo_MovimientosModel tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	
	public int getIdChequera() {
		return idChequera;
	}
	public void setIdChequera(int idChequera) {
		this.idChequera = idChequera;
	}
	@Override
	public String toString() {
		return "MovimientosModel [idMovimiento=" + idMovimiento + ", mFecha=" + mFecha + ", mMonto=" + mMonto
				+ ", mStatus=" + mStatus + ", mConcepto=" + mConcepto + ", chequera=" + chequera + ", tipo_movimiento="
				+ tipoMovimiento + "]";
	}
}
