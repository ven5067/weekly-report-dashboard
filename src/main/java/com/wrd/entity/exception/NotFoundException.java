package com.wrd.entity.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFoundException(String msg) {
		super(msg);
	} 
}
