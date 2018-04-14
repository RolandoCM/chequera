/**
 * 
 */
package com.gfi.chequera.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 */
@Entity
@Table(name="bancos")
public class Bancos{
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idBancos;
	private String bDireccion;
	private String bSucursal;
	private String bNombre;
	private String bTelefono;
	private boolean bStatus;
	@OneToMany(fetch=FetchType.EAGER, mappedBy="banco")
	private Set<Chequera> chequera = new HashSet<>();
	
	public Bancos() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Bancos(int idBancos, String bDireccion, String bSucursal, String bNombre, String bTelefono, boolean bStatus,
			Set<Chequera> chequera) {
		super();
		this.idBancos = idBancos;
		this.bDireccion = bDireccion;
		this.bSucursal = bSucursal;
		this.bNombre = bNombre;
		this.bTelefono = bTelefono;
		this.bStatus = bStatus;
		this.chequera = chequera;
	}
	

	public int getIdBancos() {
		return idBancos;
	}


	public void setIdBancos(int idBancos) {
		this.idBancos = idBancos;
	}


	public String getbDireccion() {
		return bDireccion;
	}


	public void setbDireccion(String bDireccion) {
		this.bDireccion = bDireccion;
	}


	public String getbSucursal() {
		return bSucursal;
	}


	public void setbSucursal(String bSucursal) {
		this.bSucursal = bSucursal;
	}


	public String getbNombre() {
		return bNombre;
	}


	public void setbNombre(String bNombre) {
		this.bNombre = bNombre;
	}


	public String getbTelefono() {
		return bTelefono;
	}


	public void setbTelefono(String bTelefono) {
		this.bTelefono = bTelefono;
	}


	public boolean isbStatus() {
		return bStatus;
	}


	public void setbStatus(boolean bStatus) {
		this.bStatus = bStatus;
	}


	public Set<Chequera> getChequera() {
		return chequera;
	}

	public void setChequera(Set<Chequera> chequera) {
		this.chequera = chequera;
	}
	
	
	
}
