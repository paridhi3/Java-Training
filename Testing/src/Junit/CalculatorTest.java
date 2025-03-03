package Junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

	@Test
	void testAdd() {
		Calculator calc = new Calculator();
		calc.add(5, 10);
		assertEquals(15, calc.add(5, 10));
	}

	@Test
	void testSubtract() {
		Calculator calc = new Calculator();
		calc.subtract(5, 10);
		assertEquals(-5, calc.subtract(5, 10));
	}
	
	@Test
	void testCondition() {
		Calculator calc = new Calculator();
		assertTrue(calc.add(2,9)>0);
	}
	
	@Test
	void testCondition2() {
		Calculator calc = new Calculator();
		assertFalse(calc.add(6,8)<0);
	}
	
//	@Test
//	void testNull() {
//		Calculator calc = new Calculator();
//		assertNull(calc.add(6,8));
//	}
	
	@Test
	void testNull2() {
		Calculator calc = new Calculator();
		assertNotNull(calc.add(0,0));
	}
	
	@ParameterizedTest
	@ValueSource(ints= {12,15,16,17})
	void testAddParam(int number) {
		Calculator calc = new Calculator();
		assertEquals(number+10, calc.add(number,10));
	}
	
	@ParameterizedTest
	@CsvSource ({
		"5,7,12",
		"3,6,9",
		"7,5,12",
		"8,9,17"
	})	
	void testAddParamCsv(int a, int b, int expected) {
		Calculator calc=new Calculator();
		assertEquals(expected, calc.add(a,b));
	}
	
//	@Test
//	void testTimeout() {
//		assertTimeout(java.time.Duration.ofMillis(1000),()->{
//			Calculator calc = new Calculator();
//			Thread.sleep(1500);
//			calc.add(2,3);
//		});
//	}
	
	@Test
	void testException() {
		ArithmeticException exception =assertThrows(ArithmeticException.class,()->{
			Calculator calc = new Calculator();
			calc.add(12,0);
		});
	}

}
