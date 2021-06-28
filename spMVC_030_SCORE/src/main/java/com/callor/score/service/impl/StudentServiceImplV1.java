package com.callor.score.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.callor.score.dao.ext.ScoreDao;
import com.callor.score.dao.ext.StudentDao;
import com.callor.score.dao.ext.SubjectDao;
import com.callor.score.model.ScoreInputVO;
import com.callor.score.model.StudentVO;
import com.callor.score.model.SubjectAndScoreDTO;
import com.callor.score.service.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("StudentServiceV1")
public class StudentServiceImplV1 implements StudentService {
	protected final StudentDao stDao;
	protected final ScoreDao scDao;
	protected final SubjectDao sbDao;

	@Override
	public List<StudentVO> selectAll() {
		List<StudentVO> stList = stDao.selectAll();

		log.debug("Controller {} ", stList.toString());

		return stList;
	}

	@Override
	public Map<String, Object> selectMaps() {

		List<StudentVO> stList = stDao.selectAll();
//		List<ScoreVO> scList = scDao.selectAll();
//		List<SubjectVO> sbList = sbDao.selectAll();
//		List<ScoreDTO> scViewList = scDao.selectViewAll();

		Map<String, Object> maps = new HashMap<String, Object>();

		maps.put("학생", stList);
//		maps.put("점수",scList);
//		maps.put("과목",sbList);
//		maps.put("View",scViewList);

		return maps;
	}

	@Override
	public String makeStNum(String prefix) {
		// TODO Auto-generated method stub
		String stNum = stDao.getMaxStNum();
		/*
		 * prefix만큼 문자열을 건너뛰고 나머지 부분을 추출하기 stNum = '20210010'이고 prefix = '2021'이라면 stSeq
		 * = stNum.subString(4) 이런 형식의코드가 생성되어 stSeq에는 0010 의 문자열만 남게된다
		 * 
		 */
		String stSeq = stNum.substring(prefix.length());

		log.debug("학번 seq : {}", stSeq);

		Integer intSeq = Integer.valueOf(stSeq) + 1;
		String newStNum = String.format("%s%04d", prefix, intSeq);

		log.debug("새로생성된 학번 {} : ", newStNum);

		return newStNum;
	}

	@Override
	public int insert(StudentVO stVO) {
//		String newStNum = this.makeStNum();
//		stVO.setSt_num(newStNum);
		return stDao.insert(stVO);
	}

	@Override
	public int update(StudentVO stVO) {
		return 0;
	}

	@Override
	public String makeStNum() {
//		현재 날짜에서 연도 문자열 생성하기
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sd = new SimpleDateFormat("yyyy");

		String curYear = sd.format(date);
		String newStNum = this.makeStNum(curYear);

		log.debug("현재 연도 {} ", "생성된 학번 {} ", curYear, newStNum);

		return newStNum;
	}

	@Override
	public String detail(Model model, String st_num) {

		String ret = null;

		List<SubjectAndScoreDTO> ssList = scDao.selectSubjcetAndScore(st_num);

		StudentVO stVO = stDao.findById(st_num);
		Integer scoreCount = scDao.scoreCount(st_num);
		Integer scoreSum = scDao.scoreSum(st_num);

		ret = ssList != null ? "OK" : "SS_FAIL";
		ret = stVO != null ? "OK" : "ST_FAIL";

		model.addAttribute("SSLIST", ssList);
		model.addAttribute("ST", stVO);
		model.addAttribute("SC_COUNT", scoreCount);
		model.addAttribute("SC_SUM", scoreSum);

		return ret;
	}

//	이 메서드가 실행될때는 transaction으로 인식시켜줌
//	한번이라도 exception을 발생하게되면
//	롤백하고 insert를 수행하지않는다
	/*
	 * transaction의 조건 다수의 CRUD는 한개의 업무 프로세스이다 다수의 CRUD가 모두 정상적으로 완료되어야만 업무가 정상적으로
	 * 수행된다
	 * 
	 * 업무가수행되는 동안 한곳이라도 CRUDa에서 오류가 발생하면 그중 CUD가 진행되는동안 문제가 발생하고 데이터의 오류가 저장될 것이다 이런
	 * 상황을 방지 하기위하여 업무 단위를 Transaction이라는 단위로 묶고
	 * 
	 * 모든 업무가 완려되면데이터를 commit (실제 저장)하고
	 * 
	 * 그렇지 않으면 Rollback ALL(모두 취소)하는 처리
	 * 
	 * 
	 * 
	 */
	@Transactional
	@Override
	public String scoreInput(ScoreInputVO scInputVO) {
		
		log.debug("Service {} : ", scInputVO.toString());

		int size = scInputVO.getSubject().size();
		String st_num = scInputVO.getSt_num();
//		for (int i = 0; i < size - 2; i++) {
//			scDao.insertOrUpdate(scInputVO.getSt_num(), scInputVO.getSubject().get(i), scInputVO.getScore().get(i));
//			scDao.insertOrUpdate(scInputVO.getSt_num(), scInputVO.getSubject().get(i), scInputVO.getScore().get(i));
//		}
		/*
		 * @Transactional 로 선언된 method에서 모든 데이터를 insertOrUdate를 수행한 다음 강제로 exception을
		 * 발생하였다
		 * 
		 * 그랬더니 transactionManager에 의해서 모든 Insert Or update가 롤백되었다
		 * 
		 */
//		이유 불문하고 무조건 RuntimeExceoption 발생시키
//		throw new RuntimeException();
//	Dao에 보낼 데이터를 변경하기
// 	과목 코드와 점수의 List를 담을 변수 선언 
		List<Map<String, String>> scoreMaps = new ArrayList<Map<String, String>>();
		for (int i = 0; i < size; i++) {
			String subject = scInputVO.getSubject().get(i);
			String score = scInputVO.getScore().get(i);

			Map<String, String> subjectScore = new HashMap<String, String>();
			subjectScore.put("subject", subject);
			subjectScore.put("score", score);
			scoreMaps.add(subjectScore);
		}
		scDao.insertOrUpdateForList(st_num, scoreMaps);
		return null; 
		
	}
}
