package com.stackroute.movieapp1.exceptions;

@SuppressWarnings("serial")
public class MovieAlreadyExistsException extends Exception{
	
	public MovieAlreadyExistsException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public MovieAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public MovieAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public MovieAlreadyExistsException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public MovieAlreadyExistsException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
}
