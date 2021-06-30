package com.callor.book.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.simple.parser.ParseException;

public interface NaverGenericService<T>{
	public String queryURL(String search_text);
	public String getJsonString(String queryURL) throws MalformedURLException, IOException;
	public List<T> getNaverList(String jsonString) throws ParseException;
}
