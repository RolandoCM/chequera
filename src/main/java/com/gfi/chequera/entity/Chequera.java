/**
 * 
 */
package com.gfi.chequera.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 */
@Entity
@Table(name="chequera")
public class Chequera {
	@Id
	@GeneratedValue
	private int idChequera;
	private LocalDateTime chFecha;
	private String chClaveInterbancaria;
	private String chNumCuenta;
	private String chSaldo;
	private String chAbonos;
	private String chCargos;
	private boolean chStatus;
	private String chFechaCorte;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="b_id_bancos")
	private Bancos banco;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="b_id_cliente")
	private Clientes cliente;
	@OneToMany(fetch=FetchType.LAZY)
	private Set<Movimientos> movimientos = new HashSet<>();
	
	public Chequera() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chequera(int idChequera, LocalDateTime chFecha, String chClaveInterbancaria, String chNumCuenta, String chSaldo,
			String chAbonos, String chCargos, boolean chStatus, String chFechaCorte, Bancos banco, Clientes cliente) {
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

	public LocalDateTime getChFecha() {
		return chFecha;
	}

	public void setChFecha(LocalDateTime chFecha) {
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

	public Bancos getBanco() {
		return banco;
	}

	public void setBanco(Bancos banco) {
		this.banco = banco;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public Set<Movimientos> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(Set<Movimientos> movimientos) {
		this.movimientos = movimientos;
	}	
}
