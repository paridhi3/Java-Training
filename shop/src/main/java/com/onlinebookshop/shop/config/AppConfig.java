package com.onlinebookshop.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.onlinebookshop.shop.model.Author;
import com.onlinebookshop.shop.model.Book;
import com.onlinebookshop.shop.model.Order;

@Configuration
public class AppConfig {
	
	@Bean
	public Book book1() {
		return new Book(1, "Spring boot in action",29.99,1);
	}
	
	@Bean
	public Book book2() {
		return new Book(2, "Microservices with spring boot",34.99,3);
	}
	
	@Bean
	public Author author1() {
		return new Author(1,"Craig walls","USA");
	}
	
	@Bean
	public Author author2() {
		return new Author(2,"John doe", "UK");
	}
	
	//Order order1= new Order(1,1,4);
//	Order order2 = new Order(2, 3,4);
	
	@Bean
	public Order order1() {
		return new Order(1,1,7);
	}
	
	@Bean
	public Order order2() {
		return new Order(1,3,8);
	}
	

}
