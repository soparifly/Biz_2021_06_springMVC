package com.callor.jdbc.pesistance.impl;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.BookVO;
import com.callor.jdbc.pesistance.BookDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("bookDaoV1") // 컴포넌트로 사용하는 어노테이션 이이름으로 사용하겠다 라는 의미 html의 id이름과 기능이 유사하다
public class BookDaoImplV1 implements BookDao {
//	private static Logger log = LoggerFactory.getLogger("SERVICE");
//  메번 사용하기 임포트를 두개나 선택해줘야하기때문에 롬복을 사용해서 
//	어노테이션을 붙여주고 사용해준다 

	// TODO jtbc-context.xml에 선언된 jdbcTemplat bean 사용하기
	protected JdbcTemplate jdbcTemplate;

	public BookDaoImplV1(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<BookVO> selectAll() {

		String sql = " SELECT ";
		sql += "bk_isbn,";
		sql += "bk_title AS bk_ccode, ";
		sql += "bk_comp AS bk_ccode ,";
		sql += "bk_acode,";
		sql += "bk_date,";
		sql += "bk_price,";
		sql += "bk_pages,";
		sql += " * FROM tbl_books B";
		sql += " LEFT JOIN tbl_author A";
		sql += " ON B.bk_author = A.au_code ";
		sql += " LEFT JOIN tbl_comp C "
				+ " ON B.bk_ccode = C.cp_code";
		// ResultSet 으로 while문을 이용해 rSet에 데이터를 담을때 사용했던 방법
		List<BookVO> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<BookVO>(BookVO.class));
		log.debug("SELECT {} ", books.toString());
		return books;
	}

	@Override
	public BookVO findById(String pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BookVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BookVO bookVO) {
		// TODO Auto-generated method stub
		String sql = " INSERT INTO tbl_books  ( ";
		sql += "bk_isbn,";
		sql += "bk_title,";
		sql += "bk_ccode,";
		sql += "bk_acoder,";
		sql += "bk_date,";
		sql += "bk_price,";
		sql += "bk_pages )";
		sql += " VALUES ( ?,?,?,?,?,?,? ) ";

		Object[] params = new Object[] { bookVO.getBk_isbn(), bookVO.getBk_title(), bookVO.getBk_ccode(),
				bookVO.getBk_acode(), bookVO.getBk_date(), bookVO.getBk_price(), bookVO.getBk_pages() };
		return jdbcTemplate.update(sql, params);
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BookVO> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> findByDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> findByComp(String comp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> findByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

}
