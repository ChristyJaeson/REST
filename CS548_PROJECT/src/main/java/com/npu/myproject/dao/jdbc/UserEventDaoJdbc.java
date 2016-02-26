package com.npu.myproject.dao.jdbc;

import java.util.List;
import java.util.Map;
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
import com.npu.myproject.dao.UserDao;
import com.npu.myproject.dao.UserEventDao;
import com.npu.myproject.domain.Deal;
import com.npu.myproject.domain.Event;
import com.npu.myproject.domain.User;
import com.npu.myproject.domain.UserEvent;

@Repository("userEventDaoJdbc")
public class UserEventDaoJdbc implements UserEventDao {
	@Autowired
	@Qualifier("dataSource")
	private javax.sql.DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate dbTemplate;
	private SimpleJdbcInsert jdbcInsert;
	private UserEventRowMapper userEventRowMapper;
	
	@PostConstruct
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		dbTemplate = new NamedParameterJdbcTemplate(dataSource);
		userEventRowMapper = new UserEventRowMapper();
		jdbcInsert = new SimpleJdbcInsert(dataSource)
		               .withTableName("user_event")
		               .usingGeneratedKeyColumns("id")
		               .usingColumns("user_id" ,"event_id" );
		
	}
	

	@Override
	public List<User> selectUsersByEvent(Integer id) {		
		String sql = "SELECT * FROM user where user_id in "
				+ "(select user_id from user_event where event_id = ?)";
		List<User> userList = jdbcTemplate.query(sql, new UserRowMapper(),id);
		//System.out.println(eventList);
		return userList;
		
	}
	@Override
	public List<Event> selectEventsByUser(Integer id) {
		System.out.println("in sql run"+id);
		String sql = "SELECT * FROM events WHERE id in  "
				+ "(select event_id from user_event where user_id = ?)";
		List<Event> eventList =  jdbcTemplate.query(sql, new EventRowMapper(),id);
		System.out.println("Done."+eventList.size());
	    return eventList;
	}

	@Override
	public UserEvent insertUser(UserEvent ue) {
		
		String sql = "select * from events where id = "+ue.getEvent_id();
		List<Event> e=jdbcTemplate.query(sql, new EventRowMapper());
		if(e.get(0).getEventCapacity()<=0){
			return null;
		}
		updateAvailability( ue);
		SqlParameterSource params = new BeanPropertySqlParameterSource(ue);
	    Number newId = jdbcInsert.executeAndReturnKey(params);
	    ue.setId(newId.intValue());	
	    
	    return ue;
	}
	public void updateAvailability(UserEvent ue) {
		String sql = "UPDATE events SET "
				+ " eventcapacity= eventcapacity-1 "
				+ " WHERE id =  "+ue.getEvent_id();
		jdbcTemplate.update(sql);
	}


	@Override
	public void updateUserEvent(UserEvent ue) {
		String sql = "UPDATE user_event SET "
				+ " deal_id= "+ue.getDeal_id()
				+ " WHERE user_id =  "+ue.getUser_id();
		jdbcTemplate.update(sql);
		
	}
	
	@Override
	public int getDealPercent(int user_id){
		String sql = "SELECT discount FROM deals WHERE deal_id=(select distinct deal_id from user_event where user_id= "+user_id+")";
		int i =  jdbcTemplate.queryForObject(sql, Integer.class);
		return i;
	}
	

}
