package Junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class OrderService2TestThread {
	private OrderService2 os2;
		
	@BeforeEach
	public void setup() {
		os2 = new OrderService2();
	}
	
	@Test
	public void testPlaceOrderMultithread() throws InterruptedException {
		int threadCount = 10;
		ExecutorService es = Executors.newFixedThreadPool(threadCount);
		CountDownLatch latch = new CountDownLatch(threadCount);
		
		for(int i=0; i<threadCount; i++) {
			es.execute(() -> {
				try {
					os2.placeOrder(1);
				}
				catch(Exception e) {System.out.println(e.getMessage());}
				latch.countDown();
			});
//			latch.countDown();
		}
		
		latch.await(); // wait for all threads to finish
		es.shutdown();
		
		assertEquals(0, os2.getStock());
		
	}
	
//	@Test
//	public void testPlaceOrderMultiThread() throws InterruptedException {
//		
//		int threadCount = 10;
//		ExecutorService executor = Executors.newFixedThreadPool(threadCount);
//		CountDownLatch latch = new CountDownLatch(threadCount);
//		
//		for (int i=0 ; i<threadCount; i++) {  // i=0  i<10 , i=0 to 9
//			executor.execute(() -> {
//				try {
//					os2.placeOrder(1);
//				}catch (Exception e) {System.out.println(e.getMessage());} // non crtitical task
//			});
//			latch.countDown(); //
//		}
//		latch.await(); // wait for all threads to finish
//		executor.shutdown();
//		
//		// initial stock as 10
//		// concurrently 10 threads are running -> placeorder -> 1 quan each -> final stock -> 0
//		
//		assertEquals(0, os2.getStock());
//		
//		
//	}
	
}
