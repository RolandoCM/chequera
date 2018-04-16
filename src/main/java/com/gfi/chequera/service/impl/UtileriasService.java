/**
 * 
 */
package com.gfi.chequera.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfi.chequera.model.BancosModel;
import com.gfi.chequera.model.ClientesModel;
import com.gfi.chequera.service.IUtileriasService;
import com.gfi.chequera.utils.ReadFile;

/**
 * @author rolando
 *
 */
@Service
public class UtileriasService implements IUtileriasService{
	private final static Logger LOG = Logger.getLogger(UtileriasService.class);
	@Autowired
	private ChequeraService chequeraService;
	@Autowired
	private BancosService bancosService;
	@Autowired
	private ClientesService clientesService;
	@Autowired
	private MovimientosService movimientoService;
	@Autowired
	private ReadFile readFile;
	@Override
	public void limpiarBancos() {
		bancosService.deleteAllBancos();
		LOG.info("Se ha limpiado correctamente la tabla banco");
		
	}
	@Override
	public void limpiarClientes() {
		clientesService.deleteAllClientes();
	}
	@Override
	public void limpiarChequeras() {
		chequeraService.deleteAllChequera();
	}
	@Override
	public void cargarBancos(InputStream input) {
		String text = readFile.read(input);
		List<BancosModel> bancosModel = new ArrayList<>();
		String [] textBancos = text.split("\n");
		
		for(int i=0;i<textBancos.length;i++)
		{
			BancosModel banco = new BancosModel();
			String [] campos = textBancos[i].split(",");
			banco.setbDireccion(campos[0]);
			banco.setbNombre(campos[1]);
			banco.setbStatus(true);
			banco.setbSucursal(campos[3]);
			banco.setbTelefono(campos[4]);
			bancosModel.add(banco);
		}
		bancosService.carga(bancosModel);
		LOG.info("texto: "+text);
	}
	@Override
	public void limpiarMovimientos() {
		movimientoService.deleteAllMovimientos();
	}
	@Override
	public void cargaClientes(InputStream input) {
		String text = readFile.read(input);
		List<ClientesModel> clientesModel = new ArrayList<>();
		String [] textClientes = text.split("\n");
		for(int i=0; i<textClientes.length; i++) {
			ClientesModel cliente = new ClientesModel();
			String [] campos = textClientes[i].split(",");
			cliente.setcCorreo(campos[0]);
			cliente.setcDireccion(campos[1]);
			cliente.setcNombre(campos[2]);
			cliente.setcRazon(campos[3]);
			cliente.setcRfc(campos[4]);
			cliente.setcStatus(true);
			clientesModel.add(cliente);
		}
		clientesService.cargaClientes(clientesModel);
		LOG.info("texto: "+text);
	}
	
}
