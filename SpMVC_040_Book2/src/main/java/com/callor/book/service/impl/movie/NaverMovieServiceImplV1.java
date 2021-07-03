package com.callor.book.service.impl.movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.callor.book.controller.config.NaverQualifier;
import com.callor.book.controller.config.NaverSecret;
import com.callor.book.model.MovieDTO;
import com.callor.book.service.NaverAbstractService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
//JsonParser는 google이어야
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(NaverQualifier.NAVER_MOVIE_SERVICE_V1)
public class NaverMovieServiceImplV1 extends NaverAbstractService<MovieDTO> {
	
	
	public String queryURL(String search) throws UnsupportedEncodingException {
		String searchUTF8 = null;
		
			searchUTF8 = URLEncoder.encode(search, "UTF-8");
		
		StringBuilder queryURL = new StringBuilder();

		queryURL.append(NaverSecret.NURL.MOVIE);

		String queryString = String.format("?query=%s", searchUTF8);
		queryURL.append(queryString);

		queryString = String.format("&display=%d", 20);
		queryURL.append(queryString);

		log.debug(queryURL.toString());

		return queryURL.toString();
	}
	public String getJsonString(String queryURL) throws IOException {
		
		URL url = null;
		HttpURLConnection httpConn = null;
		url = new URL(queryURL);
		httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("GET");
		httpConn.setRequestProperty("X-Naver-Client-ID", NaverSecret.NAVER_CLIENT_ID);
		httpConn.setRequestProperty("X-Naver-Client-Secret", NaverSecret.NAVER_CLIENT_SECRET);

		int httpStatusCode = httpConn.getResponseCode();
		InputStreamReader is = null;
		if (httpStatusCode == 200) {
			is = new InputStreamReader(httpConn.getInputStream());
		} else {
			is = new InputStreamReader(httpConn.getErrorStream());
		}
		BufferedReader buffer = null;
		buffer = new BufferedReader(is);
		StringBuffer sBuffer = new StringBuffer();
		while (true) {
			String reader = buffer.readLine();
			if (reader == null) {
				break;
			}
			sBuffer.append(reader);
		}
		log.debug("json {} ", sBuffer.toString());
		return sBuffer.toString();
	}

	/*
	 * gSon 을 사용하여 json String 을 List<MovieDTO>로 변환하기
	 * 
	 */
	public List<MovieDTO> getNaverList(String jsonString) throws ParseException {
		log.debug("jsonString {} ", jsonString);

//		element로 변환하기 
		JsonElement jSonElement 
			= JsonParser.parseString(jsonString);

		JsonElement oItems 
			= jSonElement.getAsJsonObject().get("items");

		Gson gson = new Gson();
		
		TypeToken<List<MovieDTO>> typeToken 
			= new TypeToken<List<MovieDTO>>() { };

		List<MovieDTO> movieList 
			= gson.fromJson(oItems, typeToken.getType());
		
		
		return movieList;
	}
}
