package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date moment;
	private OrderStatus order;
	private Client client;
	private List<OrderItem> items = new ArrayList<OrderItem>();
	
	public Order() {
		
	}
	
	public Order(Date moment, OrderStatus order, Client client) {
		this.moment = moment;
		this.order = order;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getOrder() {
		return order;
	}

	public void setOrder(OrderStatus order) {
		this.order = order;
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
	
	public double total() {
		double sum = 0.0;
		for (OrderItem item : items) {
			sum += item.subTotal();
		}
		return sum;
	}
	
	@Override
	public String toString() {
		 StringBuilder sb = new StringBuilder();
		 sb.append("Order moment: ");
		 sb.append(sdf.format(moment) + "\n");
		 sb.append("Order Status:");
		 sb.append(order + "\n");
		 sb.append("Client: ");
		 sb.append(client + "\n");
		 sb.append("Order items: \n");
		 for(OrderItem item : items) {
			sb.append(item + "\n");
			
		 }
		 sb.append("Total price: /n");
		 sb.append(String.format("%.2f", total()));
		 return sb.toString();
	}
	
	
	
}