package com.gfi.chequera.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfi.chequera.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Serializable>{
	public abstract User findByMail(String mail);
}
