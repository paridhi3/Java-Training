package com.onlinebookshop.shop.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.onlinebookshop.shop.*")
public class ShopAppConfig {

    @Bean
    public Book book() {
        Book book = new Book();
        book.setTitle("The Great Gatsby");
        book.setPrice(499.99);
        book.setAuthor_id(1);
        return book;
    }

    @Bean
    public Author author() {
        Author author = new Author();
        author.setName("F. Scott Fitzgerald");
        author.setCountry("United States");
        return author;
    }

    @Bean
    public Order order() {
        Order order = new Order();
        order.setBookId(1);
        order.setQuantity(2);
        return order;
    }
}
