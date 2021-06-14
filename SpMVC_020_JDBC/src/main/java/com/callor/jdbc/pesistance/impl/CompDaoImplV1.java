package com.callor.jdbc.pesistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.CompVO;
import com.callor.jdbc.pesistance.CompDao;

import lombok.extern.slf4j.Slf4j;

/*
 * @Compoent
 * 모든 Component를 대표하는 Annotation
 * 컴파일 과정에서 다소 비용이 많이 소요된다
 * CompVO c =  new ComVO()
 * Object o = new ComVO()
 * 이렇게 사용하는것과 마찬가지다
 * 
 * Component Annnotion 
 * @Controller, @Service, @Repository 이러한  Annotation을 사용한
 * Spring Container에게 이 표식이 부착된 클래스를 bean으로 생성하여 보관해달라는 지시어이다 
 * 
 * ConpServiceImplV1 cs = new ConpSerivceImplV1(); 을 사용하는게 이상적이지만
 * Compservice cs1 = new CompServiceImplV1(); 를 사용한
 * 	
 * 인터페이스를 사용하는 이유는 범용으로 다른클래스를 만들때그 틀을 가져다 사용할 수 있기때문
 * 
 * 
 */
@Slf4j
@Repository("compDaoV1")
public class CompDaoImplV1 implements CompDao {
	protected final JdbcTemplate jdbcTemplate;

	public CompDaoImplV1(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<CompVO> selectAll() {
		// TODO Auto-generated method stub

		String sql = " SELECT * FROM tbl_company ";
//		List<CompVO> compList = new ArrayList<CompVO>();
//		원래 형태는 이렇지만 Bean의 형태이기때문에 아래와 같이 사용한다 / <VO> 호환성을 위해서 붙인다 
		List<CompVO> compList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<CompVO>(CompVO.class));

		log.debug("Comp select {} " + compList.toString());
		return null;
	}

	@Override
	public CompVO findById(String pk) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_company ";
		sql += " WHERE cp_title Like '%' || ? || '%'   ";

		Object[] params = new Object[] { pk };

		CompVO vo = (CompVO) jdbcTemplate.query(sql, new BeanPropertyRowMapper<CompVO>(CompVO.class));

		return vo;
	}

	@Override
	public int insert(CompVO vo) {

		String sql = " INSERT INTO tbl_company ";
		sql += " ( cp_code , ";
		sql += " cp_title , ";
		sql += " cp_ceo , ";
		sql += " cp_addr , ";
		sql += " cp_tel )  ";
		sql += " VALUES ( ?,?,?,?,? )";

		Object[] params = new Object[] { vo.getCp_code(), vo.getCp_title(), vo.getCp_addr(), vo.getCp_tel(),
				vo.getCp_ceo() };

		return jdbcTemplate.update(sql, params);

	}

	@Override
	public int update(CompVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String cpcode) {
		// TODO 출판사 정보삭제
		String sql = " DELETE FROM tbl_company ";
		sql += " WHERE cp_code = ? ";
		/*
		 * 
		 * jdbcTemplate 을 사용하여 QUERY문을 사용할때각 method에서매개변수를 받아 QUERY 에 전달할텐데 이때 매개변수는
		 * primiteve로 받으면 값을 변환시키는 어려움이 있다 권장사항으로 매개변수는 wrapper class type 으로설정한다 즉,
		 * 숫자형일 경우 int , long 대신 Integer, Long형으로 선언한 vo에 담겨서 전달된 값은 Object[] 배열로변환한후
		 * jdbcTemplate 에 전달해주어야한다 하지만 1, 2 개 정도의 값을 전달할때 Object[] 배열로 변환후 전달하면 Object객체
		 * 저장소가 생성되고 메모리를 사용한다 이때 전달되는 변수가 Wrapper클래스타입이면 Object[] 배열로 만들지 않고 바로 주입할수 있다
		 */

//		cpcode가 String wrapper class type이므로Object[] 배열로 변환하지 않고  바로전달이 가능하다
//		Object[] params = new Object[] { cpcode };
		jdbcTemplate.update(sql, cpcode);
		return 0;
	}

	@Override
	public String findByMaxCode() {
		// TODO Auto-generated method stub
		String sql = " SELECT MAX(cp_code ) FROM tbl_company";
		String cpCode = (String) jdbcTemplate.queryForObject(sql, String.class);
		return cpCode;
	}

}
