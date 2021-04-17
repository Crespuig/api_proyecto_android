package com.proyecto.android.api.exceptions;

public class MonumentNotFoundException extends RuntimeException {

	public MonumentNotFoundException(int id) {
		super("Could not find monument " + id);
	}
	
}
