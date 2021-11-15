package model.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, Integer months) {
	//	this.contract = contract;
		double baseValue = contract.getTotalValue() / months;
		
		for(int i = 1; i<=months; i++) {
			double amount = baseValue + onlinePaymentService.interest(baseValue, i);
			amount+= onlinePaymentService.paymentFee(amount);
			
			Date t1 = contract.getDateInitial();
			//        
			Date t2 = addMonth(t1, i);
			Installment installment = new Installment(t2, amount);
			contract.addInstallment(installment);
		}
	}
	private Date addMonth(Date data, int months) {
		Calendar c = new GregorianCalendar();
		c.setTime(data);
		c.add(Calendar.MONTH, months);
		return new Date(c.getTimeInMillis());
	}
	
}
