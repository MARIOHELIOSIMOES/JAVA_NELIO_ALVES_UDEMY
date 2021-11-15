package model.service;

public class PayPalService implements OnlinePaymentService {

	@Override
	public Double paymentFee(Double amount) {
		return amount * 0.02;
	}

	@Override
	public Double interest(Double amount, Integer mounths) {
		return amount * (0.01 * mounths);
	}

}
