package model.service;

public interface OnlinePaymentService {
	public Double paymentFee(Double amount);
	public Double interest(Double amount, Integer mounths);
}
