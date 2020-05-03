package com.mkdev.rest.v1.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Muthukumar Thangavinayagam
 * @date 2020-May-02 5:50:04 pm
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DnResourceNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new Resource not found exception.
	 *
	 * @param message the message
	 */
	public DnResourceNotFoundException(String message) {
		super(message);
	}

}
