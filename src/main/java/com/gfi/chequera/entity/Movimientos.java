/**
 * 
 */
package com.gfi.chequera.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 */
@Entity
@Table(name="movimientos")
public class Movimientos {
	@Id
	@GeneratedValue
	private int idMovimientos;
	private LocalDateTime mFecha;
	private float mMonto;
	private String mStatus;
	private String mConcepto;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Chequera chequera;
	@OneToOne
	private Tipo_Movimiento tipoMovimiento;
	
	public Movimientos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movimientos(int idMovimientos, LocalDateTime mFecha, float mMonto, String mStatus, String mConcepto,
			Chequera chequera, Tipo_Movimiento tipoMovimiento) {
		super();
		this.idMovimientos = idMovimientos;
		this.mFecha = mFecha;
		this.mMonto = mMonto;
		this.mStatus = mStatus;
		this.mConcepto = mConcepto;
		this.chequera = chequera;
		this.tipoMovimiento = tipoMovimiento;
	}
	public int getIdMovimientos() {
		return idMovimientos;
	}
	public void setIdMovimientos(int idMovimientos) {
		this.idMovimientos = idMovimientos;
	}
	public LocalDateTime getmFecha() {
		return mFecha;
	}
	public void setmFecha(LocalDateTime mFecha) {
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
	public Chequera getChequera() {
		return chequera;
	}
	public void setChequera(Chequera chequera) {
		this.chequera = chequera;
	}
	public Tipo_Movimiento getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(Tipo_Movimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
}
