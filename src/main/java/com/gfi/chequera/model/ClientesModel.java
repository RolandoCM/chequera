/**
 * 
 */
package com.gfi.chequera.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 04/04/2018
 */
public class ClientesModel {
	private int idCliente;
	private String cNombre;
	private String cDireccion;
	private String cRfc;
	private String cRazon;
	private String cCorreo;
	private boolean cStatus;
	private Set<ChequeraModel> chequeraModel = new HashSet<>();
	
	public ClientesModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientesModel(int idCliente, String cNombre, String cDireccion, String cRfc, String cRazon, String cCorreo,
			boolean cStatus, Set<ChequeraModel> chequeraModel) {
		super();
		this.idCliente = idCliente;
		this.cNombre = cNombre;
		this.cDireccion = cDireccion;
		this.cRfc = cRfc;
		this.cRazon = cRazon;
		this.cCorreo = cCorreo;
		this.cStatus = cStatus;
		this.chequeraModel = chequeraModel;
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

	public Set<ChequeraModel> getChequeraModel() {
		return chequeraModel;
	}

	public void setChequeraModel(Set<ChequeraModel> chequeraModel) {
		this.chequeraModel = chequeraModel;
	}

	@Override
	public String toString() {
		return "ClientesModel [idCliente=" + idCliente + ", cNombre=" + cNombre + ", cDireccion=" + cDireccion
				+ ", cRfc=" + cRfc + ", cRazon=" + cRazon + ", cCorreo=" + cCorreo + ", cStatus=" + cStatus
				+ ", chequeraModel=" + chequeraModel + "]";
	}
	
}
