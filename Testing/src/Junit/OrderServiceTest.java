package Junit;
 
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
 
class OrderServiceTest {
	
	OrderService os;

    @BeforeAll
    static void initAll() {
        System.out.println("Starting OrderService Tests");
    }

    @BeforeEach
    void init() {
        os = new OrderService();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test completed");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("All tests completed");
    }
 
	@Test
    void testPlaceOrderInsufficientStock() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            os.placeOrder(15);
        });
        assertEquals("Insufficient stock", e.getMessage());
    }
	
	@Test
    void testPlaceOrderSufficientStock() {
        boolean result = os.placeOrder(5);
        assertTrue(result);
        assertEquals(5, os.getStock());
    }
 
    @Test
    void testCalPrice() {
        double price = 100.0;
        int quantity = 2;
        double expected = price * quantity * (1 - os.getDiscount());
        assertEquals(expected, os.calPrice(price, quantity));
    }
    
    // boundary
    @Test
    void testCalPrice2() {
        double price = 100.0;
        int quantity = 0;
        double expected = price * quantity * (1 - os.getDiscount());
        assertEquals(expected, os.calPrice(price, quantity));
    }
	
	@ParameterizedTest
    @CsvSource({
        "100.0, 2, 180.0",
        "150.0, 3, 405.0",  
        "200.0, 1, 180.0",  
        "50.0, 4, 180.0"    
    })    
    void testCalPriceParamCsv(double price, int quantity, double expected) {
        assertEquals(expected, os.calPrice(price, quantity));
	}
	
	
	@Test
	void testTimeout() {
		assertTimeout(java.time.Duration.ofMillis(1000),()->{
			Thread.sleep(500);
		});
	}
	
	@Test
    void testPlaceOrderMultithreadTest() throws InterruptedException {
        Thread t1 = new Thread(() -> os.placeOrder(2));
        Thread t2 = new Thread(() -> os.placeOrder(1));
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        assertEquals(7, os.getStock());
    }
	
	 @Disabled
	 @Test
	 void testDisabled() {
		 System.out.println();
	 }
    
}

