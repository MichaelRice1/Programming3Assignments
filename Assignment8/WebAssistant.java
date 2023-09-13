
/**
 * 
 * @author Michael Rice - 20347541
 * - WebAssistant class, extends Thread functionality
 * - takes a LinkedBlockingQueue object from the OnlineShop class.
 * - While a peek into the queue isn't null, processing is done using the run method.
 * - Has an assistantName String attribute and a tally variable to tally how much work each thread does.
 *
 */
public class WebAssistant extends Thread{
	
	OnlineShop os = new OnlineShop();
	private String assistantName;
	int tally,mug,hoodie,tshirt;
	
	
	/**
	 * 
	 * @param name
	 * - Constructor, takes a String as a parameter.
	 * - Assigned to the assistantName variable.
	 */
	public WebAssistant(String name) {
		// TODO Auto-generated constructor stub
		assistantName = name;
	}
	
	
	
	/**
	 * - run method, this is what takes place when a thread is started.
	 * - While a peek into the LinkedBlockingQueue isn't null, the processing is done.
	 * - If the order number is 1, a delay is introduced so that order 1 is not processed twice.
	 * - Else, the order is taken from the LinkedBlockingQueue and processed.
	 * - The tally variable is then incremented.
	 * - A random delay is then introduced. 
	 * - When the while loop has terminated, the stats for each thread is printed.
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

		while(os.lbq1.peek() != null) {
			if(os.lbq1.peek().getOrderNumber()==1)
			{
				delay();
			}
				
			if(os.lbq1.peek().getOrder().contains("Mug"))
			{
				mug++;
			}
			else if(os.lbq1.peek().getOrder().contains("Hoodie"))
			{
				hoodie++;
			}
			else
			{
				tshirt++;
			}
				System.out.printf("\nAssistant %s is receiving order number %d for a %s.",assistantName,os.lbq1.peek().getOrderNumber(),os.lbq1.peek().getOrder());
				tally++;
				os.lbq2.add(os.lbq1.peek());
				os.lbq1.poll();
				delay();
				
			}
		
		System.out.printf("\n\n%s received %d orders including %d mugs,%d hoodies and %d tshirts.\n",assistantName,tally,mug,hoodie,tshirt);
		}
	
	
	/**
	 * - Delay method.
	 * - Calculates a random integer, multiplies it by 2000.
	 * - Sleeps the current thread by this randomly calculated integer.
	 */
	public void delay()
	{
		try {
			Thread.sleep((int)(Math.random()*2000));
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
	}

}
