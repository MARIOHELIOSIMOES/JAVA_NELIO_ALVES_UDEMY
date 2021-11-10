package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus status;
	private List<OrderItem> items = new ArrayList<OrderItem>();
	private Client client;
	private static SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy hh:mm:ss");
	
	
	public Order() {
		
	}
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	public Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void addItem(OrderItem item) {
		items.add(item);
	}
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	public Double total() {
		double sum=0.0;
		for(OrderItem item: items) {
			sum+=item.subTotal();
		}
		return sum;
	}
	@Override
	public String toString() {
		StringBuilder sc = new StringBuilder();
		sc.append("ORDER SUMMARY\n");
		sc.append("Order Moment: ");
		sc.append(sdf.format(moment)+"\n");
		sc.append("Order Status: ");
		sc.append(status+"\n");
		sc.append("Client: ");
		sc.append(client+"\n");
		sc.append("Order items\n");
		for(OrderItem item: items) {
			sc.append(item+"\n");
		}
		sc.append("Total price: ");
		sc.append(String.format("%.2f", total())+"\n");
		
		
		return sc.toString();
	}
	
	
}
