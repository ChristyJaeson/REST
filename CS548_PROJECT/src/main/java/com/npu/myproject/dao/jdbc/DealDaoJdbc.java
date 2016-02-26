package com.npu.myproject.dao.jdbc;

import java.util.List;

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

import com.npu.myproject.dao.DealDao;
import com.npu.myproject.domain.Deal;




@Repository("dealDaoJdbc")
public class DealDaoJdbc implements DealDao {

	@Autowired
	@Qualifier("dataSource")
	private javax.sql.DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate dbTemplate;
	private SimpleJdbcInsert jdbcInsert;
	private DealRowMapper dealRowMapper;
	
	@PostConstruct
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		dbTemplate = new NamedParameterJdbcTemplate(dataSource);
		dealRowMapper = new DealRowMapper();
		jdbcInsert = new SimpleJdbcInsert(dataSource)
		               .withTableName("deals")
		               .usingGeneratedKeyColumns("deal_id")
		               .usingColumns("ID","LOCATION_CODE", "PRICE", "DISCOUNT","EVENT","DATES","PLACE");
		
	}

	public List<Deal> selectDeals() {
		System.out.println("Inside select Deals -- jdbc ----44444");
		String sql = 
		        "SELECT * FROM deals";
				//BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(deal);
		
				List<Deal> dealList = jdbcTemplate.query(sql,  dealRowMapper);
				System.out.println("from dao: "+dealList);
		return dealList;
		
	}

	public Deal findDealById(int id) {
		String sql = "SELECT * FROM deals WHERE deal_id =?";
		MapSqlParameterSource params = new MapSqlParameterSource("deal_id", id);
		Deal deals =  jdbcTemplate.queryForObject(sql,  dealRowMapper,id);
		return deals;
	}
	public void insertDeal(Deal deal) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(deal);
	    Number newId = jdbcInsert.execute(params);
	    deal.setId(newId.intValue());   
	    
	}
	public int updatebyPlace(int id, String newplace) {
		String sql = "update deals set PLACE= ? where id= ?";
		int i;
		
		i= jdbcTemplate.update(sql,newplace, id);
		return i;	
	}
    public int delete(int id) {
		String sql = "DELETE from deals where id= ?";
		int i;
		i=jdbcTemplate.update(sql, id);
		return i;
	}	
    public List<Deal> selectDealsByType(String str) {
		System.out.println("selectDealsByType::"+str);
		String sql = 
		        "SELECT * FROM deals WHERE event like '%"+str+"%'" ;//like concat(concat('%',event),'%')";
				//BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(deal);
		
				List<Deal> dealList = jdbcTemplate.query(sql,  dealRowMapper);
				System.out.println("from dao: "+dealList);
		return dealList;
		
	}

}
