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
import com.npu.myproject.dao.UserDao;
import com.npu.myproject.domain.User;

@Repository("userDaoJdbc")
public class UserDaoJdbc implements UserDao {
	@Autowired
	@Qualifier("dataSource")
	private javax.sql.DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate dbTemplate;
	private SimpleJdbcInsert jdbcInsert;
	private UserRowMapper userRowMapper;
	
	@PostConstruct
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		dbTemplate = new NamedParameterJdbcTemplate(dataSource);
		userRowMapper = new UserRowMapper();
		jdbcInsert = new SimpleJdbcInsert(dataSource)
		               .withTableName("user")
		               .usingGeneratedKeyColumns("id")
		               .usingColumns("username" ,"password" ,
		            		   "first_name" ,"last_name" ,
		            		   "gender" ,"birthdate" );
		
	}
	

	@Override
	public List<User> selectUsers() {		
		String sql = "SELECT * FROM user";
		List<User> userList = jdbcTemplate.query(sql, userRowMapper);
		//System.out.println(eventList);
		return userList;
		
	}
	@Override
	public User validateUser(String username,String password) {
		String sql = "SELECT * FROM user WHERE username =? and password=?";
		User user =  jdbcTemplate.queryForObject(sql, userRowMapper,username,password);
		return user;
	}
	@Override
	public User selectUserById(Integer user_id) {
		String sql = "SELECT * FROM user WHERE user_id =?";
		MapSqlParameterSource params = new MapSqlParameterSource("user_id", user_id);
		User user =  jdbcTemplate.queryForObject(sql, userRowMapper,user_id);
		return user;
	}
	@Override
	public List<User> selectUserByEventId(Integer event_id) {
		String sql = "SELECT * FROM user WHERE user_id in "
				+ "(select user_id from user_event where event_id = ? )";
		//MapSqlParameterSource params = new MapSqlParameterSource("event_id", event_id);
		List<User> userList=jdbcTemplate.query( sql, userRowMapper, event_id);
		return userList;
	}
	@Override
	public User insertUser(User user){
		SqlParameterSource params = new BeanPropertySqlParameterSource(user);
	    Number newId = jdbcInsert.executeAndReturnKey(params);
	    user.setId(newId.intValue());	
	    return user;
	}
	@Override
	public void updateUser(User user){
		String sql = "UPDATE user SET "
				+ " first_name= '"+user.getFirst_name()+"' ,"
				+ " last_name= '"+user.getLast_name()+"' ,"
				+ " gender= '"+user.getGender()+"' ,"
				+ " birthdate= '"+user.getBirthdate()+"' "
				+ " WHERE user_id =  '"+user.getId()+"' ";
		jdbcTemplate.update(sql);
		//return user;   
	}
	

}
