package com.callor.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthorVO {
	private String au_code;//	CHAR(5)
	private String au_name;//	nVARCHAR2(50)
	private String au_tel;//	VARCHAR2(20)
	private String au_addr;//	nVARCHAR2(125)
	private String au_genre;//	nVARCHAR2(30)
}
