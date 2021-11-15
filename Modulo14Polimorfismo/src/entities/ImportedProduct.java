package entities;

public class ImportedProduct extends Product {

	private double CustomFee;
	
	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, double customFee) {
		super(name, price);
		CustomFee = customFee;
	}

	public double getCustomFee() {
		return CustomFee;
	}

	public void setCustomFee(double customFee) {
		CustomFee = customFee;
	}
	
	@Override
	public String priceTag() {
		return name+" $ "+String.format("%.2f", totalPrice()) + "(Customs Fee : " + String.format("%.2f", getCustomFee())+")";
	}
	
	public Double totalPrice() {
		return price + CustomFee;
	}
}
