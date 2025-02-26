package com.onlinebookshop.shop.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.onlinebookshop.shop.model.Book;

@Repository
public class BookRepository {
    private final JdbcTemplate jdbcTemplate;

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for book
    private RowMapper<Book> bookRowMapper = (rs, rowNum) ->
        new Book(rs.getInt("id"), rs.getString("title"), rs.getDouble("price"), rs.getInt("author_id"));

    // CRUD operations

    // Create -> Insert query
    public int save(Book book) {
        String query = "INSERT INTO books (title, author_id, price) VALUES (?, ?, ?)";
        return jdbcTemplate.update(query, book.getTitle(), book.getAuthor_id(), book.getPrice());
    }

    // Read (get all books)
    public List<Book> findAll() {
        String query = "SELECT * FROM books"; // map result set to list of java objects
        return jdbcTemplate.query(query, bookRowMapper);
    }

    // Read (book by id)
    public Book findById(int id) {
        String query = "SELECT * FROM books WHERE id = ?"; // map result set to list of java objects
        return jdbcTemplate.queryForObject(query, bookRowMapper, id);
    }

    // Update book (return number of rows affected -> int)
    public int update(Book book) {
        String query = "UPDATE books SET title=?, author_id=?, price=? WHERE id=?";
        return jdbcTemplate.update(query, book.getTitle(), book.getAuthor_id(), book.getPrice(), book.getId());
    }

    // Delete book (return number of rows affected -> int)
    public int delete(int id) {
        String query = "DELETE FROM books WHERE id=?";
        return jdbcTemplate.update(query, id);
    }
}
