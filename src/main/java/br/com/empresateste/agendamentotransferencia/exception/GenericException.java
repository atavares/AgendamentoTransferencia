package br.com.empresateste.agendamentotransferencia.exception;

public class GenericException extends Exception{
		

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GenericException(String message){
		super(message);
	}
	public GenericException(Exception ex){
		super(ex);
	}
}
