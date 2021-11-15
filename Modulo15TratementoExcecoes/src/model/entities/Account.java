package model.entities;

import model.exceptions.WithDrawException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withDrawLimit;
	public Account(Integer number, String holder, Double balance, Double withDrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withDrawLimit = withDrawLimit;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	public Double getBalance() {
		return balance;
	}
	public Double getWithDrawLimit() {
		return withDrawLimit;
	}
	public void setWithDrawLimit(Double withDrawLimit) {
		this.withDrawLimit = withDrawLimit;
	}
	public void deposit(Double amount) {
		this.balance+=amount;
	}
	public void withDraw(Double ammount) throws WithDrawException {
		if(ammount> withDrawLimit) {
			throw new WithDrawException (WithDrawException.LIMIT_EXCEPTION);
		}
		if(ammount> balance) {
			throw new WithDrawException(WithDrawException.NOT_ENOUGH_EXCEPTION);
		}
		balance-=ammount;
	}
	
	
	
	

}
