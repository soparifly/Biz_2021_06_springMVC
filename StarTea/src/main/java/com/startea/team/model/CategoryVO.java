package com.startea.team.model;

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
public class CategoryVO {
	private String menu_code;//	CHAR(5)		PRIMARY KEY,
	private String menu_name;//	varchar(200)	NOT NULL,
	private String menu_kinds;//	BIGINT
}
