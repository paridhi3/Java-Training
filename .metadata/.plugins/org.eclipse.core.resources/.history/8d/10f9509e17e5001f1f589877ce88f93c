package collections;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
//import java.util.PriorityQueue;
import java.util.Queue;
//import java.util.HashSet;
//import java.util.LinkedHashSet;
//import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.Scanner;
//import java.util.Vector;
//import java.util.TreeSet;
import java.util.TreeMap;

public class shoppingCart {
	
//	private LinkedList<product> cart = new LinkedList<>();
//	private Vector<product> cart = new Vector<>();
//	private LinkedHashSet<product> cart = new LinkedHashSet<>();
//	private TreeSet<product> cart = new TreeSet<>(new comparingCategoryPrice());
//	private Queue<product> cart = new PriorityQueue<>();
	private Queue<product> cart = new ArrayDeque<>();
	private Map<Integer, product> cart2 = new TreeMap<>();
	
	private static Scanner sc = new Scanner(System.in);
//	private TreeSet<product> cart;
	
//	public void sortingCart() {
//		System.out.println("How would you like to compare? 1->catPrice, 2->namePrice, 3->catID: ");
//		int res = sc.nextInt();
//		
//		switch(res) {
//		case 1:
//			cart = new TreeSet<>(new comparingCategoryPrice());
//			break;
//		case 2:
//			cart = new TreeSet<>(new comparingNamePrice());
//			break;
//		case 3:
//			cart = new TreeSet<>(new comparingCategoryID());
//			break;
//		default:
//			System.out.println("Invalid choice");
//		}
//	}
	
	public void addProd() {
		System.out.println("Enter product ID: ");
		int prodID = sc.nextInt();
		
		System.out.println("Enter product name: ");
		String prodName = sc.next();
		
		System.out.println("Enter product price: ");
		double prodPrice = sc.nextDouble();
		
		System.out.println("Enter product category (electronics, groceries, apparel, footwear): ");
		String prodCategory = sc.next();
		
		//add -> add() method is associated with array list
		product newProd = new product(prodID, prodName, prodPrice, prodCategory);
//		cart.add(newProd);
		cart2.put(prodID, newProd);
		System.out.println("Product name: "+prodName+" is added to cart");
	}
	
//	public void removeProd() {
//		System.out.println("Enter product ID: ");
//		int id = sc.nextInt();
//		
//		// true: product present, else not present
//		boolean removed = cart.removeIf(product -> product.prodID == id); // concise way of writing smaller fn
//		
//		if(removed==true) {
//			System.out.println("Product ID: "+id+" is removed from cart");
//		}
//		else {
//			System.out.println("Product ID: "+id+" not found");
//		}
//	}
	
	public void removeProd() {
	
	System.out.print("Enter Product ID to remove product: ");
		int pId = sc.nextInt();
		if(cart2.remove(pId) != null) {
			System.out.println("CART 2 Hash Map product removed");
		}
		else {
			System.out.println("CART 2 Hash Map product not found");
		}
 
	}
	
	public void searchProd() {
		System.out.println("Enter product name: ");
		String name = sc.next();
		
//		for(product prod:cart) {
//			if(prod.prodName.equalsIgnoreCase(name)) { // will find first occurrence
//				System.out.println("Product name: "+name+" found");
//				return;
//			}
		
		for(product prod:cart2.values()) {
			if(prod.prodName.equalsIgnoreCase(name)) { // will find first occurrence
				System.out.println("Product name: "+name+" found");
				return;
			}
		}
		
		System.out.println("Product name: "+name+" not found");
	}
	
	public double discount() {
		double discount = 0;
		for(product prod:cart) {
			if(prod.prodCategory.equals("e")) {
				discount = 0.1;
			}
			else if(prod.prodCategory.equals("gr")) {
				discount = 0.2;
			}
		}
		return discount;
	}
	
	public void checkout() {
		double totalBill = 0;
//		
//		for(product prod:cart) {
//			totalBill += prod.prodPrice - prod.prodPrice*discount(); 
//		}
//		
//		System.out.println("Total price to be paid: Rs "+totalBill);
//		cart.clear();
//		System.out.println("Checkout complete. Cart is empty.");

    	
//    	while(!cart.isEmpty()) {
//    		
//    		product prod = cart.poll(); // trying to process highest priority queue element
//    		System.out.println(prod);
//    		totalBill += prod.prodPrice - prod.prodPrice*discount();
//    		
//    	}
    	
		for(product prod:cart2.values()) {
		totalBill += prod.prodPrice - prod.prodPrice*discount(); 
	}
    	
    	System.out.println("Total Price to be paid : INR "+ totalBill);
    	cart.clear();
    	System.out.println("Checkout Complete. Cart is empty. ");
		
	}
	
	public void display() {
		if(cart2.isEmpty()) {
			System.out.println("Cart is empty.");
		}
		else {
			for(product prod:cart2.values()) {
//				System.out.println("---------------------------------------------"); 
//				System.out.println("Product ID: "+prod.prodID); 
//				System.out.println("Product name: "+prod.prodName);
//				System.out.println("Product price before discount: "+prod.prodPrice); 
//				System.out.println("Discount: -" + prod.prodPrice*discount()); 
//				System.out.println("Product price after discount: "+ (prod.prodPrice - prod.prodPrice*discount())); 
//				System.out.println("Product category: "+prod.prodCategory); 
//				System.out.println("---------------------------------------------"); 
				System.out.println(prod);
			}
		}
	}
	
	public void menu() {
		while(true) {
			System.out.println("---------------------------------------------"); 
			System.out.println("Shopping Menu");
			System.out.println("Press 1: To add product");
			System.out.println("Press 2: To remove product");
			System.out.println("Press 3: Search product");
			System.out.println("Press 4: Checkout");
			System.out.println("Press 5: Display");
			System.out.println("Press 6: Exit");
			System.out.println("---------------------------------------------"); 
			
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				addProd();
				break;
			case 2:
				removeProd();
				break;
			case 3:
				searchProd();
				break;
			case 4:
				checkout();
				break;
			case 5:
				display();
				break;
			case 6:
				System.out.println("Thank you");
				sc.close();
				return;
			default:
				System.out.println("Invalid choice");
			}
		}
	}
	
	
	public static void main(String[] args) {
		shoppingCart cart = new shoppingCart();
//		cart.sortingCart();
		cart.menu();
		
	}
}
