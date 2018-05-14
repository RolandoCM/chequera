package com.gfi.chequera.service;

import com.gfi.chequera.entity.User;

public interface IUserService {
	public abstract User getLogin(String mail, String password);
}
