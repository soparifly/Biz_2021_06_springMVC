package com.callor.jdbc.pesistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.UserVO;
import com.callor.jdbc.pesistance.UserDao;

@Repository
public class UserDaoImplV1 implements UserDao{
	// 생성자에서 주입받을수 있는 객체는 
//	 @Component로 선언된 클래스만 가능하
	protected final JdbcTemplate jdbcTemplate;
	public UserDaoImplV1(JdbcTemplate jdbcTemplate) {
		
		this.jdbcTemplate=jdbcTemplate;
	
	}
	@Override
	public List<UserVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO findById(String pk) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_bmember ";
		sql += " WHERE b_username like '%' || ? || '%' ";
				
				Object [] param = new Object[] { pk };
		
		UserVO vo = (UserVO) jdbcTemplate.query(sql,  new BeanPropertyRowMapper<UserVO>(UserVO.class));
		
		return null;
	}

	@Override
	public int insert(UserVO vo) {
		String sql= " INSERT INTO tbl_member( username, password ) ";
		sql += " VALUES (?, ?) ";
		
		
		return jdbcTemplate.update(sql, vo.getUsername(), vo.getPassword());
	}

	@Override
	public int update(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

}
