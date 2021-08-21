package com.universe.sopar.service.impl;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.universe.sopar.config.AstroSecret_sample;
import com.universe.sopar.service.AstroService;

@Service("astroServiceV1")
public class AstroInfoEventImplV1 implements AstroService {

	
		
	// API를 가져오는 코드와 정상작동되는지 확인하는 코드 
	public static void main(String[] args) throws IOException {
		// xml에 있는 astroEvent 태그의 값을 가져올 변수명을 초기화
		Node astroEvent = null;

		//		api 요청 서비스의 URL을 받아오기위해 주소 뷸드
		StringBuilder urlBuilder = new StringBuilder(
				AstroSecret_sample.astro_event_url
				); /*URL*/
		//		승인된 API 서비스 키를 입력하여 서버에 접속 원하는 데이터를 가져온다
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
				+ AstroSecret_sample.astro_event_service_key); /*Service Key*/
		//		요청연도
		urlBuilder.append("&" + URLEncoder.encode("solYear", "UTF-8") + "=" + URLEncoder.encode("2019", "UTF-8")); /*연*/
		//		요청월
		urlBuilder.append("&" + URLEncoder.encode("solMonth", "UTF-8") + "=" + URLEncoder.encode("09", "UTF-8")); /*월*/

		URL url = new URL(urlBuilder.toString());
		//		우리가 DB 에 접속하듯이 HTTpURL을 통해 공공데이터에서 URL로 요청해야한다 
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		//		api마다 지정방식이 있지만 여기서는 GET 방식으로 처리함		
		conn.setRequestMethod("GET");
		//		가져올 요청 속성
		conn.setRequestProperty("Content-type", "application/json");
		//		응답 코드
		System.out.println("Response code: " + conn.getResponseCode());

		//		한줄씩 읽어온다
		BufferedReader rd;
		// 		만약 요청한서비스의 코드가아래와 같을경우 처리방식
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}

		//		한줄씩 불러읽어온다 
		//		그리고 콘솔에 표시하여 잘읽어왔는지 확인
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
			//			콘솔에 잘표시됨
			System.out.println(sb.toString());
		}
		//		연결을 종료해준다 
		conn.disconnect();
		rd.close();

		try {
			// 읽어온 내역을 파일로 만드는 클래스		
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			//	프로젝트 폴더에 들어가면 해당 파일에 내용을 저장하고자한다
			FileOutputStream output = new FileOutputStream("./astroEvent");
			output.write(sb.toString().getBytes());
			output.close();
			//	
			Document doc = dBuilder.parse("./astroEvent");

			//	문서의 엘리멘트들을 정규화하는 작업
			doc.getDocumentElement().normalize();
			//	바디내부
			Element body = (Element) doc.getElementsByTagName("body").item(0);
			//	items 내부
			Element items = (Element) body.getElementsByTagName("items").item(0);
			//	item의 내부 
			//	body -> items -> item -> astroEvent 
			Element item = (Element) items.getElementsByTagName("item").item(0);
			astroEvent = item.getElementsByTagName("astroEvent").item(0);

			//	가장 첫번째의 이벤트내역을 가져와서 잘가져왔는지 확인후 콘솔에 표시
			System.out.println(astroEvent.getNodeName());
			System.out.println(astroEvent.getChildNodes().item(0).getNodeValue());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}