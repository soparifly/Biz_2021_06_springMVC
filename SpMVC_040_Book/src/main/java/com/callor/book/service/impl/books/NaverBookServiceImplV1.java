package com.callor.book.service.impl.books;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.callor.book.controller.config.NaverSecret;
import com.callor.book.model.BookDTO;
import com.callor.book.service.NaverBookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("naverBookServiceV1")
public class NaverBookServiceImplV1 implements NaverBookService {
	/*
	 * naver에 요청하기 bookURL + "?query=" + 검색 문자열
	 * 
	 */

// <정리>
// url을 만들기위해서 검색문자열을 encoder로 인코딩했고
//	문자열에 Stringvuilder 클래스를 사용해서 
//	"sql += " 대신에 사용하여 appender를 사용하여 문자열을 하나씩 추가시킴
// .toString을 이용해서 문자열화 하는것 

	public String queryURL(String search) {

//		검색하고자 하는 문자열을 UTF-8로 인코딩
		String searchUTF8 = null;

		try {
			searchUTF8 = URLEncoder.encode(search, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		StringBuilder queryURL = new StringBuilder();

		queryURL.append(NaverSecret.NURL.BOOK); // queryString += BookURL

		String queryString = String.format("?query=%s", searchUTF8);
		queryURL.append(queryString);

		queryString = String.format("&display=%d", 20);
		queryURL.append(queryString);

		log.debug(queryURL.toString());

		return queryURL.toString();
	}

//	queryRUL 을 받아서 
	@Override
	public String getJsonString(String queryURL) throws IOException {
		// TODO Auto-generated method stub

//		API를 통하여 다른 서버에 Request를 보낼때 사용할 객체
		URL url = null;

//		Http 프로토콜을 통하여 다른 서버에 연결할때 사용할 객체
		HttpURLConnection httpConn = null;
//			queryURL 주소를 Request 정보로 변환
			url = new URL(queryURL);
			
			httpConn = (HttpURLConnection) url.openConnection();

//			naver가 어떤 응답을 할것인지를 미리 확인하는 
//			코드를 요청한다
//			요청하는 method Get으로 설정하기
			httpConn.setRequestMethod("GET");
			//TODO
			httpConn.setRequestProperty("X-Naver-Client-ID", NaverSecret.NAVER_CLIENT_ID);
			httpConn.setRequestProperty("X-Naver-Client-Secret", NaverSecret.NAVER_CLIENT_SECRET);
			
			int httpStatusCode = httpConn.getResponseCode();
			
//			naver로부터 데이터를 수신할 객체
			InputStreamReader is =  null;
			if(httpStatusCode == 200) {
				
				is = new InputStreamReader(httpConn.getInputStream());
			} else {
				is = new InputStreamReader(httpConn.getErrorStream());
				
			}
//			is를 buffer에 연
			BufferedReader buffer= null;
			buffer = new BufferedReader(is);
		
			/* StringBuilder, StringBuffer
			 * 
			 * String 형의 데이터 += 처럼
			 * 사용할때 발생하는 메모리 leak, 성능저하 문제를 해결하기 위하여 탄생된 클래스
			 * 
			 * String 형의 데이터를 += gkaus 
			 * ex ) 다음과 같은 코드를 반복하면
			 * 
			 * String str ="대한민국"
			 * str += "Korea"
			 * str += "Republic"
			 * 
			 * 내부적으로는 str변수를 생성, 제거, 생성, 제거,하는 코드가 반복적으로 수행된다
			 * 
			 * 이러한 현상이 반복되면 메모리에 문제가 발생할 수 있다
			 * 그러한 문제를 해결하기위하여 탄생한 클래스
			 * 
			 * 겉으로 보기에는 두개 클래스 역할과 사용법이 똑같다
			 * Stringbuilder는 singthread에서 최적화 되어있다
			 * Stringbufferd는 multithread에서 안전하다
			 *
			 *
			 */
			StringBuffer sBuffer = new StringBuffer();
			while(true) {
				String reader = buffer.readLine();
				if(reader == null) {
					break;
				}
				sBuffer.append(reader);
			}
			log.debug("json {} ",sBuffer.toString());
			return sBuffer.toString();
	}
/*
 *네이버에서 받은 JsonString 을 parsing gkdu 
 * List<BookDTO>에 담아 return 하기
 * json-simple을 사용하여 parsing하기 
 * 
 */
	@Override
	public List<BookDTO> getNaverList(String jsonString) throws ParseException {
		// TODO Auto-generated method stub
		log.debug("나는 ServiceV1");
//		1. json Parsing 도구 선언
		JSONParser jParser = new JSONParser();
			JSONObject jObject = (JSONObject) jParser.parse(jsonString);
			
			JSONArray items = (JSONArray)jObject.get("items");
			
			List<BookDTO> bookList = new ArrayList<BookDTO>();
			
			int nSize =  items.size();
			for (int i = 0; i < nSize ; i++) {
				
				
				JSONObject item = (JSONObject) items.get(i);

				
				//			한권의 도서정보가 담긴 객체 추출
				String title = (String) item.get("title");		//	string	검색 결과 문서의 제목을 나타낸다. 제목에서 검색어와 일치하는 부분은 태그로 감싸져 있다.
				String link= (String) item.get("link");			//	string	검색 결과 문서의 하이퍼텍스트 link를 나타낸다.
				String author = (String) item.get("author");		//	string	저자 정보이다.
				String image=(String) item.get("image");			//	string	썸네일 이미지의 URL이다. 이미지가 있는 경우만 나타납난다.
				String price=(String) item.get("price");			//	integer	정가 정보이다. 절판도서 등으로 가격이 없으면 나타나지 않는다.
				String discount=(String) item.get("discount");		//	integer	할인 가격 정보이다. 절판도서 등으로 가격이 없으면 나타나지 않는다.
				String publisher=(String) item.get("publisher");		//	string	출판사 정보이다.
				String isbn=(String) item.get("isbn");			//	integer	ISBN 넘버이다.
				String description=(String) item.get("description");	//	string	검색 결과 문서의 내용을 요약한 패시지 정보이다. 문서 전체의 내용은 link를 따라가면 읽을 수 있다. 패시지에서 검색어와 일치하는 부분은 태그로 감싸져 있다.
				String pubdate=(String) item.get("pubdate");
			
				BookDTO bookDTO = BookDTO.builder()
									.title(title) 
									.link(link)
									.author(author)
									.price(price)
									.image(image)
									.publisher(publisher)
									.discount(discount)
									.isbn(isbn)
									.description(description)
									.pubdate(pubdate)
									.build();
//				List에 add하기
				bookList.add(bookDTO);
			}
			log.debug(bookList.toString());
			return bookList;
		
	}

}
