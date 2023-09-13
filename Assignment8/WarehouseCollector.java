
/**
 * 
 * @author Michael Rice - 20347541
 * - WarehouseCollector class, extends Thread functionality
 * - takes a LinkedBlockingQueue object from the OnlineShop class, containing the processed orders from WebAssistant.
 * - While a peek into the queue isn't null, processing is done using the run method.
 * - Has a collectorName String attributea and and an instance of the OnlineShop class.
 *
 */
public class WarehouseCollector extends Thread {

	OnlineShop os = new OnlineShop();
	int tally,mug,hoodie,tshirt;
	int emptyPeeks = 0;
	
	String collectorName;
	//LinkedBlockingQueue<Order> lbq2 = new LinkedBlockingQueue<Order>();
	
	
	/**
	 * 
	 * @param collectorName
	 * - Constructor, takes a String as a parameter.
	 * - This is then linked to the collectorName variable.
	 */
	public WarehouseCollector(String collectorName ) {
		// TODO Auto-generated constructor stub
		this.collectorName = collectorName;
	}

	
	/**
	 * - Run method, takes place when thread is started.
	 * - While a peek into the second queue is not null, the processing is done.
	 * - Again, if the order Number is 1, a delay is introduced so that it isn't processed by the 2 threads.
	 * - Otherwise, the collector processed the order and removes it from the queue.
	 * - When the threads are finished, the stats for each thread are printed out.
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

		while(emptyPeeks<10)
		{
			if(os.lbq2.peek() == null)
			{
				emptyPeeks++;
				delay();
			}
			else
			{
				while(os.lbq2.peek() != null)
				{
					Order o = new Order();
					o = os.lbq2.peek();
					if(o.getOrderNumber() == 1)
						delay();
					
					if(o.getOrder().contains("Mug"))
					{
						mug++;
					}
					else if(o.getOrder().contains("Hoodie"))
					{
						hoodie++;
					}
					else
						tshirt++;
			    	System.out.printf("\nCollector %s is processing order %d for a %s for delivery.",collectorName,os.lbq2.peek().getOrderNumber(),os.lbq2.peek().getOrder());
			    	tally++;
			    	os.lbq2.remove();
			    	delay();
				}
			}
		}				
		System.out.printf("\n\n%s processed %d orders including %d mugs,%d hoodies and %d tshirts.",collectorName,tally,mug,hoodie,tshirt);
		}
		   
		
	
	
	/**
	 * - Delay method.
	 * - Calculates a random integer, multiplies it by 2000.
	 * - Sleeps the current thread by this randomly calculated integer.
	 */
	public int delay() {
		int delay = 0;
		try {
			delay = (int) (Math.random() * 2000);
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return delay;
	}

}
