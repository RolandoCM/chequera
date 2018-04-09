/**
 * 
 */
package com.gfi.chequera.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 */
public class ChequeraModel {
	private int idChequera;
	private String chFecha;
	private String chClaveInterbancaria;
	private String chNumCuenta;
	private String chSaldo;
	private String chAbonos;
	private String chCargos;
	private boolean chStatus;
	private String chFechaCorte;
	private int idBanco;
	private int idCliente;
	
	private BancosModel banco;
	private ClientesModel cliente;
	private Set<MovimientosModel> movimientos = new HashSet<>();
	public ChequeraModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChequeraModel(int idChequera, String chFecha, String chClaveInterbancaria, String chNumCuenta,
			String chSaldo, String chAbonos, String chCargos, boolean chStatus, String chFechaCorte, BancosModel banco,
			ClientesModel cliente) {
		super();
		this.idChequera = idChequera;
		this.chFecha = chFecha;
		this.chClaveInterbancaria = chClaveInterbancaria;
		this.chNumCuenta = chNumCuenta;
		this.chSaldo = chSaldo;
		this.chAbonos = chAbonos;
		this.chCargos = chCargos;
		this.chStatus = chStatus;
		this.chFechaCorte = chFechaCorte;
		this.banco = banco;
		this.cliente = cliente;
	}
	public int getIdChequera() {
		return idChequera;
	}
	public void setIdChequera(int idChequera) {
		this.idChequera = idChequera;
	}
	public String getChFecha() {
		return chFecha;
	}
	public void setChFecha(String chFecha) {
		this.chFecha = chFecha;
	}
	public String getChClaveInterbancaria() {
		return chClaveInterbancaria;
	}
	public void setChClaveInterbancaria(String chClaveInterbancaria) {
		this.chClaveInterbancaria = chClaveInterbancaria;
	}
	public String getChNumCuenta() {
		return chNumCuenta;
	}
	public void setChNumCuenta(String chNumCuenta) {
		this.chNumCuenta = chNumCuenta;
	}
	public String getChSaldo() {
		return chSaldo;
	}
	public void setChSaldo(String chSaldo) {
		this.chSaldo = chSaldo;
	}
	public String getChAbonos() {
		return chAbonos;
	}
	public void setChAbonos(String chAbonos) {
		this.chAbonos = chAbonos;
	}
	public String getChCargos() {
		return chCargos;
	}
	public void setChCargos(String chCargos) {
		this.chCargos = chCargos;
	}
	public boolean isChStatus() {
		return chStatus;
	}
	public void setChStatus(boolean chStatus) {
		this.chStatus = chStatus;
	}
	public String getChFechaCorte() {
		return chFechaCorte;
	}
	public void setChFechaCorte(String chFechaCorte) {
		this.chFechaCorte = chFechaCorte;
	}
	public BancosModel getBanco() {
		return banco;
	}
	public void setBanco(BancosModel banco) {
		this.banco = banco;
	}
	public ClientesModel getCliente() {
		return cliente;
	}
	public void setCliente(ClientesModel cliente) {
		this.cliente = cliente;
	}
	public Set<MovimientosModel> getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(Set<MovimientosModel> movimientos) {
		this.movimientos = movimientos;
	}
	
	public int getIdBanco() {
		return idBanco;
	}
	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	@Override
	public String toString() {
		return "ChequeraModel [idChequera=" + idChequera + ", chFecha=" + chFecha + ", chClaveInterbancaria="
				+ chClaveInterbancaria + ", chNumCuenta=" + chNumCuenta + ", chSaldo=" + chSaldo + ", chAbonos="
				+ chAbonos + ", chCargos=" + chCargos + ", chStatus=" + chStatus + ", chFechaCorte=" + chFechaCorte
				+ ", idBanco=" + idBanco + ", idCliente=" + idCliente + ", banco=" + banco + ", cliente=" + cliente
				+ ", movimientos=" + movimientos + "]";
	}
	
}
