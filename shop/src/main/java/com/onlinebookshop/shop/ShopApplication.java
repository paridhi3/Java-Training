package com.onlinebookshop.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.onlinebookshop.shop.model.Author;
import com.onlinebookshop.shop.model.Book;
import com.onlinebookshop.shop.model.Order;
import com.onlinebookshop.shop.service.AuthorService;
import com.onlinebookshop.shop.service.BookService;
import com.onlinebookshop.shop.service.OrderService;

@SpringBootApplication
//@EnableAspectJAutoProxy
public class ShopApplication{ //implements CommandLineRunner{
	
//	@Autowired
//	private BookService bookService;
//	@Autowired
//	private AuthorService authorService;
//	@Autowired
//	private OrderService os;
//	
//	@Autowired
//	private Book book1;
//	@Autowired
//	private Book book2;
//	
//	@Autowired
//	private Author author1;
//	@Autowired
//	private Author author2;
//	
//	@Autowired
//	private Order order1;
//	@Autowired
//	private Order order2;
	

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		
//		Book book1=new Book(3,"New Book JDBC",300.00,1);
//	Book book2=new Book(4,"New Book JDBC 2",310.00,2);
//		
//		bookService.addBook(book1);
//		bookService.addBook(book2);
//		System.out.println("Books added successfully");
////		
////		List<Book> books=bookService.getAllBooks();
////		System.out.println("--------Books list-------------");
////		books.forEach(book->
////		           System.out.println("Book ID : "+book.getId()+" , Title : "+book.getTitle()+" , Price : "+book.getPrice())
////				);
////		
////		int bookId = 1;
////		Book foundBook=bookService.getBookById(bookId);
////		
////		foundBook.setPrice(1000.00);
////		bookService.updateBook(foundBook);
////		
////		int bookId2=9;
////		bookService.deleteBookById(bookId2);
////		
////		bookService.getAllBooks().forEach(book->
////        System.out.println("Book ID : "+book.getId()+" , Title : "+book.getTitle()+" , Price : "+book.getPrice())
////		);
//		
////		
////        Author author1 = new Author(1, "Author One", "Country A");
////        Author author2 = new Author(2, "Author Two", "Country B");
//
//        authorService.addAuthor(author1);
//        authorService.addAuthor(author2);
//        System.out.println("Authors added successfully");
//
//        List<Author> authors = authorService.getAllAuthors();
//        System.out.println("--------Authors list-------------");
//        authors.forEach(author ->
//                System.out.println("Author ID: " + author.getId() + ", Name: " + author.getName() + ", Country: " + author.getCountry())
//        );
//
//        int authorId = 1;
//        Author foundAuthor = authorService.getAuthorById(authorId);
//
//        foundAuthor.setCountry("Updated Country");
//        authorService.updateAuthor(foundAuthor);
//        System.out.println("author with id : "+authorId+" updated");
//
//        int authorId2 = 3;
//        authorService.deleteById(authorId2);
//        System.out.println("author with id : "+authorId2+" deleted");
//
//        authorService.getAllAuthors().forEach(author ->
//        System.out.println("Author ID: " + author.getId() + ", Name: " + author.getName() + ", Country: " + author.getCountry())
//);
//		
////		Order order1= new Order(1,1,4);
////		Order order2 = new Order(2, 3,4);
////		
////		
////		os.addOrder(order1);
////		os.addOrder(order2);
////		
////		System.out.println("Order Added Successfully..");
////		System.out.println("------------- Orders -----------..");
//        
//     // get all orders
////     		List<Order> orders = os.getAllOrders();
////     		System.out.println("Orders list");
////     		orders.forEach(order -> System.out.println(order));
////     		// get order by id
////     		int order_id=1;
////     		Order foundOrder = os.getOrderById(order_id);
////     		System.out.println(foundOrder);
////     		// update order details
////     		foundOrder.setQuantity(5);
////     		os.updateOrder(foundOrder);
////     		System.out.println("New quantity for order with id "+foundOrder.getId()+" is "+foundOrder.getQuantity());
////     		// delete order
////     		int OrderID=3;
////     		os.deleteOrderById(OrderID);
////     		// fetch updated order list
////     		os.getAllOrders().forEach(order -> System.out.println(order));
//		
//	}

}
