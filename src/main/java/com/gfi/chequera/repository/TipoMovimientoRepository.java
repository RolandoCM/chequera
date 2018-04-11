/**
 * 
 */
package com.gfi.chequera.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfi.chequera.entity.Tipo_Movimiento;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 09/04/2018
 */
@Repository
public interface TipoMovimientoRepository extends JpaRepository<Tipo_Movimiento, Serializable> {
	public abstract Tipo_Movimiento findByIdTipoMovimiento (int idTipoMovimiento);
}
