package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 * 
 */
public class OrderReceipt {
    private Order order;
	private static final double TAX_RATE = 0.10;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();

		output.append("======Printing Orders======\n");
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

		double totalSalesTax = 0d;
		double totalAmount = 0d;
		for (LineItem lineItem : order.getLineItems()) {
			output.append(lineItem.getDescription()).append('\t');
			output.append(lineItem.getPrice()).append('\t');
			output.append(lineItem.getQuantity()).append('\t');
			output.append(lineItem.totalAmount()).append('\n');

            double salesTax = lineItem.totalAmount() * TAX_RATE;
            totalSalesTax += salesTax;

            totalAmount += lineItem.totalAmount() + salesTax;
		}

		output.append("Sales Tax").append('\t').append(totalSalesTax);
		output.append("Total Amount").append('\t').append(totalAmount);
		return output.toString();
	}
}