package com.onlinebookshop.shop.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.onlinebookshop.shop.model.Author;

@Repository
public class AuthorRepository {
	
	private final JdbcTemplate jdbcTemplate;

	public AuthorRepository(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//rowmapper for author
	private RowMapper<Author> authorRowMapper = (rs,rowNum)->
	        new Author(rs.getInt("id"),rs.getString("name"),rs.getString("country"));
	        
	public int save(Author author) {
		String sql = "insert into authors (name,country) values (?,?)";
		return jdbcTemplate.update(sql, author.getName(), author.getCountry());
		
	}
	
	public List<Author> findAll(){
		String sql = "Select * from authors";
		return jdbcTemplate.query(sql, authorRowMapper);
	}
	
	public Author findById(int id) {
		String sql="Select * from authors where id=?";
		return jdbcTemplate.queryForObject(sql, authorRowMapper, id);
		
	}
	
	public int update(Author author) {
		String sql="update authors set name=?, country=? where id=?";
		return jdbcTemplate.update(sql,author.getName(),author.getCountry(),author.getId());
	}
	
	public int delete(int id) {
		String sql = "delete from authors where id=?";
		return jdbcTemplate.update(sql,id);
	}

}
