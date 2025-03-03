package com.onlinebookshop.shop.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.onlinebookshop.shop.model.Author;
import com.onlinebookshop.shop.model.Book;

@Repository
public class BookRepository {
	
	private final JdbcTemplate jdbcTemplate;

	public BookRepository(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//rowmapper for author
	private RowMapper<Book> authorRowMapper = (rs,rowNum)->
	        new Book(rs.getInt("id"),rs.getString("title"), rs.getDouble("price") ,rs.getInt("author_id"));
	        
	public int save(Book book) {
		String sql = "insert into books (title, author_id, price) values (?,?,?)";
		return jdbcTemplate.update(sql, book.getTitle(), book.getAuthorId(), book.getPrice());
		
	}
	
//	insert into books (title, author_id, price) values
//    ("Spring framework",1,350.00),
//    ("Microservices",2,450.00);
	
	public List<Book> findAll(){
		String sql = "Select * from books";
		return jdbcTemplate.query(sql, authorRowMapper);
	}
	
	public Book findById(int id) {
		String sql="Select * from books where id=?";
		return jdbcTemplate.queryForObject(sql, authorRowMapper, id);
		
	}
	
	public int update(Book book) {
		String sql="update books set title=?, price=? where id=?";
		return jdbcTemplate.update(sql,book.getTitle(),book.getPrice(),book.getId());
	}
	
	public int delete(int id) {
		String sql = "delete from books where id=?";
		return jdbcTemplate.update(sql,id);
	}

}
