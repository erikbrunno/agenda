package br.com.agenda.validacao;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class NegocioException extends RuntimeException {

    public NegocioException(String message) {
	super(message);
    }

    @JsonIgnore
    @Override
    public StackTraceElement[] getStackTrace() {
	// TODO Auto-generated method stub
	return super.getStackTrace();
    }

    @JsonIgnore
    @Override
    public String getMessage() {
	// TODO Auto-generated method stub
	return super.getMessage();
    }

    @JsonIgnore
    @Override
    public synchronized Throwable getCause() {
	// TODO Auto-generated method stub
	return super.getCause();
    }

    @JsonIgnore
    @Override
    public String getLocalizedMessage() {
	// TODO Auto-generated method stub
	return super.getLocalizedMessage();
    }
}
