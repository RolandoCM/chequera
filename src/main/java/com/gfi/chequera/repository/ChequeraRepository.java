/**
 * 
 */
package com.gfi.chequera.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gfi.chequera.entity.Chequera;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 05/04/2018
 */
public interface ChequeraRepository extends  JpaRepository<Chequera, Serializable>{
	public Chequera findByIdChequera(int idChequera);
}
