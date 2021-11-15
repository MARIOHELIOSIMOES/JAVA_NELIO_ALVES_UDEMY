package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	private int number;
	private Date dateInitial;
	private Double totalValue;
	private List<Installment> installments = new ArrayList<>();
	
	
	public Contract() {
		
	}

	public Contract(int number, Date dateInitial, Double totalValue) {
		this.number = number;
		this.dateInitial = dateInitial;
		this.totalValue = totalValue;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getDateInitial() {
		return dateInitial;
	}

	public void setDateInitial(Date dateInitial) {
		this.dateInitial = dateInitial;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	public void addInstallment(Installment installment) {
		installments.add(installment);
	}

	public List<Installment> getInstallments() {
		return installments;
	}
	
}
