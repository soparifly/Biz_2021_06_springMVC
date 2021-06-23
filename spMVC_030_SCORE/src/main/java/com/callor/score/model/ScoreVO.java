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
public class ScoreVO {
private Long sc_seq;//	BIGINT		PK
private String	sc_stnum;//	CHAR(8)	NOT NULL	
private String	sc_sbcode;//	VARCHAR(20)	NOT NULL	
private String sc_score;//	INT	NOT NULL	
}
