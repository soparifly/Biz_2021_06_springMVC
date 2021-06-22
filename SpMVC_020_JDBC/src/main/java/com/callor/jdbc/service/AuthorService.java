package com.callor.jdbc.service;

import java.util.List;

import com.callor.jdbc.model.AuthorVO;

public interface AuthorService {

	public List<AuthorVO> selectAll();
	public AuthorVO findByCode(String au_code);
	public List<AuthorVO> findByAName(String au_name);
	public List<AuthorVO> findByAtel(String au_tel);
	public List<AuthorVO> findByANameANDTel(String au_name);
}
