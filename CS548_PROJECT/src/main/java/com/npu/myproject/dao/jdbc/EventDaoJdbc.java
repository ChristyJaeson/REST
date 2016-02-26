package com.npu.myproject.dao.jdbc;

import java.util.List;
import java.util.logging.Logger;

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

import com.mysql.jdbc.log.Log;
import com.npu.myproject.dao.EventDao;
import com.npu.myproject.domain.Deal;
import com.npu.myproject.domain.Event;
import com.npu.myproject.domain.Location;

@Repository("eventDaoJdbc")
public class EventDaoJdbc implements EventDao {
	@Autowired
	@Qualifier("dataSource")
	private javax.sql.DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate dbTemplate;
	private SimpleJdbcInsert jdbcInsert;
	private EventRowMapper eventRowMapper;
	
	@PostConstruct
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		dbTemplate = new NamedParameterJdbcTemplate(dataSource);
		eventRowMapper = new EventRowMapper();
		jdbcInsert = new SimpleJdbcInsert(dataSource)
		               .withTableName("events")
		               .usingGeneratedKeyColumns("id")
		               .usingColumns("EVENTNAME","EVENTTYPE","EVENTAREA","EVENTDATE",
		            		   			"DURATION","LOCATION_ID","eventPRICE","eventCAPACITY");
		
	}
	

	@Override
	public List<Event> selectEvents(String eventArea,String location) {		
		String sql = "SELECT * FROM events where eventArea like ? and LOCATION_ID in "
				+ "(SELECT id FROM location where city like ? )";
		List<Event> eventList = jdbcTemplate.query(sql, eventRowMapper,"%"+eventArea+"%","%"+location+"%");
		//System.out.println(eventList);
		return eventList;
		
	}
	@Override
	public Event selectEventById(Integer id) {
		String sql = "SELECT * FROM events WHERE id =?";
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		Event event =  jdbcTemplate.queryForObject(sql, eventRowMapper,id);
		return event;
	}
	@Override
	public Event selectEventByName(String eventName) {
		String sql = "SELECT * FROM events WHERE eventName =?";
		MapSqlParameterSource params = new MapSqlParameterSource("id", eventName);
		Event event =  jdbcTemplate.queryForObject(sql, eventRowMapper,eventName);
		return event;
	}
	@Override
	public void insertEvent(Event event){
		SqlParameterSource params = new BeanPropertySqlParameterSource(event);
	    Number newId = jdbcInsert.executeAndReturnKey(params);
	    event.setId(newId.intValue());	    
	}
	@Override
	public List<Event> selectEventsByUser(String user_id){
		//bug fix
		return null;
	}
	

}
