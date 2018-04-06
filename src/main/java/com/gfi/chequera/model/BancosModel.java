package com.gfi.chequera.model;
/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 */

import java.util.HashSet;
import java.util.Set;

public class BancosModel {
	private int idBancos;
	private String bDireccion;
	private String bSucursal;
	private String bNombre;
	private String bTelefono;
	private boolean bStatus;
	
	private Set<ChequeraModel> chequeraModel = new HashSet<>();

	public BancosModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BancosModel(int idBancos, String bDireccion, String bSucursal, String bNombre, String bTelefono,
			boolean bStatus) {
		super();
		this.idBancos = idBancos;
		this.bDireccion = bDireccion;
		this.bSucursal = bSucursal;
		this.bNombre = bNombre;
		this.bTelefono = bTelefono;
		this.bStatus = bStatus;
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

	public Set<ChequeraModel> getChequeraModel() {
		return chequeraModel;
	}

	public void setChequeraModel(Set<ChequeraModel> chequeraModel) {
		this.chequeraModel = chequeraModel;
	}

	@Override
	public String toString() {
		return "BancosModel [idBancos=" + idBancos + ", bDireccion=" + bDireccion + ", bSucursal=" + bSucursal
				+ ", bNombre=" + bNombre + ", bTelefono=" + bTelefono + ", bStatus=" + bStatus + ", chequeraModel="
				+ chequeraModel + "]";
	}
}
