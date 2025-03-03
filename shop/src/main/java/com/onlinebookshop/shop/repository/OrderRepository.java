package com.onlinebookshop.shop.repository;
 
import java.util.List;
 
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.onlinebookshop.shop.model.Order;

@Repository
public class OrderRepository {
    private final JdbcTemplate jdbcTemplate;
 
    public OrderRepository(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    // Create Row Mapper for Order Class..
    private RowMapper<Order> orderRowMapper = (rs, rowNum) -> new Order(rs.getInt("id"), rs.getInt("book_id"), rs.getInt("quantity"), rs.getTimestamp("order_date"));
    
    // CRUD Operations
    // Create -> Insert Query
    public int save(Order order) {
        String query = "INSERT into orders(book_id, quantity) VALUES(?, ?)";
        return jdbcTemplate.update(query, order.getBookId(), order.getQuantity());
    }
    // Read -> Get all orders
    public List<Order> listOrders() {
        String query = "SELECT * FROM orders";
        return jdbcTemplate.query(query, orderRowMapper);
    }
 
    // Get order by id
    public Order findById(int id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, orderRowMapper, id);
    }
    // Update Order
    public int update(Order order) {
        String sql = "UPDATE orders SET book_id = ?, quantity = ?, order_date = ? WHERE id = ?";
        return jdbcTemplate.update(sql, order.getBookId(), order.getQuantity(), order.getOrderDate(), order.getId());
    }
 
    // Delete Order
    public int delete(int id) {
        String sql = "DELETE FROM orders WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }   
}