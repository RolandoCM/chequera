/**
 * 
 */
package com.gfi.chequera.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Rolando Castillo
 *
 */
@Component
public class ReadFile {
	private StringBuffer text;
	private static final Logger LOG = Logger.getLogger(ReadFile.class);
	public ReadFile() {
		super();
		this.text = new StringBuffer();
	}
	/*retorna el texto en string que contiene el objeto InputStreams*/
	public String read(InputStream input) {
		try {
			int data = input.read();
			while(data!=-1) {	
				text.append((char)data);
				data = input.read();
			}
			LOG.info("InputStrem de archivo a String exitoso");
		} catch (IOException e) {
			LOG.error("Ocurrio un error en convertir el InputStrem");
			e.printStackTrace();
		}
		return text.toString();
	}

}
