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
@Table(name="clientes")
public class Clientes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCliente;
	private String cNombre;
	private String cDireccion;
	private String cRfc;
	private String cRazon;
	private String cCorreo;
	private boolean cStatus;
	
	@OneToMany(fetch= FetchType.EAGER, mappedBy="cliente")
	private Set<Chequera> chequera = new HashSet<>();

	public Clientes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Clientes(int idCliente, String cNombre, String cDireccion, String cRfc, String cRazon, String cCorreo,
			boolean cStatus) {
		super();
		this.idCliente = idCliente;
		this.cNombre = cNombre;
		this.cDireccion = cDireccion;
		this.cRfc = cRfc;
		this.cRazon = cRazon;
		this.cCorreo = cCorreo;
		this.cStatus = cStatus;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getcNombre() {
		return cNombre;
	}
	public void setcNombre(String cNombre) {
		this.cNombre = cNombre;
	}
	public String getcDireccion() {
		return cDireccion;
	}
	public void setcDireccion(String cDireccion) {
		this.cDireccion = cDireccion;
	}
	public String getcRfc() {
		return cRfc;
	}
	public void setcRfc(String cRfc) {
		this.cRfc = cRfc;
	}
	public String getcRazon() {
		return cRazon;
	}
	public void setcRazon(String cRazon) {
		this.cRazon = cRazon;
	}
	public String getcCorreo() {
		return cCorreo;
	}
	public void setcCorreo(String cCorreo) {
		this.cCorreo = cCorreo;
	}
	public boolean iscStatus() {
		return cStatus;
	}
	public void setcStatus(boolean cStatus) {
		this.cStatus = cStatus;
	}
	public Set<Chequera> getChequera() {
		return chequera;
	}

	public void setChequera(Set<Chequera> chequera) {
		this.chequera = chequera;
	}
	
	
}
