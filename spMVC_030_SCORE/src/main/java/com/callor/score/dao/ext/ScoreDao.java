package com.callor.score.dao.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.callor.score.dao.GenericDao;
import com.callor.score.model.ScoreDTO;
import com.callor.score.model.ScoreVO;
import com.callor.score.model.SubjectAndScoreDTO;

public interface ScoreDao extends GenericDao<ScoreVO, Long> {
	
	public List<ScoreDTO> selectViewAll();
	public List<ScoreDTO> findByStnum(String st_num);
	public List<SubjectAndScoreDTO> selectSubjcetAndScore(String st_num);

	/*
	 * mybatis 에서 sql select 의 결과가 숫자일 경우 , resulttype으로 wrapper class를 지정한다 int :
	 * Integer, long : Long 문자열일경우 :resulttype 을 string 형을 반드시지정한다 String : String
	 * 
	 * 그리고 Dao method 의 return type도 wrapper class type 으로 지정
	 */
	public Integer scoreCount(String st_num);

	public Integer scoreSum(String st_num);
	/*
	 * mybatis mehtod , mapper에서 사용할 변수가 2개 이상일 경우는 각각 변수에 @param("변수명")을 반드시 명시해야한다
	 * 변수가 1개만 있을 경우는 변수이름이 달라도 괜찮다
	 */
//	#{st_num},#{sc_sbcode},#{sc_score}
	
	public Integer insertOrUpdate(@Param("st_num") String st_num, 
									@Param("sc_sbcode") String sc_sbcode,
									@Param("sc_score") String sc_score);




}
