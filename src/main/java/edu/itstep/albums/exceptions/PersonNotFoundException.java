package edu.itstep.albums.exceptions;

public class PersonNotFoundException extends RuntimeException{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersonNotFoundException(Long id) {
		super("Person with id "+ id +" wasn't found!");
	}
}
