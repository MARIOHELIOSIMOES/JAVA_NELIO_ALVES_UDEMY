package model.exceptions;

public class WithDrawException extends Exception{
	public static final String LIMIT_EXCEPTION = "The amount exceeds withdraw limit";
	public static final String NOT_ENOUGH_EXCEPTION = "Not enough balance";
	
	public WithDrawException(String mensagem) {
		super(mensagem);
	}
}
