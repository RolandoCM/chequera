/**
 * 
 */
package com.gfi.chequera.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfi.chequera.converter.ClientesConverter;
import com.gfi.chequera.entity.Clientes;
import com.gfi.chequera.model.ClientesModel;
import com.gfi.chequera.model.MailModel;
import com.gfi.chequera.repository.ClientesRepository;
import com.gfi.chequera.service.IClientesService;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 05/04/2018
 */
@Service("ClientesService")
public class ClientesService implements IClientesService{
	@Autowired
	private ClientesConverter clienteConverter;
	@Autowired
	private ClientesRepository clienteRepository;
	@Autowired
	private SendMailService sendMailService;
	
	private Clientes cliente;
	private ClientesModel clienteModel;
	private final static Logger LOG = Logger.getLogger(ClientesService.class);
	
	/*Retorna una lista de todos los clientes encontrados en la base de datos*/
	@Override
	public List<ClientesModel> listClientes() {
		List<Clientes> clientes = clienteRepository.findAll();
		List<ClientesModel> clientesModel = new ArrayList<>();
		for(Clientes cliente : clientes) 
			clientesModel.add(clienteConverter.clientesToModel(cliente));
		return clientesModel;
	}

	@Override
	public void saveCliente(ClientesModel clienteModel) {
		cliente = clienteConverter.clientesToEntity(clienteModel);
		clienteRepository.save(cliente);
		MailModel mail = new MailModel();
		
		mail.setFrom("no-reply@memorynotfound.com");
		mail.setTo(cliente.getcCorreo());
		mail.setSubject("Datos de cliente");
		mail.setContent("registro correcto");
		try {
			sendMailService.sendMailMessage(mail);
		} catch (MessagingException e) {
			LOG.error("Error en el envio del correo", e);
			e.printStackTrace();
		}
	}
	@Override
	public boolean deleteCliente(int idCliente) {
		cliente = clienteRepository.findByIdCliente(idCliente);
		cliente.setcStatus(false);
		clienteRepository.save(cliente);
		return false;
	}

	@Override
	public ClientesModel searchCliente(int idCliente) {
		cliente = clienteRepository.findByIdCliente(idCliente);
		clienteModel = clienteConverter.clientesToModel(cliente);
		return clienteModel;
	}

	@Override
	public void deleteAllClientes() {
		clienteRepository.deleteAll();
		LOG.info("Se ha limpiado la table de Clientes satisfactoriamente");
		
	}

	@Override
	public void cargaClientes(List<ClientesModel> clientesModel) {
		List<Clientes> clientes = new ArrayList<>();
		for(ClientesModel clienteModel : clientesModel) 
			clientes.add(clienteConverter.clientesToEntity(clienteModel));
		clienteRepository.save(clientes);
		LOG.info("Se guardo lista de entidades clientes satisfactoriamente");
	}

}
