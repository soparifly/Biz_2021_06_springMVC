package com.callor.jdbc.pesistance.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.AuthorVO;
import com.callor.jdbc.pesistance.AuthorDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class AuthorDaoImplV1 implements AuthorDao {
	/*
	 * 일반적인 String Framework에서 다른 bean을 연결하기
	 * 
	 * @Autowired 이미 bean으로 생성되어 Spring Conteiner에 보관중인 객체를 여기에 주입해달라라는 의미
	 * 
	 * final 을 넣고 생성자를 만들어서 this.jdbc를 선언하는 다른 방법
	 * 
	 * @Inject 를사용하는 방법이 있다 Java에서 기본적으로 제공하는DI(dependcy Inject)를 수행하는 Annotion
	 * 일부에서 @Inject를 사용하자라는 말이 있지만 SpringFramework를 사용할때는 굳이 그러지말자 , 너무 오래된버젼이라 간혹
	 * 문제를 일으킴 일각에서는 스프링의 기본기능 이라고 하지만 그렇진않다라고 한다
	 * 
	 * 
	 */

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Override
	public List<AuthorVO> selectAll() {
		// TODO Auto-generated method stub

		String sql = " SELECT  * FROM tbl_author ";

		List<AuthorVO> author = jdbcTemplate.query(sql, new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));

		return author;
	}

	@Override
	public AuthorVO findById(String cu_code) {
		// TODO Auto-generated method stub
		String sql = " SELECT  * FROM tbl_author ";
		sql += " WHERE au_code = ? ";
		AuthorVO author = (AuthorVO) jdbcTemplate.query(sql, new Object[] { cu_code },
				new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));

		return author;
	}

	@Override
	public int insert(AuthorVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(AuthorVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AuthorVO> findByAName(String aname) {
		// TODO Auto-generated method stub
		String sql = " SELECT  * FROM tbl_author ";
		sql += " WHERE au_name LIKE CONCAT ('%', ? , '%')";
		List<AuthorVO> author = jdbcTemplate.query(sql, new Object[] { aname },
				new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));

		return author;
	}

	@Override
	public List<AuthorVO> findByATel(String atel) {
		// TODO Auto-generated method stub
/*
 * 전화번호로 조회를 하면 1개의 데이터만 추출될 것이다하지만 DB조회에서 PK를 기준으로 조회하는 경우를 제외하고는모두 List type으로 데이터가 추출된다고 생각해야한다 
 */
			String sql = " SELECT  * FROM tbl_author ";
			sql += " WHERE au_tel LIKE CONCAT ('%', ? , '%')";
			List<AuthorVO> author =jdbcTemplate.query(sql, new Object[] { atel },
					new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));

			return author;
	}

}
