package com.valtech.carassignment.apierror;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
@ResponseBody
public class ExistException extends RuntimeException
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExistException(String exception) {
        super(exception);
    }
}


