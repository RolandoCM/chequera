/**
 * 
 */
package com.gfi.chequera.repository;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gfi.chequera.entity.Chequera;
import com.gfi.chequera.entity.Movimientos;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 05/04/2018
 */
public interface MovimientosRepository extends JpaRepository<Movimientos, Serializable>{
	List<Movimientos> findByMFechaAfterAndMFechaBeforeAndChequeraEquals(LocalDateTime fechaInicio, LocalDateTime fechaCorte, Chequera chequera);
}
