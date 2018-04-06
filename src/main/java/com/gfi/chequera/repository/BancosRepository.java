/**
 * 
 */
package com.gfi.chequera.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfi.chequera.entity.Bancos;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 04/04/2018
 */
@Repository("BancosRepository")
public interface BancosRepository extends JpaRepository<Bancos, Serializable> {
	public Bancos findByIdBancos(int idBancos );
}
