package com.npu.myproject.dao.jdbc;

import java.util.List;

import javax.activation.DataSource;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.npu.myproject.dao.LocationDao;
import com.npu.myproject.domain.Deal;
import com.npu.myproject.domain.Location;



@Repository("locationDaoJdbc")

public class LocationDaoJdbc implements LocationDao {
	@Autowired
	@Qualifier("dataSource")
	private javax.sql.DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate dbTemplate;
	private SimpleJdbcInsert jdbcInsert;
	private LocationRowMapper locationRowMapper;
	
	
	
	@PostConstruct
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		dbTemplate = new NamedParameterJdbcTemplate(dataSource);
		locationRowMapper = new LocationRowMapper();
		jdbcInsert = new SimpleJdbcInsert(dataSource)
		                 .withTableName("location")
		                 .usingGeneratedKeyColumns("id")
		                 .usingColumns("code", "name", "city","country");
	}



	public Location selectById(int id) {
		String sql = "SELECT * FROM location WHERE id =?";
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		Location locations =  jdbcTemplate.queryForObject(sql, locationRowMapper,id);
		return locations;
		
	}



	public List<Location> selectAll(Location location) {
		String sql = "SELECT * FROM location";
		List<Location> locationList = jdbcTemplate.query(sql, locationRowMapper);
		return locationList;
	}



	public void insert(Location location) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(location);
	    Number newId = jdbcInsert.executeAndReturnKey(params);
	    
	    location.setId(newId.intValue());
	}

	public int updatebyCity(int id, String newcity) {
		String sql = "update location set city= ? where id= ?";
		int i;
		i=jdbcTemplate.update(sql, newcity, id);
		return i;
		
	}

	public int delete(int id) {
		String sql = "DELETE from location where id= ?";
		int j;
		j=jdbcTemplate.update(sql, id);
		return j;
	}
		
	}


