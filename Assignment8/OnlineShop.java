import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


/**
 * 
 * @author Michael Rice - 20347541
 * - OnlineShop class, mainly used for testing the webAssistant and warehouseCollector classes/threads.
 * - Has two LinkedBlockingQueue objects to process orders.
 */
public class OnlineShop {
	

	static LinkedBlockingQueue<Order> lbq1 = new LinkedBlockingQueue<Order>();	
	static LinkedBlockingQueue<Order> lbq2 = new LinkedBlockingQueue<Order>();


	
	/**
	 * Constructor, takes no arguments.
	 */
	public OnlineShop() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * 
	 * @param args
	 * - Main method, instantiates the 4 queues required for testing.
	 * - Calls the readOrder method.
	 * - Starts the 2 assistant threads, then a delay, then starts the two collector threads.
	 */
	public static void main(String[] args)
	{
		WebAssistant assistantKirsty = new WebAssistant("Kirsty");
		Thread Kirsty = new Thread(assistantKirsty);
		WebAssistant assistantPhil = new WebAssistant("Phil");
		Thread Phil = new Thread(new WebAssistant("Phil"));
		WarehouseCollector collectorTristan = new WarehouseCollector("Tristan");
		Thread Tristan = new Thread(collectorTristan);
		WarehouseCollector collectorWillow = new WarehouseCollector("Willow");
		Thread Willow = new Thread(collectorWillow);

		
		readOrder();

		Phil.start();
		Kirsty.start();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Tristan.start();
		Willow.start();
	}
	
	
	/**
	 * - Method to read in the order objects from the provided txt file.
	 * - Uses a BufferedReader wrapped around a FileReader to read in initially.
	 * - While the next line is not null, the reader keeps reading.
	 * - Uses a scanner and scan.nextInt() and scan.nextLine() to separate order number and order item.
	 * - Assigns these to variables and then creates an order object from these variables.
	 * - Stores this order object in the first LinkedBlockingQueue.
	 * - Catches the necessary exceptions.
	 */
	public static void readOrder()
	{
		try {
			BufferedReader orderReader = new BufferedReader(new FileReader("orderList.txt"));
			String line = null;
			while((line = orderReader.readLine()) != null )
			{	
				int orderNo;
				String orderItem;
				Scanner scan = new Scanner(line);
				orderNo = scan.nextInt();
				orderItem = scan.nextLine();
				Order order = new Order(orderNo,orderItem);
				lbq1.add(order);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
