package com.universe.sopar.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import com.universe.sopar.config.AstroSecret_sample;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AstroInfoEventImplV2 {

	
		public String queryURL(String year, String month) {
			
			String solYear = null;
			String solMonth = null;

			try {
			
				solYear = URLEncoder.encode(year,"UTF-8");
				solMonth = URLEncoder.encode(month,"UTF-8");
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			StringBuilder queryURL = new StringBuilder();
			
			queryURL.append(AstroSecret_sample.astro_event_url);

			
			String queryString = String.format("&solYear=%s", solYear);
			queryURL.append(queryString);
			
			queryString = String.format("&solMonth=%d", solMonth);
			queryURL.append(queryString);
			
			log.debug("queryURL {} " + queryURL.toString());
			System.out.println("queryRUL {} "+ queryURL.toString());
			
			
				return queryURL.toString();
		}
		
		
		public String getXMLString(String queryURL) throws IOException {
			
			URL url = null;
			
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			
			httpConn.setRequestMethod("GET");
			
			httpConn.setRequestProperty(queryURL, queryURL);
			httpConn.setRequestProperty("ServiceKey", AstroSecret_sample.astro_event_service_key);
			
			httpConn.setRequestProperty("Content-type", "application/json");
			
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
				if(reader == null) {
					break;
				}
				sBuffer.append(reader);
				return sBuffer.toString();
				}
					
			return queryURL;
			
			
		}
	
}
