package com.callor.score.model;

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
public class SubjectAndScoreDTO {

	private String ss_code;
	private String ss_stname;
	private String ss_prof;
	private String ss_scode;
	private int ss_score;
}
