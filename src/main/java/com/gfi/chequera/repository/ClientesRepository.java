/**
 * 
 */
package com.gfi.chequera.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gfi.chequera.entity.Clientes;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 05/04/2018
 */
public interface ClientesRepository extends JpaRepository<Clientes, Serializable>{
	public Clientes findByIdCliente (int idCliente);
}
