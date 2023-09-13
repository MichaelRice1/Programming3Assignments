
/**
 * 
 * @author Michael Rice - 20347541
 * - Order class used to store details on orders.
 * - Attributes are : String for order item and int for order Number
 *
 */
public class Order {

	private int orderNumber;
	private String order;
	
	/**
	 * - Blank constructor
	 */
	public Order ()
	{
		
	}
	/**
	 * 
	 * @param orderNumber, int type
	 * @param order - order item, String type
	 */
	public Order(int orderNumber,String order) {
		
		this.orderNumber = orderNumber;
		this.order = order;
	}
	
	/**
	 * 
	 * @return order contents of a given item
	 */
	public int getOrderNumber() {
		return orderNumber;
	}
	
	/**
	 * 
	 * @return order contents of a given item.
	 */
	public String getOrder() {
		return order;
	}

}
